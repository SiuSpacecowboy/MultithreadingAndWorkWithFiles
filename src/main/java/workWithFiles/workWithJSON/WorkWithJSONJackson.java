package workWithFiles.workWithJSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WorkWithJSONJackson {

    /**Библиотека Jackson позволяет работать удобно с файлами типа JSON.
     * Позволяет как читать их, так и что-то записывать и т.д. */
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        /** Чтение из файла JSON и превращение его в объект - Десериализация  */
        String s = Files.readString(Paths.get("data/rpg.Json"));
        /** Специальный класс RpgJSON в ручную созданный под JSON файл,
         также можно автоматически создать с помощью специального сайта jsonschema2pojo или подключить maven, но там сложно*/
        RpgJSON res = mapper.readValue(s, RpgJSON.class);
        System.out.println(res.getClasses().getArcher().getArmor());
        /**=============================================*/
        /** Запись в файл с помощью изменения класса, превращение класса в объект - Сериализация*/
        res.getClasses().getMage().setRange("215");
        /** writerWithDefaultPrettyPrinter() позволяет красиво оформить JSON файл, а не просто сплошная строка
         * writeValueAsString() запись в строку, также можно записывать в другие виды*/
        String newFile  = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(res);
        FileWriter rec = new FileWriter("data/rpg.Json");
        rec.write(newFile);
        //rec.flush();
        rec.close();
    }
}
