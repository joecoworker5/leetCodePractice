package com.cathaybk.practice.nt87944.b;

public class Multiply {
    static String result;
    public static void main(String[] args) {
        for(int i=1; i<=9; i++){
            for(int j=2; j<=9; j++){
                 if(i*j<10){
                     result=" "+i*j;
                 } else {
                     result=String.valueOf(i*j);
                 }
               System.out.print(j+"*"+i+"="+result+" ");
            }
            System.out.println();
        }

    }

}
