package com.example.dust.persondemo.testbyjava;


/**
 * @author dust
 * @function   java 基础测试类
 * @created at 2017/8/31
 */

public class Test3 {




    //关于  return  和   break   和   continue   的区别 ？
    //1return 结束  当前的方法退出吧，  并且可以返回结果值

    //2.break   中断本循环和方法


    //3.continue   仅仅结束本次循环





    public static void main(String[] args) {


        for (char i = 0; i < 128; i++) {



            if (Character.isLowerCase(i)){

//                System.out.println("value="+(int)i+"  character=="+i);

            }

            if (i==10) continue;
            System.out.println("value="+(int)i+"  character=="+i);


        }








    }




}
