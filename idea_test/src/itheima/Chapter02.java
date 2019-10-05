package itheima;

public class Chapter02{
    public static void main(String []args){
        /*
        浮点数运算：
        只能进行加减乘除，不能进行位运算

        布尔运算：
        */
        double x = 1.0/10;
        double y = 1 - 9.0/10;
        System.out.println(x);
        System.out.println(y);

        // 比较两个浮点数：差的绝对值是否小于很小的数
        double z = Math.abs(x - y);
        if (z < 0.00001){
            System.out.println("相等");
        }else{
            System.out.println("不相等");
        }

        // 类型提升：整型和浮点型运算会将整型提升到浮点型
        // 溢出 浮点型在除数为0时，不会报错
        double d1 = 0.0/0;
        System.out.println(d1);
        double d2 = 1.0/0;
        System.out.println(d2);
        double d3 = -1.0/0;
        System.out.println(d3);

        // 强制类型转换
        // 浮点数强制转化为整数，直接丢弃小数部分，如果转换后超出整型最大范围，则取最大值
        // 四舍五入：直接给浮点数+0.5，取整即可以

        // 求根公式
        double a = 1.0;
        double b = 3.0;
        double c = -4.0;
        System.out.println((-b+Math.sqrt(b*b - 4*a*c))/(2*a));
        System.out.println((-b-Math.sqrt(b*b - 4*a*c))/(2*a));

        System.out.println("--------------------------------------------");

        boolean isGreater = 5>3;
        int age = 12;
        boolean iszero = age == 0;
        System.out.println(isGreater);
        System.out.println(iszero);
        System.out.println(!iszero);
        System.out.println(age > 6 && age < 18);

        // 短路运算
        // 如 false && x  ,   true || x

        // 三元运算符 b ? x:y
        int k1 = 5;
        int k2 = 6; // 当k2 = 6.0时，会报错，类型必须相同
        System.out.println(k1>k2 ? k1:k2);

    }
}
