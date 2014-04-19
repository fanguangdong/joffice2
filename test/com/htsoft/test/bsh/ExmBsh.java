package com.htsoft.test.bsh;

import bsh.Interpreter;  

public class ExmBsh {  
    public static void main(String[] args) {  
        System.out.println("start:");  
        
        String code="String result=\"Demox\";System.out.println(\"ABC\");";
        try {  
            // Construct an BeanShell interpreter  
            Interpreter i = new Interpreter();   
//            i.set("x1", 5); // Set variables  
//            i.set("x2", 5); // Set variables  
//            i.set("x3", 5); // Set variables  
//            i.set("x4", 5); // Set variables  
//            i.set("x5", 5); // Set variables  
//  
//            // Eval a statement and get the result  
//            i.eval("x6=x1+x2+(x3+x4)/x5*10");  
//            i.eval("x7=4.5555-x6");  
//  
//            System.out.println("x1:" + i.get("x1"));  
//            System.out.println("x2:" + i.get("x2"));  
//            System.out.println("x3:" + i.get("x3"));  
//            System.out.println("x4:" + i.get("x4"));  
//            System.out.println("x5:" + i.get("x5"));  
//            System.out.println("x6:" + i.get("x6"));  
//            System.out.println("x7:" + i.get("x7"));  
            
            i.eval(code);
            System.out.println("name:" + i.get("result"));
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.out.println("end:");  
    }  
}  