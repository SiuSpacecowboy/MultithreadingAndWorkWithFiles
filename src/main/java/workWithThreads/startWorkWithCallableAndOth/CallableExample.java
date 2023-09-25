package workWithThreads.startWorkWithCallableAndOth;

import com.fasterxml.jackson.core.JsonGenerator;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableExample {

    public static void main(String[] args) throws Exception{
        byte[] bytes = new byte[10];
        Callable callable = () -> { // Особенностью данного интерфейса является, в отличие от Runnable, возможность возвращать значение (return).
            // Помимо этого, есть возможность вызывать Exceptions внутри самой реализации Callable.
            new Random().nextBytes(bytes);
            return new String(bytes, StandardCharsets.UTF_8);
        };
        FutureTask futureTask = new FutureTask<>(callable); // Помогает нам работать с Callable, является удобным контейнером, для результата потока.
        // Отменяемое асинхронное вычисление. Этот класс предоставляет базовую реализацию Future,
        // с методами для запуска и отмены вычисления, запроса на завершение вычисления и получения результата вычисления.
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

    }
}
