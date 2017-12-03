# AdapterDemo

1、介绍： 

说到底，适配器就是将两个不兼容的类融合在一起。它有点像粘合剂，将不同的东西通过一种转换使得它们能够协作起来。

2、定义 ： 

适配器模式是把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作

3、使用场景：

（1）系统需要使用现有的类，而此类的接口不符合系统的需要，而接口不兼容

（2）想要建立一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类，包括一些可能将来引进的类一起工作。

（3）需要一个统一的输出接口，而输入端的类型不可预知。

4、UML类图

类适配器，通过实现Target接口和继承Adapter类实现接口转换。

![](https://i.imgur.com/5kl1g3h.png)

对象适配器，不是使用继承关系而是使用代理的方法连接到Adaptee类。

![](https://i.imgur.com/PtnlSl1.png)

用电源接口做例子，笔记本的电源一般是5V，而我们的生活用电一般为220V，所以需要适配器来进行一个接口转换。

5、代码示例：

Target类

	public interface FiveVolt {
    	int getVolt5();
	}


Adaptee类

	public class Volt220 {
   		public int getVolt220(){
       		 return 220;
    	}
	}


Adapter类

	
	// 类适配器，继承Adaptee类和实现Target接口
	public class VoltAdapter1 extends Volt220 implements FiveVolt {
	    @Override
	    public int getVolt5() {
	        return 5;
	    }
	}


Adapter类2

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

6、在Android中的使用，典型就是ListView 的Adapter

7、优缺点：

优点

（1） 更好的复用性

系统需要使用现有的类，而此类的接口不符合系统的需要。那么通过适配器模式就可以让这些功能得到更好的复用。

（2） 更好的扩展性

在实现适配器功能的时候，可以调用自己开发的功能，从而自然地扩展系统的功能。

缺点：
 
 过多地使用适配器，会让系统非常零乱，不易把握整体。
