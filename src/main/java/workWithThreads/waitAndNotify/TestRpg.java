package workWithThreads.waitAndNotify;

public class TestRpg {

    private  static  final WaitAndNotify archer = new WaitAndNotify();

    public static void main(String[] args) {
        new Thread(new RealShot(archer)).start();
        new Thread(new RealRetrieval(archer)).start();
    }
}
