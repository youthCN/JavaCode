package common.Stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

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
