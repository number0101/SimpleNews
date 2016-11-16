package zeta.example.com.myapplication.entity;

/**
 * Created by Adamlambert on 2016/10/13.
 */
public class Student {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name="+name+",age="+age;
    }
}
