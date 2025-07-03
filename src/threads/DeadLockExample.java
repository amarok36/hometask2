package threads;

public class DeadLockExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Поток 1: удержание ресурса 1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Поток 1: Ожидание ресурса 1...");
                synchronized (lock2) {
                    System.out.println("Поток 1: полученный ресурс 2!");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Поток 2: удержание ресурса 2...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Поток 2: Ожидание ресурса 2...");
                synchronized (lock1) {
                    System.out.println("Поток 2: полученный ресурс 1!");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}