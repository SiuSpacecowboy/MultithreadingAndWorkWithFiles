package workWithFiles.workWithNIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WorkWithLocalChannelNIO {

    public static void main(String[] args) {
        /** Прямой, полный способ */
        Path inputPath = Path.of("C:\\Users\\danvi\\Desktop\\Java teory.docx");
        Path outputPath = Path.of("data/javaTheoryCopy.docx");
        try (FileChannel inputChannel = FileChannel.open(inputPath, StandardOpenOption.READ);
             FileChannel outputChannel = FileChannel.open(outputPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (inputChannel.read(buffer) != -1) {
                buffer.flip();
                outputChannel.write(buffer);
                buffer.clear();
/**===========================================================================================================================*/
                /** Класс Files полностью автоматизирует код сверху(как я понимаю),
                 * автоматизируя работу с байтами и открытием и закрытием путей*/
                byte[] byt = Files.readAllBytes(Paths.get("C:\\Users\\danvi\\Desktop\\Все с работой\\NIO_API.docx"));
                Files.write(Path.of("data/javaNIOCopy.docx"), byt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}