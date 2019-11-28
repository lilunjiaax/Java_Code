package itheima;

class Person_Chapter01{
    // 包作用域
    void hello(){
        System.out.println("Test Package 作用域");
    }
}


public class Chapter01{
    /*
    整数运算：
    ！！！！！！ 关于非运算符需要重点学习.
     */

    // 包作用域
    void hello(){
        System.out.println("Test Package 作用域");
    }

    public static void main(String []args){
        System.out.println("---------");

        int x = 100;
        int y = 3;
        System.out.println(x/y);  // 整型数相除只会得到整形数
        System.out.println(x%y);


        // 关于int 型和 long 型的问题，
        // 一旦存储的二进制位数超出范围会出现意料之外的错误
        int x1 = 2147483640;
        int y1 = 15;
        System.out.println(x1+y1);

        long x2 = 2147483640;
        long y2 = 15;
        System.out.println(x2+y2);

        // 自增运算，自减运算都是一样的，

        // 移位运算，
        // >> 表示最高位的符号位不会移动
        int n = 7;
        System.out.println("移位运算");
        System.out.println(n>>1);
        System.out.println(n>>2);
        System.out.println(n<<1);

        // >>> 最高的符号位也会移动,
        // 最高位的 1 表示为负数，移动后最高位为0，成为正数
        int m = -7;
        System.out.println(m >>> 1);
        System.out.println(m >>> 2);
        // 对byte和short类型进行移位时，会首先转换为int再进行位移。

        // 位运算
        System.out.println("位运算");
        // 与运算 同1为1
        System.out.println(1 & 0);

        // 或运算 有1为1
        System.out.println(1 | 0);

        // 非运算
        System.out.println(~0);
        System.out.println(~1);

        // 异或运算 两数不同则为1
        System.out.println(1^0);

        // 类型转换
        // 自动类型转换
        // 强制类型转换
        System.out.println("强制类型转换");
        int i = 12345;
        System.out.println((short)i);

        System.out.println("前N个数的和");
        int N = 100;
        System.out.println((N+1)*N/2.0);  // 自动转化为浮点型

        System.out.println(~(-3));
		/*
		运算流程：
		~运算：
		1.符号位不变，按位取反
		2.符号位为0（整数）：取反的结果-1，符号位为1（负数），取反结果+1
		3.包含符号位，按位取反

		-3 运算
		-3   1000 0011
		1.   1111 1100
		2.   1111 1101
		3.   0000 0010
		= 2 这是java编译器按位取反的流程
		*/
    }
}
