package com.kovalchuk.principlesOfMultithreading;

public class CounterTester
{
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        for(int i=0; i<200; i++) {
            if(i%2==0) {
                CounterThreadOne ct = new CounterThreadOne(counter);
                ct.start();
            }
            else {
            Thread myThread = new Thread(new CounterThreadTwo(counter));
            myThread.start();
            }
            //ct.join();//потік в котрому викликали anotherThread.join() продовжить
            // свою роботу після закінчення роботи anotherThread
            //System.out.println("Counter:" + counter.getCounter());
        }
        Thread.sleep(1000);//потік в котрому викликали sleep(miliSec) засипає на miliSec/1000 сек.

        System.out.println("Counter:" + counter.getCounter());
    }
}

class Counter
{
    private long counter = 0L;

    /*public synchronized void increaseCounter() {
        counter++;
    }//1-ий варіант*/
    public void increaseCounter() {
        synchronized(this) {
            counter++;
        }
    }//2-ий варіант

    public long getCounter() {
        return counter;
    }
}

class CounterThreadOne extends Thread
{
    private Counter counter;

    public CounterThreadOne(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0; i<1000; i++) {
            counter.increaseCounter();
        }
    }
}

class CounterThreadTwo implements Runnable
{
    private Counter counter;

    public CounterThreadTwo(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=0; i<1000; i++) {
            counter.increaseCounter();
        }
    }
}
