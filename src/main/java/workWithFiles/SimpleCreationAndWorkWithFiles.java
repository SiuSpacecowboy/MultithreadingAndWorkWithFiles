package workWithFiles;

import java.io.File;

public class SimpleCreationAndWorkWithFiles {

    public static void main(String[] args) {
        File file = new File("C:/Users/danvi/OneDrive/Рабочий стол/Test/java.txt");
        System.out.println(file.length());
        System.out.println("====================================");
       File txt = new File("data/work.txt");
        System.out.println(txt.length());
        System.out.println("====================================");
       File create = new File("C:/Users/danvi/OneDrive/Рабочий стол/folder");
        System.out.println(create.length());
        for (File f : create.listFiles()) {
            System.out.println(f.getAbsolutePath());
        }
        //create.delete();
        System.out.println("====================================");
        File folder  =  new File("C:/Users/danvi/OneDrive/Рабочий стол");
        File[] files = folder.listFiles();
        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }
    }
}
