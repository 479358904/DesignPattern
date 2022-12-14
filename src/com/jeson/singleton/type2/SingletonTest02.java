package com.jeson.singleton.type2;

/**
 * 优缺点说明：
 * 1) 这种方式和上面的方式其实类似（com.jeson.singleton.type1.SingletonTest01），只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优缺点和上面是一样的。
 * 2) 结论：这种单例模式可用，但是可能造成内存浪费
 */
public class SingletonTest02 {

    public static void main(String[] args) {
        //测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

/**
 * 饿汉式(静态变量)
 */
class Singleton {

    // 1. 构造器私有化, 防止外部能new
    private Singleton() {}

    // 2.本类内部创建对象实例
    private static Singleton instance;

    // 在静态代码块中，创建单例对象
    static {
        instance = new Singleton();
    }

    // 3. 提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }

}

