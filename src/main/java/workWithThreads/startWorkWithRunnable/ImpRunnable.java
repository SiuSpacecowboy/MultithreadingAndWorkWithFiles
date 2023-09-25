package workWithThreads.startWorkWithRunnable;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ImpRunnable implements Runnable {

    private static ByteBuffer res;

    public ImpRunnable (ByteBuffer res) {
        this.res = res;
    }

    @Override
    public synchronized void run() {
        String f = new String(res.array(), StandardCharsets.UTF_8);
        System.out.println(f);
    }
}

