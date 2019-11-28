package itheima;

public class Chapter03{
    public static void main(String []args) {
        /*
        字符和字符串：
        字符：2个字节，数字，字母，汉字 都可以
        */
        System.out.println("Chapter03");

        char c1 = 'A';
        char c2 = '总';

        // Java在内存中总是使用Unicode表示字符

        int i1 = 'A';  // 直接赋值给int型可以查看该字符的unicode的编码
        int i2 = '总';
        System.out.println(i1);
        System.out.println(i2);  // 直接输出unicode编码
        System.out.printf("16进制输出 %x\n", i2);

        // 使用转义字符加unicode编码表示字符
        System.out.println('\u0065');
        System.out.println('\u603b');

        // 字符串
        String s1 = "abc\\\u603bkk\tqwer";
        System.out.println(s1);
        // 字符串的拼接对象可以为：字符，数
        System.out.println("字符串连接："+s1+"AASS"+"!!!"+25+'L'+3.2);

        String s2 = "asd\n"
                + "zxc\n"
                + "qwer";
        System.out.println(s2);

        // 注意字符串的不可变性，指向会改变
        String tmp = s1;  // tmp指向abc开头的字符串
        s1 = "hahaha";  // s1 的新指向
        System.out.println(tmp);
        System.out.println(s1);

        // 空值 null 注意：null 与 "" 不相同
        boolean b1 = null == "";
        b1 = true;
        System.out.println(b1);


        // 练习
        int a = 72;
        int b = 105;
        int c = 65281;

        System.out.println((char)a);  // 强制转换
        System.out.println('\u0048');

        String a1 = Integer.toHexString(a);  // 十进制转化为16进制

        System.out.println(""+(char)a + (char)b +(char)c);

    }
}
