/**
* Driver
*/
import java.util.*;

class Cat implements Runnable {
    int c = 0;
    
    public void run() {
        for (int i = 0; i < 100000; i++) {
            synchronized(this) {
                c++;
                c--;
            }
        }
        System.out.println("Cat is running");
    }
}

class Dog implements Runnable {
    public void run() {
        System.out.println("Dog is running");
    }
}

public class Driver {
    public static void main(String[] args) {
        Cat cat = new Cat();
        // Dog dog = new Dog();
        
        // Thread t1 = new Thread(cat);
        // Thread t2 = new Thread(cat);
        // Thread t3 = new Thread(cat);
        // Thread t2 = new Thread(cat);
        // Thread t2 = new Thread(cat);
        
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(cat));
        }
        
        for (Thread t : threads) {
            t.start();
        }
        
        
        System.out.println("c = " + cat.c);
        
    }
}