package workWithThreads.workWithSynchronize;

import java.util.ArrayList;

public class WrongEx implements Runnable {

    private static int var;
    private static  boolean wrongIsRunning;
    private static final ArrayList<String> wrongArr = new ArrayList<>();
    private static int wrongCount;

    static {
        wrongIsRunning = true;
    }


    public static void cre() {
        var = var + 1;
    }

    public static int ge() {
        return var;
    }

    public static void wrongEn() {
        for (int i = 0 ; i < 1000000; i++) {
            wrongArr.add("code");
        }
        System.out.println(wrongArr.size());
    }

    public static void wrongStop() {
        wrongIsRunning = false;
    }

    @Override
    public void run() {
        while (wrongIsRunning) {
            wrongCount++;
        }
    }
}
