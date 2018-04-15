package com.kovalchuk.genericsRawType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

class Utilities {
    public static <T> void fill(List<T> list, T val) {
        for (int i = 0; i < list.size(); i++)
            list.set(i, val);
    }
}

public class GenericMethods {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        System.out.println("Список до обробки дженерік-методом: " + intList);
        Utilities.fill(intList, 0);
        System.out.println("Список після обробки дженерік-методом: "
                + intList);

        //List<Integer> list = new List<Integer>();//List - інтерфейс
        List<Integer> list = new ArrayList<Integer>();
        //List<Number> list = new ArrayList<Integer>();//Generic типи мають бути одинакові(СТРОГО),хоч Number - абстрактний клас, а Integer його дочірній
        //List<Integer> list = new ArrayList<Number>();//Ієрархія в <> не допускається, для цього є маски
    }
}
