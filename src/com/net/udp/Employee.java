package com.net.udp;

import java.io.Serializable;

/**
 * 员工类 封装数据  实现 序列化
 */
public class Employee  implements Serializable {
    private transient String name; //该数据不需要序列化
    private double salary;
    public Employee() {
    }
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
