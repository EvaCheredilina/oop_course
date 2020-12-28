package Figures;

public class Rectangle implements Shape {
    private double width;
    private double length;

    public Rectangle(double width, double length) throws Exception {
        if (width > 0 && length > 0) {
            this.width = width;
            this.length = length;
        } else throw new Exception("Given width or height does not fit");
    }

    public final double getLength() {
        return length;
    }

    public void setLength(double length) throws Exception {
        if (length > 0)
            throw new Exception("Given width does not fit");
        this.length = length;
    }

    public final double getWidth() {
        return width;
    }

    public void setWidth(double width) throws Exception {
        if (width > 0)
            throw new Exception("Given width does not fit");
        this.width = width;
    }

    @Override
    public double calcArea() {
        return width * length;
    }

    @Override
    public double calcPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle(" + width + 'x' + length + ')';
    }
}
