package com.example.shang.adapterdemo;

/**
 * Created by shang on 2017/12/3.
 */

// 对象适配器，不是继承Adaptee类，而是使用代理连接
public class VoltAdapter2 implements FiveVolt {
    @Override
    public int getVolt5() {
        return 5;
    }

    Volt220 mVolt220;

    public VoltAdapter2(Volt220 volt220){
        mVolt220 = volt220;
    }

    public int getVolt220(){
        return mVolt220.getVolt220();
    }
}
