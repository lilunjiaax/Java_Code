package itheima;
import java.util.Scanner;
import java.util.Arrays;

public class Chapter04{
    public static void main(String[] args){
        /**
         * 数组:是引用类型，
         * 数组元素可以是值类型（如int）或引用类型（如String）
         *
         * 流程控制
         */
        System.out.println("Chapter04");

        // 1. 初始化之后有默认值 : 整型都是0，浮点型是0.0，布尔型是false；
        // 2. 大小不可更改
        int[] array = new int[6];
        System.out.println(array[2]);
        for (int i=0;i<array.length;i++){ // array.length 获取数组长度
            array[i] = i+1;
            System.out.println(array[i]);
        }

        int[] arr1 = new int[] { 12, 23, 34, 45, 56 };
        System.out.println(arr1.length);

        String[] arr2 = { "qwe", "asd", "zxcv" };  // 简写

        arr2[1] = "kkp";  // 修改值
        for (int j = 0; j < arr2.length; j++){
            System.out.println(arr2[j]);
        }

        // 输出
        // 1. print  不换行输出
        // 2. println 换行输出 == print line
        // 3. printf 格式化输出 (%d ；%x 十六进制 ；%e 科学计数法 ; %s 字符串)

        int n = 12345000;
        System.out.printf("n=%d, hex = %08x",n,n);  // 转化为16进制，用0补足8位；

        // 输入  从命令行接收参数
         Scanner scanner = new Scanner(System.in);
         System.out.print("\ninput your name:");
         String name = scanner.nextLine();  //读取一行输入并获取字符串
         System.out.print("input your age:");
         int age = scanner.nextInt(); //读取一行输入并获取整数, 会自动进行类型转化
         System.out.printf("name=%s, age=%d",name, age);

        // 练习
        // System.out.println("");

        // int lastGrade = scanner.nextInt();
        // int nowGrade = scanner.nextInt();

        // System.out.printf("%.2f%%", (nowGrade*1.0/lastGrade-1)*100);

        System.out.println("");
        int count = 80;
        // 多重 if else ，注意与C的不同之处
        if (count >= 90){
            System.out.println("优秀");
        } else if (count >= 60){
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }

        // 判断：值类型变量 和 引用类型变量(==代表是否指向同一个对象)
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.printf("%s  ---   %s\n", s1, s2);
        System.out.println(s1 == s2);  // 表名引用的对象不是指向同一个对象

        // 要判断引用类型的变量内容是否相等，必须使用equals()方法,不管对象类型，只判断内容是否相等
        System.out.println(s1.equals(s2));
        // s1.equals(s2)  注意点：当s1为null时，会报 NullPointerException 错误

        // switch 多重选择 ---> 注意穿透性
        int options = 2;
        switch (options){
            case 1:
                System.out.println("select 1");
                break;
            case 2:
                System.out.println("select 2");
                break;
            case 3:
                System.out.println("select 3");
                break;
            default:
                System.out.println("not options");
                break;
        }

        // switch 比较内容相等
        String fruit = "apple";
        switch (fruit){
            case "apple":
                System.out.println("select apple");
                break;
            case "banana":
                System.out.println("select banana");
                break;
        }

        // switch 枚举类型

        // 注意java12中修改了 switch 的穿透性，和赋值方式的改变
        // java13 开始支持 yield 返回值（当成switch表达式处理）

        // while 循环
        // do while 当while符合时，继续执行

        // for 循环的编写建议
        // 1. 循环计数尽量for的内部定义 for (int i = 0; ....)
        // 2. 灵活使用结束条件和更新语句 for (int i=0;;i++)  for (int i = 0;;)  for(;;)

        // for each 循环遍历里面的元素
        int[] ns = new int[] { 11, 22, 33 };
        String[] str = new String[] { "aas", "kkp" };
        for (int k : ns){  // 这里面的变量 n 不能重复定义
            System.out.println(k);
        }

        for (String kk : str){
            System.out.println(kk);
        }
        // 除数组外，for each循环能够遍历所有“可迭代”的数据类型，包括后面会介绍的List、Map等。

        // 循环控制 break continue

        // 数组的遍历和排序
        System.out.println(ns);  // 结果为：[I@b684286 没啥意义
        System.out.println(Arrays.toString(ns));  // [11, 22, 33]

        // 冒泡排序
        int[] nss = new int[] { 26, 36, 65, 32, 86, 100, -1 };
        for (int i = 0; i < nss.length-1; i++){ // 只需要遍历 长度-1 次
            for (int j = 0; j < nss.length-1-i; j++){ // 后面已经确定好位置的就不需要比较了
                if (nss[j] > nss[j+1]){
                    int tmp = nss[j];
                    nss[j] = nss[j+1];
                    nss[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(nss));

        // Arrays标准库的排序方法
        Arrays.sort(nss);  // 直接将内存中的位置给改变了

        String[] str1 = new String[] { "banana", "apple", "pear"};
        Arrays.sort(str1);
        // 注意 引用类型的排序是改变了指向：
        // https://www.liaoxuefeng.com/wiki/1252599548343744/1259543088592672
        System.out.println(Arrays.toString(str1));

        // 之前我们提到过：数组是一种引用类型
        // 那么二维数组，就是指向多个引用
        // 二维数组列之间不需要强制等长
        int[][] nss2 = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8 }
        };
        System.out.println(nss2[2].length);
        System.out.println(nss2[1].length);
        for (int [] pp1:nss2){
            for (int pp2:pp1){
                System.out.print(pp2);
                System.out.print(',');
            }
        }

        // Arrays.deepToString()
        System.out.println("");
        System.out.println(Arrays.deepToString(nss2));


        // 接收命令行参数
        // java的入口函数main可以接受一个 String[] 数组
        for (String arg:args){
            if ("-version".equals(arg)){
                System.out.println("v1.0");
            }

        }

    }
}
