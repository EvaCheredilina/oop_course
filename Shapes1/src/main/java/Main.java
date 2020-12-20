import Figures.*;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        try {
           /* Circle circle = new Circle(9);
            Rectangle rectangle = new Rectangle(1, 2);
            Square square = new Square(6);
            Triangle triangle = new Triangle(4, 6, 7);
            Triangle triangle1 = new Triangle(5, 5, 5);
            List<Shape> shapes = new ArrayList<>();//Arrays.asList(circle, rectangle, square, triangle);

            shapes.add(square);
            shapes.add(triangle);
            shapes.add(rectangle);
            shapes.add(circle);

            WorkWithFile.write(shapes);
            ShapeAccumulator shapeAccumulator = new ShapeAccumulator();

            shapeAccumulator.addAll((List<Figures.Shape>) (WorkWithFile.read()));

            double min_Area = shapeAccumulator.getMinAreaShape().calcArea();
            double max_Area = shapeAccumulator.getMaxAreaShape().calcArea();

            double min_Perimeter = shapeAccumulator.getMinPerimeterShape().calcPerimeter();
            double max_Perimeter = shapeAccumulator.getMaxPerimeterShape().calcPerimeter();

            double totalArea = shapeAccumulator.getTotalArea();

            System.out.println("The maximum area has a " + shapeAccumulator.getMaxAreaShape().getClass().getSimpleName() + " is equal to " + max_Area);
            System.out.println("The minimum area has a " + shapeAccumulator.getMinAreaShape().getClass().getSimpleName() + " is equal to " + min_Area);
            System.out.println("The maximum Perimeter has a " + shapeAccumulator.getMaxPerimeterShape().getClass().getSimpleName() + " is equal to " + max_Perimeter);
            System.out.println("The minimum Perimeter has a " + shapeAccumulator.getMinPerimeterShape().getClass().getSimpleName() + " is equal to " + min_Perimeter);
            System.out.println("The sum of all areas shapes is " + totalArea);
*/
            new MainForm();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
