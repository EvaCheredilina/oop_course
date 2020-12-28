package Figures;

public class Square implements Shape {
    private double length;

    public Square(double length) throws Exception {
        if (length < 0) throw new Exception("Given length does not fit");
        this.length = length;
    }

    public final double getLength() {
        return length;
    }

    public void setLength(double length) throws Exception {
        if (length < 0) throw new Exception("Given length does not fit");
        this.length = length;
    }

    @Override
    public String toString() {
        return "Square(" + length + 'x' + length + ')';
    }

    @Override
    public double calcArea() {
        return Math.pow(length, 2);
    }

    @Override
    public double calcPerimeter() {
        return 4 * length;
    }

}
