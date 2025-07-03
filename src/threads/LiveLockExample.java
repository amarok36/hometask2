package threads;

public class LiveLockExample {
    private static final Object lock = new Object();
    private static boolean isThread1Working = true;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (!isThread1Working) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("1");
                    isThread1Working = false;
                    lock.notify();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (isThread1Working) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("2");
                    isThread1Working = true;
                    lock.notify();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}