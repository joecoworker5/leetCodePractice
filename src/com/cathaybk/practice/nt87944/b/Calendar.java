package com.cathaybk.practice.nt87944.b;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Calendar {
  
    
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("请输入1-12間的整數m：");
        int month = in.nextInt(); 
        LocalDate date = LocalDate.of(LocalDate.now().getYear(), month, 1);
        int year = date.getYear();

        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();
        System.out.println("           "+year+"年"+month+"月      ");
        System.out.println("   日       一       二      三      四      五      六");

        for (int i = 0; i < value % 7; i++) 
        {
            System.out.print("    ");
        }

        while (date.getMonthValue() == month) 
        {
            System.out.printf("%3d", date.getDayOfMonth());

                System.out.print(" ");
            if (date.getDayOfWeek().getValue() == 6)
            {
                System.out.println();
            }
            date = date.plusDays(1);
        }

    }

}
