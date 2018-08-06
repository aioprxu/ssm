package com.aiopr.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws Exception{
        System.out.println(getEntry().getId()+getEntry().getName());
    }

    public static Entry getEntry() throws Exception{
        Class<?> clazz = Class.forName("com.aiopr.reflect.Entry");
        Object obj = clazz.newInstance();
        Field[] files = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();
        for (Field field : files) {
            field.setAccessible(true);
            System.out.println(field);
            if(field.getName().equals("id")){
                field.set(obj,"100");
            }
            else field.set(obj,"ssss");
        }
        for (Method method : methods) {
            System.out.println(method);
        }
        return (Entry) obj;
    }

}
