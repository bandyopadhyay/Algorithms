import java.util.*;

public class MinDist {


    public static void main(String[] args) {
        char[][] matrix = { { '1', '1', '1' }, { '1', 'S', '1' }, { '1', '1', 'X', '1' },
                { '1', '1', '1', 'E' } };

        //System.out.println(shortestPath(matrix));



    }

    public static int minimunDistance(int numRows, int numColumns, List<List<Integer>> area) {
        int s_row = 0, s_col = 0;
        int[][] matrix = new int[numRows][numColumns];
        int i = 0;
        for (List<Integer> outerList : area) {
            int j = 0;
            for (Integer point : outerList) {
                matrix[i][j] = point;
                j++;
            }
            i++;
        }
        matrix[0][0] = -1;
        return shortestPath(matrix, s_row, s_col);
    }

    public static int shortestPath(int[][] matrix, int s_row, int s_col) {
        int count = 0;
        Queue<int[]> nextToVisit = new LinkedList<>();
        nextToVisit.offer(new int[] { s_row, s_col });
        Set<int[]> visited = new HashSet<int[]>();
        Queue<int[]> temp = new LinkedList<>();

        while (!nextToVisit.isEmpty()) {
            int[] position = nextToVisit.poll();
            int row = position[0];
            int col = position[1];

            if (matrix[row][col] == 9)
                return count;
            if (row > 0 && !visited.contains(new int[] { row - 1, col }) && matrix[row - 1][col] != 0)
                temp.offer(new int[] { row - 1, col });
            if (row < matrix.length - 1 && !visited.contains(new int[] { row + 1, col }) && matrix[row + 1][col] != 0)
                temp.offer(new int[] { row + 1, col });
            if (col > 0 && !visited.contains(new int[] { row, col - 1 }) && matrix[row][col - 1] != 0)
                temp.offer(new int[] { row, col - 1 });
            if (col < matrix[0].length - 1 && !visited.contains(new int[] { row, col + 1 })
                    && matrix[row][col + 1] != 0)
                temp.offer(new int[] { row, col + 1 });

            if (nextToVisit.isEmpty() && !temp.isEmpty()) {
                nextToVisit = temp;
                temp = new LinkedList<>();
                count++;
            }

        }

        return count;
    }
}
