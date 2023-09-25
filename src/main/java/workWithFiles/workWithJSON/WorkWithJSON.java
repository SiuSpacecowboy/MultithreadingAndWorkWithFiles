package workWithFiles.workWithJSON;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Set;

public class WorkWithJSON {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            FileReader f = new FileReader("data/rpg.Json");
            JSONObject obj = (JSONObject) parser.parse(f);
            Set res = obj.keySet();
            for (Object s : res) {
                System.out.println(s);
            }
           //System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
