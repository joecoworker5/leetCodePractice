package com.cathaybk.practice.nt87944.b;

import java.util.Map;

public class Sales extends Employee {
    private int bouns;
    private int payment;
    private Map<String, String> map;
    
    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Sales(String name, String department, int salary, int bouns) {
        super(name, department, salary);
        this.bouns = (int) (bouns*0.05);
    }

    public Sales() {
    }

    @Override
    public void printInfo() {
        System.out.println("薪資單");
        System.out.println("姓名: "+super.getName()+"  工作部門: "+super.getDepartment());
        System.out.println("月薪: "+super.getSalary());
        payment= super.getSalary()+bouns;
        System.out.println("業績獎金: "+bouns);
        System.out.println("總計: "+payment);
    }
    

    public int getBouns() {
        return bouns;
    }

    public void setBouns(int bouns) {
        this.bouns = bouns;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

}
