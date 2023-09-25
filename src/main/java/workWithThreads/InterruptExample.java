package workWithThreads;

public class InterruptExample extends Thread { // Прерывать можно только Thread потоки, Runnable нельзя.

    private static long start =  System.currentTimeMillis();

    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println(System.currentTimeMillis());
/*            if (System.currentTimeMillis() - start > 3000) { // АЛЬТЕРНАТИВА ВЫЗОВУ interrupt в main.
                Thread.currentThread().interrupt();
            }*/
        }
        System.out.println("Interrupted");
        }

    public static void main(String[] args) throws InterruptedException {
      Thread thread = new InterruptExample();
      thread.start();
      Thread.sleep(2000); // Здесь засыпает main().
      thread.interrupt(); // НА САМОМ ДЕЛЕ МЕНЯЕТ ФЛАГ BOOLEAN ЭЛЕМЕНТА isInterrupted!!!!!!!!!!!!!!!!!!!!
    }
}
