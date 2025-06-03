package com.multithreading.bootcamp.base_networking_threading_processor;

public class Java implements Runnable {
    @Override
    public void run() {
        for( ; ; ){
            System.out.println("Java   "+ " using Thread - "+Thread.currentThread().getName());
        }
    }
}