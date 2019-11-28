package java_hexin;


import com.sun.jdi.ArrayReference;
import com.sun.security.jgss.GSSUtil;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/*
* 1.字符串和编码: String
* 2.StringBuilder
* */


class Score{
    private int[] scores;
    public Score(int[] scores){
        // 使用clone()可以避免外部修改的影响
        this.scores = scores.clone();
    }

    public void PrintScores(){
        System.out.println(Arrays.toString(this.scores));
    }
}
public class Chapter01 {
    public static void main(String[] args){
        System.out.println("Chapter01");
        String s1 = "first";
        String s2 = new String(new char[] {'1', '2', '3'});
        System.out.println(s2);

        // 字符串比较
        // == 要求引用类型也要相同
        // equals() 只要值相同就可以
        String s3 = "FIRST".toLowerCase();
        System.out.println(s1==s3);
        System.out.println(s1.equals(s3));
        System.out.println(s1.equalsIgnoreCase(s3)); // 忽略大小写比较

        // 字符串判断字串是否存在，查找子串，提取字串
        String s4 = "hello";
        System.out.println(s4.contains("he"));
        System.out.println(s4.indexOf('l'));
        System.out.println(s4.lastIndexOf('l'));
        System.out.println(s4.startsWith("he"));
        System.out.println(s4.endsWith("lo"));
        // 提取子串
        System.out.println(s4.substring(1));
        System.out.println(s4.substring(1,5));

        // 移除首尾空白字符,空白字符包括:空格，\t，\r，\n：
        s4 = " \t \nhe\tllo\r";
        System.out.println(s4.trim());  // trim()函数返回一个新字符串
        s4 = "\u3000HELLO\u3000";  //代表双字符空格
        System.out.println(s4);
        // isEmpty()长度为0   isBlank()可以包含空白字符
        s4 = "";
        System.out.println("" + " - " + s4.isEmpty());
        // System.out.println("" + " - " + s4.isBlank());  无此方法

        // 替换 // 替换完成之后返回一个新对象
        // 可以字符替换，字符串替换，正则匹配替换
        s4 = "hello";
        System.out.println(s4.replace('l', 'k'));
        System.out.println(s4.replace("he", "00"));

        s1 = "first"; s2 = "second";
        s4 = String.join("--", s1, s2);
        System.out.println(s4);

        // 把任意基本类型或引用类型转换为字符串
        // valueOf()  这是一个重载方法，根据传入的不同类型选择不同的函数，但他们的返回类型都是相同的。
        System.out.println(String.valueOf(123)+"\n"+
                           String.valueOf(45.56)+"\t"+
                           String.valueOf(true)+"\n");
        System.out.println("字符串转换为其他类型");
        System.out.println(Integer.parseInt("123"));
        System.out.println(Integer.parseInt("ff", 16));
        System.out.println(Boolean.parseBoolean("true"));
        System.out.println(Boolean.parseBoolean("false"));
        System.out.println(Integer.getInteger("java.version"));
        System.out.println("char[] 和 String 互相转换");
        char[] cs = "hello".toCharArray();
        cs[0] = 'L';
        String new_cs = new String(cs);
        System.out.println(new_cs);
        cs[1] = 'E';
        // 再次修改字符数组，字符串不会改变，在 new String(new_cs)时，不会直接引用char[]的值，而是
        // 复制一份，因为是两个不同的数组
        System.out.println(new_cs);
        System.out.println(new String(new char[] {'1', '2', '3'}));

        int[] scores = new int[] {22, 33, 44, 55, 66};
        Score score1 = new Score(scores);
        score1.PrintScores();
        // 修改外部数组, 会导致实例里面的数据改变
        scores[0] = 99;
        score1.PrintScores();

        // 字符编码
        /*
        * 早期使用 ASCII 作为编码
        * 其他的字纳入编码产生了 汉字的 GB2312 , 日文的 Shift_JIS , 韩文的 EUC-KB 编码
        * 为了统一编码 ， 发布了 unicode, 它是定长编码
        *          ┌────┐
          ASCII:   │ 41 │
                   └────┘
                   ┌────┬────┐
          Unicode: │ 00 │ 41 │
                   └────┴────┘
        * 为了节省空间，引入了变长编码 UTF-8 , 长度 1~4字节，
        * 英文字符'A'的UTF-8编码变为0x41，正好和ASCII码一致，而中文'中'的UTF-8编码为3字节0xe4b8ad。
        * */
        System.out.println("编码转换");
        byte[] b1 = "hello".getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(b1));
        // Java的String和char在内存中总是以Unicode编码表示

        // java中的 String 是不可以修改的，当我们进行修改时，就会反复的抛弃旧的，产生新的，这对内存是巨大的浪费
        // 如：
//        String ss1 = "";
//        for (int i = 0;i < 1000; i++){
//            ss1 = ss1 + "," + i;  // 会产生巨大的浪费
//        }
        // 为了高效拼接字符串，java标准库提供了 StringBuilder ,他是一个可变对象，可以预分配缓冲区，
        // 向其中 新增 “字符” 不会创建新的对象
        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; i < 2019; i++){
            sb.append(',');
            sb.append(i);
        }
        String ss2 = sb.toString();  // 将 StringBuilder 对象转化为 String 对象
        System.out.println(ss2);

        // StringBuilder 的链式操作

    }
}
