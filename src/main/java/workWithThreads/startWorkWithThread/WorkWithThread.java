package workWithThreads.startWorkWithThread;

import workWithThreads.startWorkWithThread.ThreadWorker;

import java.io.File;

public class WorkWithThread extends Thread {

    private static final int newWidth = 400;

    public static void main(String[] args) throws Exception {
        File st = new File("C:\\Users\\danvi\\Desktop\\Screens and photos");
        File[] files = st.listFiles();
        int lThread = files.length / 4;
        File[] files1 = new File[lThread];
        System.arraycopy(files, 0, files1, 0, lThread);
        ThreadWorker worker1 = new ThreadWorker(newWidth, files);
        worker1.start();
        File[] files2 = new File[lThread];
        System.arraycopy(files, lThread, files2, 0, lThread);
        ThreadWorker worker2 = new ThreadWorker(newWidth, files);
        worker2.start();
        File[] files3 = new File[lThread];
        System.arraycopy(files, files.length / 2, files3, 0, lThread);
        ThreadWorker worker3 = new ThreadWorker(newWidth, files);
        worker3.start();
        File[] files4 = new File[lThread];
        System.arraycopy(files, files.length - lThread, files4, 0, lThread);
        ThreadWorker worker4 = new ThreadWorker(newWidth, files);
        worker4.start();
    }
}
