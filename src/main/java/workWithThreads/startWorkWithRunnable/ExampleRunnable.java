package workWithThreads.startWorkWithRunnable;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ExampleRunnable {

    public static void main(String[] args) {
        byte[] arr1 = "Я не хочу играть в танки".getBytes(StandardCharsets.UTF_8);
        byte[] arr2 = "Я тут байтбуффер один??".getBytes(StandardCharsets.UTF_8);
        ByteBuffer res1 = ByteBuffer.wrap(arr1);
        ByteBuffer res2 = ByteBuffer.wrap(arr2);
        new Thread(new ImpRunnable(res1)).start();
        /** Если это раскоментить, то два раза выведет arr2, скорее всего Bytebuffer таким созданием может быть только один???*/
        //new Thread(new ImpRunnable(res2)).start();
        new Thread(() -> Arrays.asList(new String(arr2, StandardCharsets.UTF_8).split(" "))
                .forEach(System.out::println)).start(); // Интерфейс Runnable является функциональным, можно создать lambda-выражение

    }
}
