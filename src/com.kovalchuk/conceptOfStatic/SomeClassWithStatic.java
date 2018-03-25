package com.kovalchuk.conceptOfStatic;

public class SomeClassWithStatic {
    public static int variable = 1;
    private static int i=0;
    private final int ID=i++;


    public int getID() {
        return ID;
    }

    public void add(int var){
        variable += var;
    }

    public static void printVariable(){
        System.out.println(variable);
    }

}