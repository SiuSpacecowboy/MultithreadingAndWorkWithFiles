package workWithThreads.executorAndOth;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {

    public static void main(String[] args) { // Класс имеет удобные методы для работы с результатами, которые надо выдавать периодично.
        ScheduledExecutorService service1 = Executors.newScheduledThreadPool(5);
        service1.schedule(() -> System.out.println("Long_dark_night"), 2, TimeUnit.SECONDS); // Выведет через 2 сек.
        ScheduledExecutorService service2 = Executors.newScheduledThreadPool(5);
        service2.scheduleAtFixedRate(() -> System.out.println("Day_will_come"), 3, 2, TimeUnit.SECONDS); // Будет выводить каждые 2 секунды,
                                                                                                                    // через 3 секунды после запуска потока.
        ScheduledExecutorService service3 = Executors.newScheduledThreadPool(5);
        service3.scheduleWithFixedDelay(() -> System.out.println("They_are_coming"), 1, 3, TimeUnit.SECONDS); // Будет выводить каждые 3 секунды,
                                                                                                                        // через 1 секунду после результата потока.
        //service.shutdown();
    }
}
