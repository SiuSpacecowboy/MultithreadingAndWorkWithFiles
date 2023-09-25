package workWithFiles.workWithNIO;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

public class WorkWithBufferNIO {

    public static void main(String[] args) throws CharacterCodingException {
        ByteBuffer buff = ByteBuffer.allocate(15);
        buff.put((byte) 'A');
        buff.put("SS_hard".getBytes());
        System.out.println("Limit_pos: " + buff.limit() + " " + "Position_pos: " + buff.position());
        buff.flip();
        System.out.println("After_flip:");
        System.out.println("Limit_pos: " + buff.limit() + " " + "Position_pos: " + buff.position());
        byte[] res = new byte[buff.limit()];
        buff.get(res);
        System.out.println(new String(res, StandardCharsets.UTF_8));
        buff.get(1, res, 0, 7); //Я хз как это точно работает
        System.out.println(new String(res, StandardCharsets.UTF_8));
        buff.clear();
        System.out.println("After_clear:");
        System.out.println("Limit_pos: " + buff.limit() + " " + "Position_pos: " + buff.position());
        System.out.println("=========================================================================");
        /**buff, view и slice отсылают к одной области памяти, только с разными индексами */
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put("Str_row".getBytes());
        System.out.println("Limit_pos: " + buffer.limit() + " " + "Position_pos: " + buffer.position());
        ByteBuffer view = buffer.duplicate();
        System.out.println("Limit_pos: " + view.limit() + " " + "Position_pos: " + view.position());
        view.put((byte) 'K');
        System.out.println("Limit_pos: " + buffer.limit() + " " + "Position_pos: " + buffer.position());
        System.out.println(new String(buffer.array(), StandardCharsets.UTF_8));
        System.out.println("Limit_pos: " + view.limit() + " " + "Position_pos: " + view.position());
        System.out.println(new String(view.array(), StandardCharsets.UTF_8));
        view.position(2).limit(7);
        ByteBuffer slice = view.slice();// (mark = -1, position = 0) = rewind, (limit = 5, capacity = 5) = view(limit - pos);
        System.out.println("Limit_pos: " + slice.limit() + " " + "Position_pos: " + slice.position());
        byte[] sl = new byte[slice.capacity()];
        slice.get(sl);
        System.out.println(new String(sl, StandardCharsets.UTF_8));
        System.out.println("=====================================================================");
        /** При сравнении буферов, сравнивается побайтово значения от position до limit*/
        byte[] rsl = "LIFe_is_good".getBytes();
        byte[] rsl1 = "is_good".getBytes();
        ByteBuffer f = ByteBuffer.wrap(rsl);
        ByteBuffer r = ByteBuffer.wrap(rsl1);
        String str = new String(f.array(), StandardCharsets.UTF_8);
        String str1 = new String(r.array(), StandardCharsets.UTF_8);
        System.out.println(str + " - Pos: " + f.position() + "\n"
                + str1 + " - Pos: " + r.position() + "\n"
                + f.equals(r));
        f.position(5);
        System.out.println("При измененном индексе позиций:" + "\n"
                + str + " - Pos: " + f.position() + "\n"
                + str1 + " - Pos: " + r.position() + "\n"
                + f.equals(r));
        System.out.println("======================================================================");
        /** перекодирование из UTF-8 в win-1251 */
        Charset winSet = Charset.forName("windows-1251");
        Charset utf8Set = StandardCharsets.UTF_8;
        ByteBuffer b = utf8Set.encode(str);
        CharBuffer charBuffer = winSet.decode(b);
        String val = charBuffer.toString();
        System.out.println(val);
        CharsetDecoder decoder = utf8Set.newDecoder();
        CharBuffer ss = decoder.decode(b);
    }
}