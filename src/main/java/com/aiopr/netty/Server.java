package com.aiopr.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception {

        //boss线程监听端口，worker线程负责数据读写
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        try{
            //辅助启动类
            ServerBootstrap bootstrap = new ServerBootstrap();
            //设置线程池
            bootstrap.group(boss,worker);

            //设置socket工厂
            bootstrap.channel(NioServerSocketChannel.class);

            //设置管道工厂
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    //获取管道
                    ChannelPipeline pipeline = socketChannel.pipeline();
                    //字符串解码器
                    pipeline.addLast(new StringDecoder());
                    //字符串编码器
                    pipeline.addLast(new StringEncoder());
                    //处理类
                    pipeline.addLast(new HelloServerInHandler());
                }
            });

            //设置TCP参数
            //1.链接缓冲池的大小（ServerSocketChannel的设置）
            bootstrap.option(ChannelOption.SO_BACKLOG,1024);
            //维持链接的活跃，清除死链接(SocketChannel的设置)
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE,true);
            //关闭延迟发送
            bootstrap.childOption(ChannelOption.TCP_NODELAY,true);

            //绑定端口
            ChannelFuture future = bootstrap.bind(8866).sync();
            System.out.println("server start ...... ");

            //等待服务端监听端口关闭
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //优雅退出，释放线程池资源
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

}


class HelloServerInHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String result = (String) msg;
        byte[] result1 = result.getBytes();
        // msg中存储的是ByteBuf类型的数据，把数据读取到byte[]中
        String resultStr = new String(result1);
        // 接收并打印客户端的信息
        System.out.println("Client said:" + resultStr);

        // 向客户端发送消息
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String response = in.readLine();
        // 在当前场景下，发送的数据必须转换成ByteBuf数组
        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
        encoded.writeBytes(response.getBytes());
        ctx.write(encoded);
        ctx.flush();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}