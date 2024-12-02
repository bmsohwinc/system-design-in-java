/**
* Volumer
*/

import java.util.*;

interface Shape {
    double getVolume();
}


class Cuboid implements Shape {
    double length;
    double width;
    double height;
    
    public Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    public double getVolume() {
        return length * width * height;
    }
}

class Cylinder implements Shape {
    double length;
    double radius;
    double pi;
    
    public Cylinder(double length, double radius) {
        this.length = length;
        this.radius = radius;
        this.pi = 3.14;
    }
    
    public double getVolume() {
        return pi * radius * radius * length;
    }
}

class VolumeCalculator {
    public double getTotalVolume(List<Shape> shapes) {
        double totalVolume = 0;
        // for (Shape shape: shapes) {
        //     totalVolume += shape.getVolume();
        // }
        totalVolume = shapes.stream().map(Shape::getVolume).reduce(0.0, Double::sum);
        return totalVolume;
    }
}





public class Volumer {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid(10, 20, 30);
        VolumeCalculator volCalculator = new VolumeCalculator();
        System.out.println(volCalculator.getTotalVolume(List.of(cuboid)));
    }
}