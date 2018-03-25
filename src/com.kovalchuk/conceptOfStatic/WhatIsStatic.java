package com.kovalchuk.conceptOfStatic;

public class WhatIsStatic {
    public static void main(String[] args) {
        SomeClassWithStatic.printVariable();
        SomeClassWithStatic.variable = 4;
        SomeClassWithStatic someClass = new SomeClassWithStatic();
        someClass.add(3);
        SomeClassWithStatic.printVariable();
        System.out.println(String.format("%s_ID=%s", "someClass",
                someClass.getID()));
        SomeClassWithStatic someClass2 = new SomeClassWithStatic();
        System.out.println(String.format("%s_ID=%s", "someClass2",
                someClass2.getID()));
    }
}
