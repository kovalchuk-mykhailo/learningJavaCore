package com.kovalchuk.genericsRawType;

import javax.swing.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BaseOfGenerics {
    public static void main(String[] args) {
        BoxPrinter<Integer> a = new BoxPrinter<Integer>(new Integer(5));
        System.out.println(a);
        Integer intValue1 = a.getValue();

        BoxPrinter<String> b = new BoxPrinter<String>("Hello world");
        System.out.println(b);
        String intValue2 = b.getValue();

        //Integer intValue3 = b.getValue();//Помилка компіляції (Очікується: Integer, а в об'єкті: String)
        //Integer intValue4 = (Integer) b.getValue();//Помилка компіляції (can not cast String to Integer)

        BoxPrinter c = new BoxPrinter("people");//RawType - простий тип(не вказуємо параметри, без<>) значить Object
        String string = (String) c.getValue();
        //Integer intValue5 = (Integer) c.getValue();//RunTimeException (ClassCastException:String cannot be cast to Integer)
        System.out.println(c);

        Pair<Integer, String> pair1 = new Pair<Integer, String>(6,
                " Apr");
        //Pair<Integer, String> pair1 = new Pair<String, String>(6, " Apr");//Помилка компіляції (Очікується: <Integer,String> а в об'єкті: <String,String>)
        System.out.println(pair1.getFirst() + pair1.getSecond());

        //Diamond syntax below, з правої сторони опускаємо параметри
        Pair<Integer, String> pair2 = new Pair<>(7, " Mar");
        //Pair<Integer, String> pair3 = new Pair<>("hello", " Mar");//Помилка компіляції

        List<String> list11 = new LinkedList<String>();
        list11.add("First");
        list11.add("Two");
        //list11.add(20);//Помилка компіляції
        List list12 = list11;
        for (Iterator<String> itemItr = list12.iterator(); itemItr.hasNext(); )
            System.out.println(itemItr.next());

        List list01 = new LinkedList();
        list01.add("First");
        list01.add(20);//добавляємо різні типи, Все ок
        List<String> list02 = list01;//Тут також все ок
        for (Iterator<String> itemItr = list02.iterator(); itemItr.hasNext(); )
            System.out.println(itemItr.next());//RunTimeException(Integer cannot be cast to String)
    }
}

class BoxPrinter<T> {
    private T val;

    public BoxPrinter(T arg) {
        val = arg;
    }

    public String toString() {
        return "{" + val + "}";
    }

    public T getValue() {
        return val;
    }
}

class Pair<T1, T2> {
    T1 object1;
    T2 object2;

    Pair(T1 one, T2 two) {
        object1 = one;
        object2 = two;
    }

    public T1 getFirst() {
        return object1;
    }

    public T2 getSecond() {
        return object2;
    }
}
