package com.jeson.singleton.type5;

import java.util.concurrent.TimeUnit;

/**
 * 优缺点说明：
 * 1) 这种方式，本意是想对第四种实现方式的改进，因为前面同步方法效率太低，改为同步产生实例化的的代码块
 * 2) 但是这种同步并不能起到线程同步的作用。跟第3种实现方式遇到的情形一致（com.jeson.singleton.type3.SingletonTest03），假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例
 * 3) 结论：在实际开发中，不能使用这种方式
 */
public class SingletonTest05 {
    public static void main(String[] args) throws InterruptedException {
        //测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());

        //测试线程安全的一段代码
//        new Thread(() -> {
//            try {
//                Singleton a = Singleton.getInstance();
//                System.out.println(a.hashCode());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        new Thread(() -> {
//            try {
//                Singleton b = Singleton.getInstance();
//                System.out.println(b.hashCode());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();
    }
}

/**
 * 懒汉式(线程不安全，同步代码块)
 */
class Singleton {

    // 1. 构造器私有化, 防止外部能new
    private Singleton() {}

    // 2.本类内部创建对象实例
    private static Singleton instance;

    // 3. 提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        if(instance ==null) {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }

}
