package workWithFiles.workWithNIO.workWithSelectorNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorServerPart {

    private static final int PORT1 = 8088;
    private static final int PORT2 = 8089;

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open(); // Создание селектора

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress("localhost", PORT1));
        serverSocketChannel.configureBlocking(false); //Делаем канал неблокируемым, для NIO.
        SelectionKey key1 = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT); //Регистрация канала в селектор и назначение бита-ключа

        ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
        serverSocketChannel2.socket().bind(new InetSocketAddress("localhost", PORT2));
        serverSocketChannel2.configureBlocking(false); // Делаем канал неблокируемым, для NIO.
        SelectionKey key2 = serverSocketChannel2.register(selector, SelectionKey.OP_ACCEPT); //Регистрация канала в селектор и назначение бита-ключа.

        while (true) {
            int num = selector.select(); //Выбор готового набора (isReadable, IsAcceptable и т.д.).
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {

                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {
                    ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                    SocketChannel clientChannel = serverChannel.accept();
                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("Новое подключение: " + clientChannel);
                } else if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);
                    String message = new String(buffer.array()).trim();
                    System.out.println("Получено сообщение от " + channel + ": " + message);
                }
                keyIterator.remove();
            }
        }
    }
}
