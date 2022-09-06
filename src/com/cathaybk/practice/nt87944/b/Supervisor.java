package com.cathaybk.practice.nt87944.b;

public class Supervisor extends Employee{
    private int payment;
    public Supervisor(String name, String department, int salary) {
        super(name, department, salary);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void printInfo() {
        System.out.println("薪資單");
        System.out.println("姓名: "+super.getName()+"  工作部門: "+super.getDepartment());
        System.out.println("月薪: "+super.getSalary());
        System.out.println("總計: "+super.getSalary());
    }
    public int getPayment() {
        return payment;
    }
    public void setPayment(int payment) {
        this.payment = payment;
    }
    
}
