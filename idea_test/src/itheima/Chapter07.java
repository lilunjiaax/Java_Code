package itheima;

/*
* 静态字段和静态方法：
*
* */

class Person_07 {
    public String name;
    public int age;

    public static int number; // 静态字段
}




public class Chapter07 {
    public static void main(String[] args){
        System.out.println("Chapter07");
        Person_07 per1 = new Person_07();
        Person_07 per2 = new Person_07();
        // 不同的实例共用类中的同一个静态字段
        System.out.println(per1.number);
        per1.number = 88;
        System.out.println(per2.number);



    }
}
