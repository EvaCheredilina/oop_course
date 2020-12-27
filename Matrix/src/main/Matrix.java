package main;

import java.util.Arrays;
import java.util.Objects;

public class Matrix {
    private int rows;
    private int columns;
    private double[][] matrix;


    //matrix initialization
    public Matrix(int rows, int columns, double[][] matrix) throws IllegalArgumentException {

        int zeroSz = 0;
        if(matrix.length > 0) zeroSz = matrix[0].length;

        for(double[] row: matrix) {
            if (row.length != zeroSz) throw new IllegalArgumentException("incorrect matrix");
        }

        if (rows < 0 || columns < 0)
            throw new IllegalArgumentException("Invalid matrix input!");
        else {
            this.rows = rows;
            this.columns = columns;
            this.matrix = matrix.clone();
        }
    }

    //viewing element value
    public double getElement(int i, int j) throws IllegalArgumentException {
        if ((i < 0) || (j < 0) || (i >= this.rows || j >= this.columns))
            throw new IllegalArgumentException("Invalid indexes!");
        else
            return matrix[i][j];
    }
    //element changing
    public void changeElement(int i, int j, double element) throws IllegalArgumentException {
        if ((i < 0) || (j < 0) || (i >= rows || j >= columns))
            throw new IllegalArgumentException("Invalid indexes");
        else
            matrix[i][j] = element;
        return;
    }

    //view the number of lines
    public int getRows() {
        return rows;
    }

    //view the number of columns
    public int getColumns() {
        return columns;
    }

    //matrix addition
    public void addition(Matrix addingMatrix) throws IllegalArgumentException {
        if ((rows != addingMatrix.rows) && (columns != addingMatrix.columns))
            throw new IllegalArgumentException("Invalid sizes");
        else {
            for (int i = 0; i < rows; ++i)
                for (int j = 0; j < columns; ++j)
                    matrix[i][j] += addingMatrix.matrix[i][j];
        }
    }

    //matrix subtraction
    public void subtraction(Matrix subtractingMatrix) throws UnsupportedOperationException {
        if ((rows != subtractingMatrix.rows) && (columns != subtractingMatrix.columns))
            throw new UnsupportedOperationException("Invalid sizes");
        else {
            for (int i = 0; i < rows; ++i)
                for (int j = 0; j < columns; ++j)
                    matrix[i][j] -= subtractingMatrix.matrix[i][j];
        }
        return;
    }

    public void multiplication(Matrix other_Matrix) throws UnsupportedOperationException {
        if (rows != other_Matrix.columns)
            throw new UnsupportedOperationException("Invalid sizes");
        else {
            double[][] res_Matrix = new double[other_Matrix.rows][other_Matrix.columns];
            for (int i = 0; i < rows; ++i)
                for (int j = 0; j < columns; ++j) {
                    for (int k = 0; k < other_Matrix.rows; ++k) {
                        res_Matrix[i][j] += matrix[i][k] * other_Matrix.matrix[k][j];
                    }
                }
            matrix = res_Matrix;
        }
        return;
    }

    //matrix multiplication by number
    public void numberMultiplication(double scalar) {
        for (int i = 0; i < this.rows; ++i)
            for (int j = 0; j < this.columns; ++j)
                matrix[i][j] *= scalar;
        return;
    }

    //computation determinant
    public double countDeterminant() throws Exception {
        if (rows != columns)
            throw new Exception("Invalid size");
        else
            return this.countDeterminant(matrix, this.rows);
    }

    //minor calculation
    private double[][] getSubmatrix(double initialMatrix[][], int N, int j1) {
        double[][] submatrix = new double[N - 1][];
        for (int k = 0; k < (N - 1); k++)
            submatrix[k] = new double[N - 1];

        for (int i = 1; i < N; i++) {
            int j2 = 0;
            for (int j = 0; j < N; j++) {
                if (j == j1)
                    continue;
                submatrix[i - 1][j2] = initialMatrix[i][j];
                j2++;
            }
        }
        return submatrix;
    }

    //calculation of the determinant of a matrix by the method of algebraic complements
    private double countDeterminant(double matrix[][], int N) {
        double result;
        if (N == 1) return matrix[0][0];
        else if (N == 2) return (matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1]);
        else {
            double[][] temporaryMatrix = null;
            result = 0;
            for (int j1 = 0; j1 < N; j1++) {
                temporaryMatrix = getSubmatrix(matrix, N, j1);
                result += Math.pow(-1.0, 1.0 + j1 + 1.0) * matrix[0][j1] * countDeterminant(temporaryMatrix, N - 1);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        if (this.rows == matrix1.rows && this.columns == matrix1.columns) {
            for (int i = 0; i < this.columns; ++i)
                for (int j = 0; j < this.rows; ++j)
                    if (this.matrix[i][j] != matrix1.matrix[i][j])
                        return false;
        } else return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, columns);
        result = 27 * result + Arrays.hashCode(matrix);
        return result;
    }


    //matrix as string
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j)
                str.append(Double.toString(matrix[i][j])).append(' ');
            str.append('\n');
        }
        return str.toString();
    }

}


