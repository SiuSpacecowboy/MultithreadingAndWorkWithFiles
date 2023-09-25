package workWithThreads.waitAndNotify;

import java.util.concurrent.atomic.AtomicInteger;

public class WaitAndNotify {

    private final int quiversSpace = 1000;
    private int arrows = 50;

    /* Особенность методов wait и notify заключается в том, что они работают только в синхронизированных элементах(методы, объекты и т.д.).
    // Скорее всего это связанно с тем, что при вызове одного из методов, он вклинивается в область применения другого потока, из чего следует вывод, что
    wait и notify работают только если они синхронизируются вокруг одного и того же объекта. */
    public synchronized void shot() {
       if (arrows == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        arrows--;
        System.out.println("Выстрел. Стрел осталось: " + arrows);
        notify(); // Будит поток magicRetrieval.
    }

    public synchronized void magicRetrieval() {
        if (quiversSpace - arrows == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            arrows++;
        System.out.println("Возвращена стрела. Стрел стало: " + arrows);
        notify(); // Будит поток shot().*/
    }
}
