import Figures.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeAccumulator {
    private List<Shape> shapes;

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public ShapeAccumulator() {
        this.shapes = new ArrayList<Shape>();
    }

    public void addAll(List<? extends Shape> shapes) {
        this.shapes.addAll(shapes);
    }


    public double getTotalArea() {
        double total = 0;
        for (int i = 0; i < shapes.size(); i++) {
            total += shapes.get(i).calcArea();
        }
        return total;
    }

    public double getTotalPerimeter() {
        double total = 0;
        for (int i = 0; i < shapes.size(); i++) {
            total += shapes.get(i).calcPerimeter();
        }
        return total;
    }

    public final Shape getMaxAreaShape() {

        Shape maxArea = shapes.get(0);
        for ( int i = 0; i < shapes.size(); i++ ) {
            if (maxArea.calcArea() < shapes.get(i).calcArea()) {
                maxArea = shapes.get(i);
            }
        }
        return maxArea;
    }

    public final Shape getMinAreaShape() {

        Shape minArea = shapes.get(0);
        for ( int i = 0; i < shapes.size(); i++ ) {
            if (minArea.calcArea() > shapes.get(i).calcArea()) {
                minArea = shapes.get(i);
            }
        }
        return minArea;
    }

    public final Shape getMaxPerimeterShape() {

        Shape maxArea = shapes.get(0);
        for (int i = 0; i < shapes.size(); i++) {
            if (maxArea.calcPerimeter() < shapes.get(i).calcPerimeter()) {
                maxArea = shapes.get(i);
            }
        }
        return maxArea;
    }

    public final Shape getMinPerimeterShape() {

        Shape minArea = shapes.get(0);
        for (int i = 0; i < shapes.size(); i++) {
            if (minArea.calcPerimeter() > shapes.get(i).calcPerimeter()) {
                minArea = shapes.get(i);
            }
        }
        return minArea;
    }

}
