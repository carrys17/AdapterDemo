package com.example.shang.adapterdemo;

/**
 * Created by shang on 2017/12/3.
 */

// 类适配器，继承Adaptee类和实现Target接口
public class VoltAdapter1 extends Volt220 implements FiveVolt {
    @Override
    public int getVolt5() {
        return 5;
    }
}
