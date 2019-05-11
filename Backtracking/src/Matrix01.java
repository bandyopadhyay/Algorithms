public class Matrix01 {


    public static void main(String[] args){

        Matrix01 m01 = new Matrix01();
        int[][] matrix = {{1,1,1},{1,1,1},{1,1,1}};
        int[][] result = m01.updateMatrix(matrix);
        int  row = matrix.length;
        int column = matrix[0].length;

        for(int i = 0; i< row; i++) {
            for (int j = 0; j < column; j++) {
                    System.out.print(result[i][j] +", ");
            }
            System.out.println();
        }
    }


    public int[][] updateMatrix(int[][] matrix) {

        int  row = matrix.length;
        int column = matrix[0].length;
        int[][] result = new int[row][column];
        int[][] visited = new int[row][column];

        for(int i = 0; i< row; i++) {
            for(int j = 0; j < column; j++){
                if(matrix[i][j] == 0){
                    result[i][j]=0;
                } else {
                    result[i][j] = getDistance(matrix, i, j, visited);
                }
            }
        }

        return result;

    }


    private int getDistance(int[][] matrix, int i, int j, int[][] mark) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || mark[i][j] == 1) {
            return 100000;
        }

        if (i - 1 >= 0 && matrix[i - 1][j] == 0) {
            return 1;
        }
        if (j - 1 >= 0 && matrix[i][j - 1] == 0) {
            return 1;
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] == 0) {
            return 1;
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] == 0) {
            return 1;
        }
        mark[i][j] = 1;
        int searchUp = 1 + getDistance(matrix, i - 1, j, mark);
        int searchLeft = 1 + getDistance(matrix, i, j - 1, mark);
        int searchDown = 1 + getDistance(matrix, i + 1, j, mark);
        int searchRight = 1 + getDistance(matrix, i, j + 1, mark);
        mark[i][j] = 0;
        return Math.min(Math.min(searchDown, searchLeft), Math.min(searchRight, searchUp));
    }
}
