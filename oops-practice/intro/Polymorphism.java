/**
* Polymorphism
*/
class Bird {
    void fly() {
        System.out.println("Bird is flying");
    }
}

class Crow extends Bird {
    void fly() {
        System.out.println("Crow is flying");
    }
}



public class Polymorphism {
    
    public static void run(Bird bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        Bird bird = new Bird();
        Crow crow = new Crow();
        
        run(bird);
        run(crow);
        
        Bird someBird = crow;
        someBird.fly();
        
    }
}