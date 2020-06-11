package DesignPattern.SingletonPattern;

/***
 * 双检锁/双重校验锁  单例模式
 */
public class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance(){
        if (singleton == null){
            //多线程时
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton= new Singleton();
                }

            }
        }
        return singleton;
    }
}
