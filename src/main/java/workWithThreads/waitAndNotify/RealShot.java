package workWithThreads.waitAndNotify;

public class RealShot implements Runnable {

    private WaitAndNotify sh;

    public RealShot(WaitAndNotify sh) {
        this.sh = sh;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3000; i++) {
            sh.shot();
        }
    }
}
