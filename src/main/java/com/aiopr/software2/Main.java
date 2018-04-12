package com.aiopr.software2;

import java.io.*;
import java.util.Random;

/**
 * Created by Administrator on 2018/4/12.
 */
public class Main {

    public static void main(String[] args) {
        produce(10,10,'-',"int");
        produce(10,10,'+',"float");
    }

    public static String generate(char c,String flag,int max){
        if(flag=="float"){
            Random random = new Random(1000000);
            StringBuilder str = new StringBuilder();
            str.append(random.nextFloat()*(10000000)%max);
            str.append(c);
            str.append(random.nextFloat()*(10000000)%max);
            return str.toString();
        }
        else if(flag=="int"){
            Random random = new Random();
            StringBuffer str = new StringBuffer();
            str.append(Math.abs(random.nextInt()%max));
            str.append(c);
            str.append(Math.abs(random.nextInt()%max));
            return str.toString();
        }
        else return "error";
    }



    public static void produce(int n,int max,char c,String flag){
        for(int i=0;i<n;i++){
            createFile("D:/test.txt");
            writeFile("D:/test.txt",generate(c,flag,max));
        }
    }
    /*
    *以追加方式写文件
    */
    private static void writeFile(String filePath, String conent) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true)));
            out.write(conent+"=");
            out.newLine();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    *创建文件
    */
    public static void createFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            //System.out.println("文件已存在");
        } else {
            try {
                File fileParent = file.getParentFile();
                if (fileParent != null) {
                    if (!fileParent.exists()) {
                        fileParent.mkdirs();
                    }
                }
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
