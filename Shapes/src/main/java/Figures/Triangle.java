package Figures;

public class Triangle implements Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) throws Exception {
        if (!(((a + b) > c) && ((a + c) > b) && ((b + c) > a)))
            throw new Exception("The entered triangle lengths are not allowed");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(double a) throws Exception {
        if (!(((a + b) > c) && ((a + c) > b) && ((b + c) > a)))
            throw new Exception("The entered triangle lengths are not allowed");
        this.a = a;
    }

    public final double getB() {
        return b;
    }

    public void setB(double b) throws Exception {
        if (!(((a + b) > c) && ((a + c) > b) && ((b + c) > a)))
            throw new Exception("The entered triangle lengths are not allowed");
        this.b = b;
    }

    public final double getC() {
        return c;
    }

    public void setC(double c) throws Exception {
        if (!(((a + b) > c) && ((a + c) > b) && ((b + c) > a)))
            throw new Exception("The entered triangle lengths are not allowed");
        this.c = c;
    }

    @Override
    public double calcArea() {
        double p = this.calcPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double calcPerimeter() {
        return (a + b + c);
    }

    public final double getA() {
        return a;
    }

    @Override
    public String toString() {
        return "Triangle(" + Double.valueOf(a) + ',' + Double.valueOf(b) + ',' + Double.valueOf(c) + ')';
    }
}
