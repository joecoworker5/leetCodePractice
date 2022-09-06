package com.cathaybk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class Test2 {

	 public static void main (String[] args) throws java.lang.Exception
	    {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String input = br.readLine();
	        String[] s = input.split(" ");
	        Integer n = Integer.valueOf(s[0]);
	        Integer c = Integer.valueOf(s[1]);
	        NewQueue q = new NewQueue(c);
	        String thisLine = null;
	        while ((thisLine = br.readLine()) != null) {
	            if(thisLine.startsWith("OFFER")){
	                String[] var = thisLine.split(" ");
	                System.out.println(q.offer(s[1]));
	            }else if(thisLine.equals("TAKE")){
	                System.out.println(q.take());
	            } else {
	                System.out.println(q.size());
	            }
	        }
	        "hello".substring(6).isE;
	    }

}

class NewQueue {
    int limit = 0;
    Queue<String> q = new SynchronousQueue<>();
    
    public NewQueue(int limit){
        this.limit = limit;
    }

    public boolean offer(String word){
        if(q.size()>=this.limit){
            return false;
        }
        q.add(word);
        return true;
    }

    public String take(){
        return q.poll();
    }

    public Integer size(){
        return q.size();
    }
}