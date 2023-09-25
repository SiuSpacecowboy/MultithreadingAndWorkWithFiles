package workWithThreads.executorAndOth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.*;

public class ExecutorExecutorsServ {

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        String str1 = Files.readString(Paths.get("data/work.txt"));
        //Объект, который выполняет отправленные Runnable задачи. Этот интерфейс позволяет отделить отправку задачи от механики выполнения каждой задачи,
        // включая сведения об использовании потоков, планировании и т. д. Executor Обычно вместо явного создания потоков используется An.
        Executor executor = Executors.newSingleThreadExecutor(); // Класс ExecutorS используется для того, чтобы очень удобно создавать пулы потоков.
        // Данная задача автоматизирует выбор и использование оптимального количества потоков, (ведь поток в Java = поток в Компе??? Чел сказал).
        executor.execute(() -> { // Метод для старта потока. Только для Runnable задач.
            for (int  i = 0; i < str1.length(); i++) {
                System.out.print(str1.charAt(i));
            }
    });
        ((ExecutorService) executor).shutdown();
        TimeUnit.SECONDS.sleep(1);
        System.out.println();
        System.out.println("=============================================================");
        String str2 = new BufferedReader(new FileReader("data/work.txt")).readLine();
        ExecutorService service = Executors.newSingleThreadExecutor(); // Главным отличием от Executor, является возможность работы с интерфейсом Callable,
        // а также предоставляет методы для управления завершением работы потока (shutdown) и методы,
        // которые могут создавать Future для отслеживания хода выполнения одной или нескольких асинхронных задач.
        StringBuilder reverse = new StringBuilder();
        Future<String> future = service.submit(() -> { // Future представляет результат асинхронного вычисления. Предоставляются методы для проверки завершения вычисления,
        // ожидания его завершения и извлечения результата вычисления. Результат можно получить с помощью метода get() только после завершения вычисления,
        // при необходимости блокируя его до тех пор, пока он не будет готов. Отмена производится методом cancel.
            for (int  i = str2.length() - 1; i > -1; i--) {
                reverse.append(str2.charAt(i));
            }
            return reverse.toString();
        });
        System.out.println(future.get());
        service.shutdown();
    }
}
