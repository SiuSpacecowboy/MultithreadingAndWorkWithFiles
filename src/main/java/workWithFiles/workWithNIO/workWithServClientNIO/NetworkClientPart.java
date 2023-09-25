package workWithFiles.workWithNIO.workWithServClientNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NetworkClientPart {

    private static final String HOSTNAME = "localhost";
    private static final int PORT = 8088;

    public static void main (String[]args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(HOSTNAME, PORT));
        System.out.println("Connected to server");
        String message = "Hello, server!";
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        System.out.println(buffer.position() + " " + buffer.limit());
        socketChannel.write(buffer);
        System.out.println("Sent message to server: " + message);
        socketChannel.close();
        }
}
