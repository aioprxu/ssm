package com.aiopr.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;

public class Client {
    public static void main(String[] args) {

        //worker负责读写数据
        EventLoopGroup worker = new NioEventLoopGroup();

        try {
            //辅助启动类
            Bootstrap bootstrap = new Bootstrap();

            //设置线程池
            bootstrap.group(worker);

            //设置socket工厂
            bootstrap.channel(NioSocketChannel.class);

            //设置管道
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    //获取管道
                    ChannelPipeline pipeline = socketChannel.pipeline();
                    //字符串解码器
                    pipeline.addLast(new StringDecoder());
                    //字符串编码器
                    pipeline.addLast(new StringEncoder());
                    //处理类
                    pipeline.addLast(new HelloClientIntHandler());
                }
            });

            //发起异步连接操作
            ChannelFuture futrue = bootstrap.connect(new InetSocketAddress("127.0.0.1",8866)).sync();

            //等待客户端链路关闭
            futrue.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //优雅的退出，释放NIO线程组
            worker.shutdownGracefully();
        }
    }

}

class HelloClientIntHandler extends ChannelInboundHandlerAdapter {



    // 接收server端的消息，并打印出来
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String mm = (String) msg;
        byte result1[] = mm.getBytes();
        System.out.println("Server said:" + new String(result1));
    }

    // 连接成功后，向server发送消息
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String msg = in.readLine();
        ByteBuf encoded = ctx.alloc().buffer(4 * msg.length());
        encoded.writeBytes(msg.getBytes());
        ctx.write(encoded);
        ctx.flush();
    }
}