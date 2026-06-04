package org.funpilot.coding;

public class UniquePath {
    
    public int path(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i=0; i<m; ++i) {
            for (int j=0; j<n; ++j) {
                if (i==0 && j==0) {
                    grid[i][j] = 1;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j-1];
                } else if (j == 0) {
                    grid[i][j] = grid[i-1][j];
                } else {
                    grid[i][j] = grid[i][j-1] + grid[i-1][j];
                }
                //System.out.println(i + "," + j + ", grid:" + grid[i][j]);
            }
        }
        return grid[m-1][n-1];
    }
    public static void main(String[] args) {
        UniquePath ins = new UniquePath();
        System.out.println(ins.path(3, 7));
        System.out.println(ins.path(3, 2));
    }
}
