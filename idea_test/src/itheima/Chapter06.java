package itheima;

import java.util.Arrays;
/*
 * 多态：
 * final : 修饰的方法不允许Override,修饰的类不允许被继承,修饰的字段一旦被赋值不允许在被修改
 *
 *
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


    }

}
