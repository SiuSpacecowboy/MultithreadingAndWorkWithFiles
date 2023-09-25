package workWithFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFiles {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        StringBuilder build = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            /** FileInputStream читает код посимвольно */
            FileInputStream file = new FileInputStream("data/work.txt");
            for(;;) {  /** бесконченый цикл */
                int s = file.read();
                if (s < 0) {
                    break;
                }
                char ch = (char) s;
                builder.append(ch);
            }
            System.out.println(builder);
            /** ===============================================================================*/
            /** BufferedReader умеет полноценно читать строки, помогает метод readlne() */
            BufferedReader fill = new BufferedReader(new FileReader("C:\\Users\\danvi\\OneDrive\\Рабочий стол\\Test\\java.txt"));
                for (;;) {
                    String line = fill.readLine();
                    if (line == null) {
                        break;
                    }
                    build.append(line).append("\n");
                }
            System.out.println(build);
            /** ===============================================================================*/
            /** NIO. Класс Files является современным аналогом всего вышеперечисленного, удобный функционал,
             * метод readlines() возвращает список из строк текста в данном примере.
             */
            List<String> lines = Files.readAllLines(Paths.get("data/un.txt"));
            lines.forEach(line -> stringBuilder.append(line).append("\n"));
            System.out.println(stringBuilder);
            /** ===============================================================================*/
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
