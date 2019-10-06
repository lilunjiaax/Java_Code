package itheima;

import java.util.Arrays;
/*
 * 多态：
 * final : 修饰的方法不允许Override,修饰的类不允许被继承,修饰的字段一旦被赋值不允许在被修改
 * 抽象类：父类里面的方法不需要实现功能，仅仅是为了让子类的覆盖，来实现多态，那么可以把父类的方法声明为抽象方法
 * 不能去掉父类里面的此方法，因为一旦去掉，多态性也就不成立了（抽象方法必须在抽象类里面）
 * 抽象类自己不可以产生实例对象，但可以作为向上转型 的类型来使用，再配合多态来实现函数的一致性
 *
 * 面向抽象编程：
 * 1. 上层代码只定义规范（例如：abstract class Person）
 * 2. 不需要子类就可以实现业务逻辑（正常编译）
 * 3. 具体的业务逻辑由不同的子类实现，调用者并不关心。
 *
 * 接口：interface，如果一个抽象类没有字段，全是方法，就可以改写为接口，接口中定义的
 * 方法默认全是 public abstract 的，
 *
 * */

final class Private_Person {
    // 修饰的类不允许被继承
    protected String name;

    public final String name1;
    // 可以在构造方法中初始化final字段：
    public Private_Person(String name1){
        // 可以保证实例一旦创建，其final字段就不可修改。
        this.name1 = name1;
    }
}

// 抽象基类
abstract class Person_0602{

    public abstract void run(); // 这是抽象类中的抽象方法
}

class Teacher extends Person_0602 {

    @Override
    public void run() {
        System.out.println("TeacherRuning");
    }
}



class Person_06 {
    public void run() {
        System.out.println("父类 run 方法");
    }

    // 该方法不允许被覆写
    public final void run2() {
        System.out.println("该方法不允许被覆写");
    }
}

class Student_06 extends Person_06 {
    @Override
    public void run() {
        // 调用父类被覆盖的方法
        System.out.println("调用父类被覆盖的方法");
        super.run();
        System.out.println("run 方法覆盖");
    }
}

class Person061 {
    // 继承Object, 重写Object里面的方法
    @Override
    public int hashCode() {
        // return this.name.hashCode();
        return 123;
    }

}

class Income {

    protected double income;
    public Income(double income) {
        this.income = income;
    }
    // 最简单基础的税种计算方法
    public double getTax() {
        return this.income * 0.1;
    }
}

class Salary extends Income {

    public Salary(double income) {
        super(income);
    }

    // 工资收入该交的税
    @Override
    public double getTax() {
        if (this.income <= 5000){
            return 0;
        } else {
            return (this.income - 5000) * 0.1;
        }
    }
}

class StateCouncilSpecialAllowance extends Income {

    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    // 享受国务院津贴
    @Override
    public double getTax() {
        return 0;
    }
}

abstract class IncomeBase {
    protected double income;

    public IncomeBase(double income) {
        this.income = income;
    }

    public abstract double getTax();
}

class SalaryIncome extends IncomeBase {
    // 构造方法不会继承，只能用super去调用
    public SalaryIncome(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (this.income <= 5000){
            return 0;
        } else {
            return (this.income - 5000) * 0.1;
        }
    }
}

class OtherIncome extends IncomeBase{
    public OtherIncome(double income){
        super(income);
    }
    @Override
    public double getTax() {
        return this.income * 0.1;
    }
}


interface Hello_06 {
    void hello();
}

interface Hello_061 {
    void hello2();
}

// 接口与接口之间可以相互继承
interface Hello_062 extends Hello_06 {
    void run();
    String getName();
}


// 一个类继承一个接口，也能同时继承多个接口
/*
class Student_Hello implements Hello_06, Hello_061 {} 实现了两个interface
*/

class Student_Hello implements Hello_06, Hello_061 {
    private String name;
    public Student_Hello(String name) {
        this.name = name;
    }
    @Override
    public void hello(){
        System.out.println(this.name + "running");
    }
    @Override
    public void hello2(){
        System.out.println("hello2");
    }
}


// 利用interface实现税收计算
interface IncomeInterface {
    double getTax();
}

class Salary_Inter implements IncomeInterface {
    private double income;
    public Salary_Inter(double income) {
        this.income = income;
    }

    @Override
    public double getTax(){
        if (this.income <= 5000){
            return 0;
        } else {
            return (this.income-5000)*0.1;
        }
    }
}

class Other_Inter implements IncomeInterface {
    private double income;
    public Other_Inter(double income) {
        this.income = income;
    }
    @Override
    public double getTax() {
        return this.income*0.1;
    }
}



public class Chapter06 {

    public static double totalTax(Income...incomes) {
        double total = 0;
        for (Income income_ : incomes) {
            total = total + income_.getTax();
        }
        return total;
    }


    public static void main(String[] args){
        System.out.println("Chapter06");

        // 覆盖：子类定义的方法与父类的方法完全相同，方法名，返回类型，参数等
        // 当不符合覆盖条件时，报 compile error
        Student_06 stu1 = new Student_06();
        Person_06 per1 = (Person_06) stu1;
        per1.run();  // 发现运行却是 Student 里面的run方法
        // Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型 --> 多态

        // 利用多态实现简单税种计算
        Income[] incomes = new Income[] { new Income(3600), new Salary(6000), new StateCouncilSpecialAllowance(2000) };

        System.out.println(totalTax(incomes));
        // 多态：利用子类实现函数功能的扩展，却不需要修改基于父类的代码

        Person061 person061 = new Person061();
        System.out.println(person061.hashCode());

        // final 的使用
        Private_Person pri1 = new Private_Person("kkp");
        System.out.println(pri1.name1);

        // 实例化抽象基类的子类
        Person_0602 tea1 = new Teacher();
        tea1.run();

        // 利用抽象基类实现 税收计算
        IncomeBase[] incomess = new IncomeBase[] { new SalaryIncome(6000), new OtherIncome(2000) };
        double totalIncomes = 0;
        for (IncomeBase income : incomess){
            totalIncomes += income.getTax();
        }
        System.out.println(totalIncomes);

        // 利用interface实现税收计算
        IncomeInterface[] incomes_inter = new IncomeInterface[] { new Salary_Inter(6000), new Other_Inter(1000) };
        double totalIncomes_inter = 0;
        for (IncomeInterface income : incomes_inter){
            totalIncomes_inter += income.getTax();
        }
        System.out.println(totalIncomes_inter);

    }

}
