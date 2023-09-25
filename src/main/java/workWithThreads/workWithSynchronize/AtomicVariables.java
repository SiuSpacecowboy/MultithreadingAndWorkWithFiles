package workWithThreads.workWithSynchronize;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariables {

    private static AtomicInteger res = new AtomicInteger();

    public static void inc() {
        res.incrementAndGet();
    }

    public static int getInc() {
        return res.intValue();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000000; j++) {
            /**Если раскоментить данный пример, можно увидеть, как работают потоки не с атомарными переменными,
             * если пытаются обратиться к ним одновременно */
                    //WrongEx.cre();
                    AtomicVariables.inc();
                }
                System.out.println(AtomicVariables.getInc());
               //System.out.println(WrongEx.ge()); //Соответственно вывод.
            }).start();
        }
    }
}
