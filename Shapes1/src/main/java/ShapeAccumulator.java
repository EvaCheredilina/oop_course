import Figures.Shape;

import java.lang.reflect.Array;
import java.util.*;

public class ShapeAccumulator {
    private List<Shape> shapes;

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public ShapeAccumulator() {
        this.shapes = new ArrayList<Shape>();
    }

    public void addAll(Collection<? extends Shape> shapes) {
        Shape[] arr = (Shape[]) shapes.toArray();

        this.shapes.addAll(Arrays.asList(arr));
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
        if(shapes.size() == 0) return  null;
        Shape maxArea = shapes.get(0);
        for ( int i = 0; i < shapes.size(); i++ ) {
            if (maxArea.calcArea() < shapes.get(i).calcArea()) {
                maxArea = shapes.get(i);
            }
        }
        return maxArea;
    }

    public final Shape getMinAreaShape() {
        if(shapes.size() == 0) return  null;
        Shape minArea = shapes.get(0);
        for ( int i = 0; i < shapes.size(); i++ ) {
            if (minArea.calcArea() > shapes.get(i).calcArea()) {
                minArea = shapes.get(i);
            }
        }
        return minArea;
    }

    public final Shape getMaxPerimeterShape() {
        if(shapes.size() == 0) return  null;
        Shape maxArea = shapes.get(0);
        for (int i = 0; i < shapes.size(); i++) {
            if (maxArea.calcPerimeter() < shapes.get(i).calcPerimeter()) {
                maxArea = shapes.get(i);
            }
        }
        return maxArea;
    }

    public final Shape getMinPerimeterShape() {
        if(shapes.size() == 0) return  null;
        Shape minArea = shapes.get(0);
        for (int i = 0; i < shapes.size(); i++) {
            if (minArea.calcPerimeter() > shapes.get(i).calcPerimeter()) {
                minArea = shapes.get(i);
            }
        }
        return minArea;
    }

}
