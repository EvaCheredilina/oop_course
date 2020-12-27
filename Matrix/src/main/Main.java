package main;


public class Main {
    public static void main(String[] args) {
        try {

            Matrix a = new Matrix(2, 2, new double[][]{{5, 1}, {3, 6}});
            Matrix b = new Matrix(2, 2, new double[][]{{9, 7}, {2, 5}});
            System.out.println(a.toString());
            System.out.println(b.toString());
            a.multiplication(b);
            System.out.println(a.toString());
            a.numberMultiplication(3);
            System.out.println(a.toString());
            a.subtraction(b);
            System.out.println(a.toString());
            System.out.println(b.countDeterminant());
            System.out.println(a==b);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
