package com.example.dust.persondemo.factory;

/**
 * Created by dust on 2017/4/24.
 */

public class YellowHuman implements Human {
    public void cry() {
        System.out.println("黄色人种会哭");
    }
    public void laugh() {
        System.out.println("黄色人种会大笑，幸福呀！");
    }
    public void talk() {
        System.out.println("黄色人种会说话，一般说的都是双字节");
    }

}
