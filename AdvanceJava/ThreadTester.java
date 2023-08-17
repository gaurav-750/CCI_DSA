package AdvanceJava;

public class ThreadTester {
    public static void main(String[] args) {

        System.out.println("Start!");

        //by extending 'Thread' class
        Thread thread1 = new Thread1("thread1");
        thread1.start();

        //by implementing 'Runnable' interface
        Thread thread2 = new Thread(new Thread2(), "thread2");
        thread2.start();

        System.out.println("Exit!");

    }
}
