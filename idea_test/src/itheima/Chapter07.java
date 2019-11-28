package itheima; // 申明包名

import ming.Test;
// 要特别注意：包没有父子关系。java.util和java.util.zip是不同的包，两者没有任何继承关系

/*
* 静态字段和静态方法：
* 静态字段：public static int num; 所有类的实例都会共享该字段
* 静态方法:静态方法属于 class 中，因此静态方法无法访问this变量，无法访问实例字段，只能访问静态字段
* 接口(interface)的静态字段,必须是final型
*
* 包作用域：位于同一个包的类，可以访问包作用域的字段和方法（不用public,protected,private修饰的字段和方法就是包作用域）
* 访问域：public,private,protected
* final:final修饰的类不可被继承，final修饰的方法不可被覆写，final修饰的field,局部字段 不可被重新赋值
*
* 建议：
* 1. 如果不确定是否需要public，就不声明为public，即尽可能少地暴露对外的字段和方法。
* 2. 将测试类与被测试类定义在同一个package，有利于测试
* 3. 一个.java文件只有一个public修饰的类（此类名与文件名相同）,也可以有其他非public修饰的类
* 4. 导入一个类，只能导入public修饰的类
*
*
* classpath与jar
* 1. classpath:是JVM查找需要运行的类的路径
*  java abc.xyz.Hello,就是在classpath中查找abc.xyz.Hello.class，来运行
* 推荐在启动jvm时，设置classpath，默认是：.
* java -classpath .;C:\work\project1\bin;C:\shared abc.xyz.Hello
* java -cp .;C:\work\project1\bin;C:\shared abc.xyz.Hello
*
*
*
* */

class Person_07 {
    public String name;
    public int age;

    public static int number; // 静态字段
    public static int count;

    public Person_07(){
        count ++;
    }
    // 静态方法:静态方法属于 class 中，因此静态方法无法访问this变量，无法访问实例字段，只能访问静态字段
    public static void setName(int value){
        number = value;

    }

    public static int getCount(){
        return count;
    }
}

interface Person_inter_07{
    public static final int MALE = 1;
    public static final int FEMALE = 2;
    /*
    可以简写为：
    int MALE = 1;
    int FEMALE = 2;
    * */
}


public class Chapter07 {
    public static void main(String[] args){
        System.out.println("Chapter07");
        Person_07 per1 = new Person_07();
        Person_07 per2 = new Person_07();
        // 不同的实例共用类中的同一个静态字段
        System.out.println(per1.number);
        per1.number = 88;
        System.out.println("per1.name: " + per1.number);
        System.out.println("per2.name: " + per2.number);
        // 本质上：静态字段不属于在实例中，而是存在类中
        System.out.println(Person_07.number); // 在java中，推荐用类名来访问static field
        /*
        ┌──────────────────┐
ming ──>│Person instance   │
        ├──────────────────┤
        │name = "Xiao Ming"│
        │age = 12          │
        │number ───────────┼──┐    ┌───────────────┐
        └──────────────────┘  │    │Person_07 class│
                              │    ├───────────────┤
                              ├───>│number = 88    │
        ┌──────────────────┐  │    └───────────────┘
hong ──>│Person instance   │  │
        ├──────────────────┤  │
        │name = "Xiao Hong"│  │
        │age = 15          │  │
        │number ───────────┼──┘
        └──────────────────┘

        */

        // 练习：给Person类增加一个静态字段count和静态方法getCount，统计实例创建的个数。
        System.out.println("instance count number: "+Person_07.getCount());

        /*
        以package_sample作为根目录，src作为源码目录，那么所有文件结构就是
        package_sample
        └─ src
            ├─ hong
            │  └─ Person.java
            │  ming
            │  └─ Person.java
            └─ mr
               └─ jun
                  └─ Arrays.java

        * */

        //包作用域
        // 1. public 类
        Chapter01 ch1 = new Chapter01();
        ch1.hello();
        // 2. 非 public 类
        Person_Chapter01 ch2 = new Person_Chapter01();
        ch2.hello();

        Book book1 = new Book();
        book1.setName("Chapter07");
        System.out.println(book1.getName());


        /*
        以package_sample作为根目录，src作为源码目录，那么所有文件结构就是
        package_sample
        └─ src
            ├─ hong   作为包
            │  └─ Person.java  作为一个文件，里面必有一个public修饰的同名类，只有此类才可以导入。定义的其他类并不能导入
            │  ming
            │  └─ Person.java
            └─ mr
               └─ jun
                  └─ Arrays.java

        * */
        Test t = new Test();
        t.printTest();
        t.setAge(22222);
        System.out.println(t.getAge());

        // 定义为private的field、method无法被其他类访问
        // java支持嵌套类，一个类的内部可以定义嵌套类，嵌套类可以访问private权限
        Inner in1 = new Inner();
        in1.hi();







    }
    private static void hello() {
        System.out.println("嵌套静态方法");
    }

    static class Inner{
        public void hi(){
            Chapter07.hello();
        }
    }

}
