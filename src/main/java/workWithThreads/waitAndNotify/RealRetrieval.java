package workWithThreads.waitAndNotify;

public class RealRetrieval implements Runnable {

    private WaitAndNotify come;

    public RealRetrieval(WaitAndNotify come) {
        this.come = come;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3000; i++) {
            come.magicRetrieval();
        }
    }
}