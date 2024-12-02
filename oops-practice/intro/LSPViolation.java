/**
* LSPViolation

How Liskov Substitution principle is violated in Square and Rectangle example.

*/

class Rectangle {
    private int length;
    private int width;
    
    public Rectangle (int length, int width) {
        this.length = length;
        this.width = width;
    }
    
    public int getLength() {
        return this.length;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void setLength(int length) {
        this.length = length;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getArea() {
        return length * width;
    }
}

class Square extends Rectangle {
    public Square(int length) {
        super(length, length);
    }
}



public class LSPViolation {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2, 3);
        System.out.println("Rectangle: " + rectangle.getArea());
        rectangle.setWidth(rectangle.getWidth() * 2);
        System.out.println("Rectangle: " + rectangle.getArea());
        
        Square square = new Square(10);
        System.out.println("Square: " + square.getArea());
        
        Rectangle newRectangle = square;
        System.out.println("Rectangle: " + newRectangle.getArea());
        newRectangle.setLength(2);
        System.out.println("Rectangle: " + newRectangle.getArea());
    }
}