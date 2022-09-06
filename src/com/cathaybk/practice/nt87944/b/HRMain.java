package com.cathaybk.practice.nt87944.b;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class HRMain {
    private static String destination = "d:\\output.csv";

    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Sales("張志成", "信用卡部", 35000, 6000));
        employeeList.add(new Sales("林大鈞", "保代部", 38000, 4000));
        employeeList.add(new Supervisor("李中白", "資訊部", 65000));
        employeeList.add(new Supervisor("林小中", "理財部", 80000));
        for (Employee employee : employeeList) {
            employee.printInfo();
        }
        exportCSV(employeeList);   
    }

    public static void exportCSV(List<Employee> employeeList) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        try (OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream(destination), "UTF-8");) {
            for (Employee emp : employeeList) {
                StringBuilder str = new StringBuilder();
                if(emp instanceof Sales){
                    int payment = ((Sales) emp).getPayment();
                    str.append(emp.getName()+","+payment).append("\r\n");
                }else if (emp instanceof Supervisor){
                    int payment = ((Supervisor) emp).getSalary(); 
                    System.out.println(payment);
                    str.append(emp.getName()+","+payment).append("\r\n");
                }
                ow.write(str.toString());
            }
        }
    }
}
