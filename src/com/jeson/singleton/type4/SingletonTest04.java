package com.jeson.singleton.type4;

/**
 * 优缺点说明：
 * 1) 解决了线程不安全问题
 * 2) 效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了。方法进行同步效率太低
 * 3) 结论：在实际开发中，不推荐使用这种方式
 */
public class SingletonTest04 {
    public static void main(String[] args) throws InterruptedException {
        //测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}

/**
 * 懒汉式(线程安全，同步方法)
 */
class Singleton {

    // 1. 构造器私有化, 防止外部能new
    private Singleton() {}

    // 2.本类内部创建对象实例
    private static Singleton instance;

    // 3. 提供一个公有的静态方法，返回实例对象
    public static synchronized Singleton getInstance() {
        if(instance ==null) {
            instance = new Singleton();
        }
        return instance;
    }

}
