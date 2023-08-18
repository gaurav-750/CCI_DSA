package AdvanceJava;

public class ThreadTester {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Start!");

        //by extending 'Thread' class
//        Thread thread1 = new Thread1("thread1");
//        thread1.start();
//
//        //by implementing 'Runnable' interface
//        Thread thread2 = new Thread(new Thread2(), "thread2");
//        thread2.start();


//        Stack stack = new Stack(5);
//
//        Thread thread1 = new Thread(() -> {
//            int counter = 0;
//            while (counter < 10){
//                System.out.println("Pushed: " + stack.push(100));
//                counter++;
//            }
//        }, "Pusher");
//        thread1.start();
//
//
//        Thread thread2 = new Thread(() -> {
//            int counter = 0;
//            while (counter < 10){
//                System.out.println("Popped: " + stack.pop());
//                counter++;
//            }
//        }, "Popper");
//        thread2.start();


        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("---Hello---");
                try {Thread.sleep(1000);}catch (Exception e){}
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi");
                try {Thread.sleep(1000);}catch (Exception e){}
            }
        });


        t1.start();
//        t1.join(2000);
        t2.start();

        t1.join();
        t2.join();
        System.out.println(t1.isAlive());
        //so the main thread will wait for t1 and t2 threads to complete, and then it'll resume

        System.out.println("Exit!");

    }
}
