package com.jeson.singleton.type3;

import java.util.concurrent.TimeUnit;

/**
 * 1) 起到了Lazy Loading的效果，但是只能在单线程下使用。
 * 2) 如果在多线程下，一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式
 * 3) 结论：在实际开发中，不要使用这种方式.
 */
public class SingletonTest03 {
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
 * 懒汉式(线程不安全)
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
            instance = new Singleton();
        }
        return instance;
    }

}
