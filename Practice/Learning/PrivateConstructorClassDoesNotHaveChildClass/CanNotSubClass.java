package com.test;

public class CanNotSubClass  {
    private CanNotSubClass(){

    }
    public static CanNotSubClass getInstance(){
        return new CanNotSubClass();
    }

    public static void main(String[] args) {
        SuperClass SuperClassObj = new SuperClass();
    }
}

class SuperClass extends CanNotSubClass {

    public SuperClass(){
        System.out.println("Print");
    }
}


