package multithreading;

import java.util.concurrent.Semaphore;

public class AlternatePrint {

    private static Semaphore[] semaphores;
    private static final int THREAD_NUM = 3;
    private static final int PRINT_NUM = 10;


    public static void main(String[] args) {

        semaphores = new Semaphore[THREAD_NUM];

        for (int i = 0; i < THREAD_NUM; i++) {
            semaphores[i] = new Semaphore(0);
        }

        semaphores[0].release();

        for (int i = 0; i < THREAD_NUM; i++) {

            final int cur = i;
            final int next = (i + 1) % THREAD_NUM;

            new Thread(() -> {

                for (int j = 0; j < PRINT_NUM; j++) {

                    try {
                        semaphores[cur].acquire();
                        char c = (char) ('A' + cur);
                        System.out.println(c);
                        semaphores[next].release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }).start();
        }
    }
}
