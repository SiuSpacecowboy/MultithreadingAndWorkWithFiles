package workWithFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteFiles {

    public static void main(String[] args) {
        try {
    /** Общий момент: при отсутствии указанного файла, создаст новый, иначе исправит записи внутри существующего*/
            /** PrintWriter позволяет обыденно работать со строками.
             * Обязательно использовать flush и close, flush сбрасывает буфер потока,
             * close закрывает поток, позволяя другим работать с этим файлом */
/** ==================================================================================================================*/
            PrintWriter writer = new PrintWriter("data/file1.txt");
            String str = "Сегодня был вкусный ужин";
            String[] rsl = str.split(" ");
            for (String s : rsl) {
                writer.write(s + "\n");
            }
            writer.flush();
            writer.close();
/** ==================================================================================================================*/
    /** NIO. Files является более современным аналогом PrintWriter, позволяя избежать лишних строчек кода,
    * например close и flush, а также работать напрямую с коллекциями(контейнерами), а не с их элементами(через цикл) */
/** ==================================================================================================================*/
            String stg = "Ужин был крайне отвратительным";
            List<String> res = Arrays.stream(stg.split(" ")).toList();
            Files.write(Paths.get("data/file2.txt"), res);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
