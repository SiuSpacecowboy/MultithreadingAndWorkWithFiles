package workWithThreads.safeClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedObj {

    // Данные классы являются потокобезопасными классами, с которыми можно работать без синхронизации методов,
    // использовавшие данные объекты класса, т.к. все их классы внутри как раз реализуют синхронизацию.
    // Данные классы работают медленнее своих потокоопасных аналогов, поэтому нужно понимать, когда их использовать.
    private static final Vector<String> vector = new Vector<>();
    private static final StringBuffer buffer = new StringBuffer();
    private static final Hashtable<Integer, Integer> table = new Hashtable<>();
    //private static Collections.synchronizedCollection() // Можно создавать их коллекции так, внутри есть все аналоги.

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    vector.add(String.valueOf(j));
                }
                System.out.println(vector.size());
            }).start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println("==============================================================");
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    buffer.append("a");
                }
                System.out.println(buffer.length());
            }));
        }
        threads.forEach(Thread::start);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("==============================================================");
        AtomicInteger c = new AtomicInteger(0);
        AtomicInteger w = new AtomicInteger(0);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = c.get() + w.intValue() * 100000; j <  (w.intValue() + 1) * 100000; j++) {
                    table.put(j, (w.intValue() + 1) * 1000000 - j);
                    c.getAndIncrement();
                }
                c.set(0);
                w.incrementAndGet();
                System.out.println(table.size());
            }).start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println("==============================================================");
    }
}
