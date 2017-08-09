package com.example.dust.persondemo.testbyjava;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class Test1{


 public static void main(String[] args) {

//
//  System.out.println ("第五题  ----------------------------");
//
//    //我开始觉得 应该是 97  和 98   结果呢  a  a1
//
//    System.out.println('a');
//    System.out.println('a'+1);
//
//     System.out.println ( "第六题  ----------------------------");
//
//    System.out. println("hello"+'a'+1);
//    System.out.println('a'+1+"hello");

//------------------------------------------------------------------------


     List<String> staff = new LinkedList<>();
     staff.add("A1");
     staff.add("B1");
     staff.add("C1");
     ListIterator<String> iter = staff.listIterator();
     String first = iter.next();

     //删除zhuwei
//     iter.remove();

     //把zhuwei改为simei
     iter.set("simei");
     System.out.println("first:"+first);

//     iter.add("xiaobai");

     //遍历List元素
     System.out.println("遍历List中元素，方法一：");
     for(String str : staff)
         System.out.println(str+"   ");

     iter = staff.listIterator();
     System.out.println("遍历List中元素，方法二：");
     while(iter.hasNext())
     {
         System.out.println(iter.next());
     }

     while(iter.hasPrevious())
     {
         System.out.println(iter.previous());
     }


 }





}