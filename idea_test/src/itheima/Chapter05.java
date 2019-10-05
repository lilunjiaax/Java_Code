package itheima;

import java.sql.SQLOutput;
import java.util.Arrays;
/**
 * 方法：私有field , 传递可变参数 ， 参数绑定
 * 构造方法：在功能上与Python中__init__(self)方法相同
 * 多构造方法：在使用new调用的时候，编译器会根据参数的数量，类型，位置自动区分。构造方法之间可以互相调用
 * 方法重载：方法名相同，参数不同，**一般返回值的类型都是相同的。**
 * 继承：一个类可以继承其他类，这个类的实例可以复用被继承类的里面的field（父类的私有属性不可访问）和方法
 *
 */

class Person{
    public String name;  // public 表示这个字段可以被外部访问
    public int age;
}

class PersonGouZao{
    private String name;
    private int age;

    // 实现一个构造方法:在实例类的时候同时传入参数，进行初始化
    public PersonGouZao(String name, int age){
        this.name = name;
        this.age = age;
    }

    // 既实现自己的构造方法，又保留不带参数的初始构造方法：把初始构造方法也定义一遍
    public PersonGouZao(){
        // 这样就可以保证不带参数初始化也不会报错
    }

    public PersonGouZao(String name){
        this.name = name;
    }

    public PersonGouZao(int age, String name, int flag){
        this();
        System.out.println("构造方法的互相调用");
        this.name = name;
        this.age = age;
    }
    public String getName(){
        // this 表示的是：当前实例
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
}

class PersonInfo{
    private String name;  // 实例无法直接访问到
    private int age;
    private String[] names; // 可以用来接收可变参数

    protected String name1 = "xyh";

    public String getName(){
        // this 表示的是：当前实例
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void setName(String name){
        // 可以添加校验流程
        if (name == null){
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setNameAge(String name, int age){
        this.name = name;
        this.age = age+addAge();
    }

    public void setNumsName(String... names){
        this.names = names;
    }

    public void getNumsName(){
        System.out.println(Arrays.toString(this.names));
    }

    // private 方法只能内部调用
    private int addAge(){
        return 10;
    }


}

// 继承:类的继承里面需要注意父类的里面的 私有属性 私有方法 不能直接获得(需要通过方法来返回)
// private --> protected 用protected修饰的字段可以保证被子类，子子类访问到。
// Java只允许一个class继承自一个类（python里面可以多继承）
class Student extends PersonInfo {
    private int score;

    // 如果父类有除默认之外的构造方法，子类就必须显式调用super()并给出参数以便让编译器定位到父类的一个合适的构造方法
    // 所以 -- > 子类不会继承父类的构造方法
    public Student(){
        // 类的继承：子类的构造方法第一句必须是调用父类的构造方法
        super(); // 自动调用父类的构造方法,当父类的构造方法需要变量时：super(name, age);

        // 下面再进行自己的代码流程
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return this.score;
    }

    public void getStudentInfo(){
        System.out.printf("name: %s, age: %d, grade: %d\n", this.getName(), this.getAge(), this.score);

        // 父类字段使用protected修饰
        System.out.println(this.name1);

        // 使用 super（代表父类） 关键字可以访问到父类的字段 super.name，private修饰的字段仍然不可以直接访问
        // System.out.println("使用super访问： "+super.name);
        System.out.println("使用super访问： "+super.name1);
    }
}

// 方法的重载
class Hello{

    public void hello(){
        System.out.println("hello world");
    }

    public void hello(String name){
        System.out.println("hello "+name);
    }

    public void hello(String name, int age){
        if (age < 18){
            System.out.println("hello "+"student "+"! "+name);
        } else {
            System.out.println("hello "+"people "+"! "+name);
        }
    }

}

class Book{
    protected String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
public class Chapter05{
    public static void main(String[] args){
        System.out.println("面向对象编程 OOP");
        // class  instance
        // 使用 new 来创建一个实例
        Person per1 = new Person();
        per1.name = "xyh";
        // 在定义类的时候使用 public修饰 field 可以在外部访问到，不利于封闭性
        // 使用private 修饰，可以保证对象无法直接修改，只能调用方法去修改
        System.out.println(per1.name);

        PersonInfo per2 = new PersonInfo();

        // 错误: name 在 PersonInfo 中是 private 访问控制
        // System.out.println(per2.name);
        System.out.println(per2.getAge());
        System.out.println(per2.getName());
        per2.setName("aaaa");
        System.out.println(per2.getName());
        per2.setAge(90);
        System.out.println(per2.getAge());

        per2.setNameAge("llj", 16);  // 传递多个变量
        System.out.printf("%s : %d", per2.getName(), per2.getAge());

        // 传递可变参数
        per2.setNumsName("llj", "xyh");
        per2.setNumsName("hahahahahhh");
        per2.setNumsName();

        System.out.println();
        // 参数绑定,基本类型参数的传递 和 引用类型参数的传递
        PersonInfo argbind = new PersonInfo();
        // 分别传递引用类型和基本类型测试
        int n_age = 10;
        String[] n_name = new String[] { "kkp", "haha" };

        argbind.setAge(n_age);
        System.out.println(argbind.getAge());
        argbind.setNumsName(n_name);
        argbind.getNumsName();
        System.out.println("------------------");
        n_age = 20;
        System.out.println(argbind.getAge());
        n_name[0] = "llj";
        argbind.getNumsName();
        // 总结：
        // 基本类型参数的传递：实例和全局变量互不影响（在传值的时候是复制传递）
        // 引用类型参数的传递 （引用类型参数的传递，调用方的变量，和接收方的参数变量，指向的是同一个对象。）

        // 引用字符串（注意：在修改字符串时，新建一个字符串对象）
        String n_str = "Bob";
        argbind.setName(n_str);

        n_str = "alice";  // 注意：此时仅仅将 n_str 指向修改为指向 'alice'
        // 而在我们之前给对象field 的 name赋值时，this.name 已经指向了 Bob
        // 所以：即使我修改了n_str的指向，也不会导致值得改变
        /*
        如下是 字符数组在修改时的内存模型  names[1] = "cat";
          ┌─────────────────────────────────────────────────┐
    names │   ┌─────────────────────────────────┐           │
      │   │   │                                 │           │
      ▼   │   │                                 ▼           ▼
┌───┬───┬─┴─┬─┴─┬───┬───────┬───┬───────┬───┬───────┬───┬───────┬───┐
│   │░░░│░░░│░░░│   │ "ABC" │   │ "XYZ" │   │ "zoo" │   │ "cat" │   │
└───┴─┬─┴───┴───┴───┴───────┴───┴───────┴───┴───────┴───┴───────┴───┘
      │                 ▲
      └─────────────────┘
         */

        // 构造方法：在功能上与Python中__init__(self)方法相同
        // 当我们没有定义构造方法时，编译器会帮我们自定义一个构造方法
        PersonGouZao per3 = new PersonGouZao("shili", 88); // 这一句实现：使用new来调用构造方法
        System.out.println(per3.getName());
        System.out.println(per3.getAge());
        // 不带参数进行初始化
        // 引用类型的字段默认是null，数值类型的字段用默认值，int类型默认值是0，布尔类型默认值是false：
        PersonGouZao per4 = new PersonGouZao();
        System.out.println(per4.getAge());

        PersonGouZao per5 = new PersonGouZao(22, "kkp", 0);
        System.out.println(per5.getAge());
        System.out.println(per5.getName());

        Hello h1 = new Hello();
        h1.hello();
        h1.hello("llj");
        h1.hello("jjj", 6);
        // 方法重载的示例：字符串查找
        String s1 = "Test String";
        System.out.println(s1.indexOf('t')); // 传入字符
        System.out.println(s1.indexOf("st")); // 传入字符串
        System.out.println(s1.indexOf("st", 4)); // 传入字符串和起始位置
        System.out.println(s1.indexOf('e', 0));

        // 实现类的继承
        Student st1 = new Student();
        st1.setName("llj");
        st1.setAge(18);
        st1.setScore(100);
        st1.getStudentInfo();

        // 向上转型
        // 之前我们在new 的时候 : Student st1 = new Student();
        //                引用类型的变量是 Student ，他可以指向一个 Student类型的实例
        // 继承树是 Student > PersonInfo > Object
        // 能否实现 引用类型的变量是 PersonInfo 指向一个Student类型的实例
        PersonInfo p1 = new Student(); //却访问不到Student类型的实例里面的setScore()方法

        Object o1 = new Student();
        // 相当于将 Student 类型转化为 PersonInfo 类型或者更高层次的Object

        // 向下转型
        PersonInfo p2 = new PersonInfo();
        // 向下转型可能会失败，因为父类包含的方法没有子类多了，总不能凭空变！！！
        Student stu1 = (Student) p1; // 这个向下转型是可以成功的，因为p1实际指向的就是Student实例
        stu1.setScore(22); // 转换后就可以访问到此方法

        // 下面这一句会报错，因为p2实际指向的是 PersonInfo对象,报 ClassCastException。
        // Student stu2 = (Student) p2;

        // 为了避免转型错误，Java虚拟机提供了 instanceof
        System.out.println(p1 instanceof Student);

        System.out.println(p2 instanceof PersonInfo);

        // 在转型前先做判断
        if (p2 instanceof Student){
            Student stu2 = (Student) p2;
        } else {
            System.out.println("转型失败：p2 --> Student");
        }


        // 关于继承和组合
        // 继承的父与子之间必须要有逻辑关系，例如 Student的父类是Person,
        // 假如有个 Book类，虽然Student继承他不会有语法错误，但是会在逻辑上不符
        // 继承 的两个类之间必须是 is 关系，组合的两个类之间是 has 关系，这个学生有一本书，
        Book book = new Book();
        /*
        使用组合和继承
        class Student extends PersonInfo{
            protected Book book;  // 组合就是持有一个该类的引用类型变量
            protected int score;
        }
        */












    }
}








