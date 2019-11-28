package ming;

class Test_Import{
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}


// 定义为 public 的 class , field, method , 可以被其他类访问到，
// 访问到 public field,method的前提是所在的类必须是public才可以
public class Test {
    public void printTest(){
        System.out.println("import test");
    }

    private int age;
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    public int count;
    // 访问到 public field,method的前提是所在的类必须是public才可以，所以在其他类中无法访问到tc1，
    // 是因为Test_Import没有用public修饰
    public Test_Import tc1 = new Test_Import();

    public static void main(String[] args){
        Inner in1 = new Inner();
        in1.hi();
    }

    private static void hello() {
        System.out.println("嵌套静态方法");
    }

    static class Inner{
        public void hi(){
            Test.hello();
        }
    }
}
