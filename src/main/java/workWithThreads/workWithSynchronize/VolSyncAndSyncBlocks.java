package workWithThreads.workWithSynchronize;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class VolSyncAndSyncBlocks implements Runnable {

    private static volatile boolean isRunning; //Данная переменная имеет ключевое слово volatile, чтобы она не кэшировалась в потоке,
    // иначе при желании ее изменить, возникнут трудности, ключевое слово, не позволяет кешировать данную переменную
    private static final int length = 1000000;
    private static final ArrayList<String> arr = new ArrayList<>();
    private static int count;

    static {
        isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            count++;
        }
    }
    public static void stop() {
        isRunning = false;
    }

    public static synchronized void en() { // Ключевое слово synchronized не позволяет потокам обращаться к данному методу вразнобой. Она организует очередь,
        // при которой каждый поток обратится к методу в момент, когда другие потоки не будут его занимать,
        // иначе возникнут ошибки добавления, и получится неверное конечное число или выскочат ЭКСПЕШОНЫ.
        for (int i = 0 ; i < length; i++) {
            arr.add("code");
        }
        System.out.println(arr.size());
    }

    public static void moreCorrectEn() { // Более правильна версия метода сверху, так как синхронизируется только та часть,
        // которая подвержена тому, чтобы быть рассинхронизированной.
        for (int i = 0 ; i < length; i++) {
            synchronized (arr) {
                arr.add("code");
            }
        }
        System.out.println(arr.size());
    }

    public static void main(String[] args) throws InterruptedException {
        WrongEx wrongEx = new WrongEx();
        new Thread(new VolSyncAndSyncBlocks()).start();
        //new Thread(wrongEx).start(); // Раскоментить, чтобы увидеть неправильный код.
        TimeUnit.SECONDS.sleep(2);
        stop();
        //WrongEx.wrongStop(); // Раскоментить, чтобы увидеть неправильный код.
        System.out.println(count);
        System.out.println("=====================================================");
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            //threads.add(new Thread(VolSyncAndSyncBlocks::en)); // Раскоментить, чтобы увидеть тоже рабочий код.
            threads.add(new Thread(VolSyncAndSyncBlocks::moreCorrectEn));
            //threads.add(new Thread(WrongEx::wrongEn)); // Раскоментить, чтобы увидеть неправильный код.
        }
        threads.forEach(Thread::start);
    }
}
