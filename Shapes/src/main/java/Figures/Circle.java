package Figures;

public class Circle implements Shape {
    private double radius;

    public Circle(double i) throws Exception {
        if (i < 0)
            throw new Exception("Negative radius");
        this.radius = i;
    }

    public final double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws Exception {
        if (radius < 0)
            throw new Exception("Negative radius");
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle(" + radius + ')';
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * radius;
    }

}
