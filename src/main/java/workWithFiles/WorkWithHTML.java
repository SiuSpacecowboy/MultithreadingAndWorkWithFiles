package workWithFiles;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WorkWithHTML {

    public static void main(String[] args) {
        //String htmlFile = htmlParse("data/steam.html");
        File file = new File("data/steam.html");
        Document doc = null;
        try {
            doc = Jsoup.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements el = doc.select("a.gutter_item");
        el.forEach(element -> System.out.println(element.text()));
        el.forEach(System.out::println);
    }

    public static String htmlParse(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            lines.forEach(line -> builder.append(lines).append("\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return builder.toString();
    }

}
