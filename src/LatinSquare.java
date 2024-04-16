public class LatinSquare {

    /**
     *
     * @param rowSize
     * @return given the rowSize N (corresponding to an array of size N x N),
     *         calculate and return the sum of consecutive integers 1 + 2 + ... + N
     */
    public static int targetCheckSum1(int rowSize) {
        return rowSize*(rowSize+1)/2;
    }

    /**
     *
     * @param rowSize
     * @return given the rowSize N (corresponding to an array of size N x N),
     *         calculate and return the product of consecutive integers 1 * 2 * ... * N
     */
    public static int targetCheckSum2(int rowSize) {
       int count = 1;
       for (int i = 1; i<= rowSize ; i++){
           count *= i;
       }
       return count;
    }


    /**
     *
     * @param array2d
     * @param checkSum1
     * @param checkSum2
     * @return whether or not every row's sum in array2d is equal to checkSum1,
     *         AND that every row's product in array2d is equal to checkSum2
     */
    public static boolean isLatinRows(int[][] array2d, int checkSum1, int checkSum2) {
        int rowSize = array2d.length;

        for (int[] row : array2d) {
            // Check if the sum of the row is equal to checkSum1
            int rowSum = 0;
            for (int num : row) {
                rowSum += num;
            }
            if (rowSum != checkSum1) {
                return false;
            }

            // Check if the product of the row is equal to checkSum2
            int rowProduct = 1;
            for (int num : row) {
                rowProduct *= num;
            }
            if (rowProduct != checkSum2) {
                return false;
            }
        }

        return true;
    }
    /**
     *
     * @param array2d
     * @param checkSum1
     * @param checkSum2
     * @return whether or not every column's sum in array2d is equal to checkSum1,
     *         AND that every column's product in array2d is equal to checkSum2
     */
    public static boolean isLatinColumns(int[][] array2d, int checkSum1, int checkSum2) {
        int rowSize = array2d.length;
        int colSize = array2d[0].length;

        for (int col = 0; col < colSize; col++) {
            // Check if the sum of the column is equal to checkSum1
            int colSum = 0;
            for (int row = 0; row < rowSize; row++) {
                colSum += array2d[row][col];
            }
            if (colSum != checkSum1) {
                return false;
            }

            // Check if the product of the column is equal to checkSum2
            int colProduct = 1;
            for (int row = 0; row < rowSize; row++) {
                colProduct *= array2d[row][col];
            }
            if (colProduct != checkSum2) {
                return false;
            }
        }

        return true;
    }


    /**
     *
     * @param array2d
     * @return whether array2d is a Latin square or not.
     *         Hint: make use of isLatinRows and isLatinColumns
     */
    public static boolean isLatinSquare(int[][] array2d) {
        int x = array2d.length;
        int check1 = targetCheckSum1(x);
        int check2 = targetCheckSum2(x);
        if( isLatinRows(array2d, check1, check2) && isLatinColumns(array2d, check1, check2)){
    return true;
        }
        return false;
    }

    /** OPTIONAL (only do if you have time)
     *
     * @param array2d
     * @return whether or not array2d is a latin square
     *         as well as whether the sum and product of each of the two main diagonals is equal
     *         to the checkSums or not.
     *
     * NOTE: not all Latin squares are diagonal; for example, diagonal Latin squares do not exist for 2x2 or 3x3
     */
    public static boolean isDiagonalLatinSquare(int[][] array2d) {
        return false;
    }

}
