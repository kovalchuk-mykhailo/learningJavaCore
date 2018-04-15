package com.kovalchuk.genericsRawType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestWildcardsParameters {
    static void printList(List<?> list) {
        for (Object l : list)
            System.out.println("{" + l + "}");
    }

    static void printListNumber(List<? extends Number> list) {
        for (Number l : list)
            System.out.println("{" + l.doubleValue() + "}");
    }

    public static Double sum(List<? extends Number> numList, String title) {
        if (!title.isEmpty())
            System.out.print(title);

        Double result = 0.0;
        for (Number num : numList) {
            result += num.doubleValue();
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(100);
        printList(list);
        printListNumber(list);
        System.out.println(sum(list, "Sum: "));
        List<String> strList = new ArrayList<>();
        strList.add("10");
        strList.add("100");
        printList(strList);

        List<? super Integer> intList = new LinkedList<Object>();//<? super Integer> - означає що можуть бути типи Integer та його батьки
        //List<? super Integer> intList = new ArrayList<Number>();//Добавити елементи не зможемо так як неможливо визначити тип Number
        intList.add(2);
        intList.add(15);
        System.out.println("The intList is: " + intList);
    }
}
