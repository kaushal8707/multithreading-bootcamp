package com.multithreading.bootcamp.base_networking_threading_processor;

public class World extends Thread {
    @Override
    public void run() {
        for( ; ; ){
            System.out.println("World   "+ " using Thread - "+Thread.currentThread().getName());
        }
    }
}
