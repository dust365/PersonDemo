package com.example.dust.persondemo.factory;

/**
 * Created by dust on 2017/4/24.
 */

public class BlackHuman implements Human {
    @Override
    public void cry() {
        System.out.println("黑人会哭");
    }

    public void laugh() {
        System.out.println("黑人会笑");
    }
    public void talk() {
        System.out.println("黑人可以说话，一般人听不懂");

    }
}
