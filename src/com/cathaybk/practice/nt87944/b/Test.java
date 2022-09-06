package com.cathaybk.practice.nt87944.b;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        // create a StringBuilder object
        // with a String pass as parameter
        StringBuilder str = new StringBuilder("GeeksForGeeks");

        System.out.println(str.substring(0, 5));
        System.out.println(str);
        Test.change(str);
        System.out.println(str);
        
    }

    static void change(StringBuilder string) {
//        string.setLength(0);
//        string = string.append("yeah");
        String substring = string.toString().substring(7);
        string.delete(0, string.length()).append(substring);
    }
}
