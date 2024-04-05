package codewars.task1;

public class Matrix {
    public static int determinant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        int det = 0;
        for (int j = 0; j < n; j++) {

            int[][] minorMatrix = createMinorMatrix(matrix, 0, j);

            int sign = (j % 2 == 0) ? 1 : -1;
            det += sign * matrix[0][j] * determinant(minorMatrix);
        }
        return det;
    }

    private static int[][] createMinorMatrix(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] minorMatrix = new int[n - 1][n - 1];
        int rowIndex = 0, colIndex;
        for (int i = 0; i < n; i++) {
            if (i == row) {
                continue;
            }
            colIndex = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) {
                    continue;
                }
                minorMatrix[rowIndex][colIndex] = matrix[i][j];
                colIndex++;
            }
            rowIndex++;
        }
        return minorMatrix;
    }
}