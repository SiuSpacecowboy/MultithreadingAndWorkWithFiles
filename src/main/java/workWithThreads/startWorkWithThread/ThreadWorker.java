package workWithThreads.startWorkWithThread;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ThreadWorker extends Thread {

    private final int newWidth;
    private final File[] files;
    private static final long start = System.currentTimeMillis();

    public ThreadWorker(int newWidth, File[] files) {
        this.newWidth = newWidth;
        this.files = files;
    }

    @Override
    public void run() {
        for (File file : files) {
            BufferedImage image = null;
            try {
                image = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (image == null) {
                continue;
            }
            int newHeight = (int) Math.round(
                    image.getHeight() / (image.getWidth() / (double) newWidth));
            BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            int numPixelWidth = image.getWidth() / newWidth;
            int numPixelHeight = image.getHeight() / newHeight;
            for (int x = 0; x < newWidth; x++) {
                for (int y = 0; y < newHeight; y++) {
                    int rgb = image.getRGB(x * numPixelWidth, y * numPixelHeight);
                    newImage.setRGB(x, y, rgb);
                }
            }
            File res = new File("C:\\Users\\danvi\\Desktop\\CopyScr" + "\\" + file.getName());
            try {
                ImageIO.write(newImage, "jpg", res);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}

