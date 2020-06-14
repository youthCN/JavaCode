package common.Stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * markSupported() 测试此输入流是否支持 mark 和 reset 方法。是否支持 mark 和 reset 是特定输入流实例的不变属性。InputStream 的 markSupported 方法返回 false。
 *
 * mark:
 * 在此输入流中标记当前的位置。对 reset 方法的后续调用会在最后标记的位置重新定位此流，以便后续读取重新读取相同的字节。
 * readlimit 参数告知此输入流在标记位置失效之前允许读取的字节数。
 * mark 的常规协定是：如果方法 markSupported 返回 true，那么输入流总是在调用 mark 之后记录所有读取的字节，并时刻准备在调用方法 reset 时（无论何时），再次提供这些相同的字节。但是，如果在调用 reset 之前可以从流中读取多于 readlimit 的字节，则不需要该流记录任何数据。
 * 标记已关闭的流对其无效。
 * InputStream 的 mark 方法不执行任何操作。
 *
 * reset:
 * 将此流重新定位到最后一次对此输入流调用 mark 方法时的位置。
 * reset 的常规协定是：
 * 如果方法 markSupported 返回 true，那么：
 * 如果创建流以后未调用方法 mark，或最后调用 mark 以后从该流读取的字节数大于最后调用 mark 时的参数，则可能抛出 IOException。
 * 如果未抛出这样的 IOException，则将该流重新设置为这种状态：最近一次调用 mark 以后（如果未调用过 mark，则从文件开头开始）读取的所有字节将重新提供给 read 方法的后续调用者，后跟任何从调用 reset 时起将作为下一输入数据的字节。
 * 如果方法 markSupported 返回 false，那么：
 * 对 reset 的调用可能抛出 IOException。
 * 如果未抛出 IOException，则将该流重新设置为一种固定状态，该状态取决于输入流的特定类型及其创建方式。提供给 read 方法后续调用者的字节取决于特定类型的输入流。
 * 除了抛出 IOException 之外，类 InputStream 的方法 reset 不执行任何操作。
 */
public class MarkTest {
    public static void main(String[] args) {
        byte[] chars = new byte[]{'a','b','c','d','e'};
        byte[] nums = new byte[]{'0','1','2','3','4','5'};
        String[] strings = readType(chars);
        System.out.println(Arrays.toString(strings));
    }
    public static String[] readType( byte[] bytes){
        InputStream is = new ByteArrayInputStream(bytes);
        String[] str = new String[2];
        try {
            if (is.markSupported()){
                is.mark(1);
                int char0 = is.read();
                if (char0 == 48){
                    str[0] = "数字";
                }else if (char0 == 97){
                    str[0] = "拼音";
                }else {
                    str[0] = "未知";
                }
                is.reset();
            }else {
                str[0] = "未知";
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(bytes);
            str[1] = baos.toString("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //需要关闭流...
        return str;
    }
}
