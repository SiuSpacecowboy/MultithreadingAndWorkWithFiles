package workWithFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

public class PropertiesWork {

    public static void main(String[] args) throws Exception {
        /** Я хз для ччего это надо, еще один универсальный класс, похож на Json,
         * с помощью него можно создавать конфигурационные файлы, хз */
        Properties properties = new Properties();
        byte[] r = "WTF_going".getBytes();
        String s = "key2";
        properties.setProperty("key1", String.valueOf(15));
        properties.setProperty(s, Arrays.toString(r));
        //properties.put(s, r);
        properties.store(new FileWriter("data/propWork.properties"), "loh");
    }
}
