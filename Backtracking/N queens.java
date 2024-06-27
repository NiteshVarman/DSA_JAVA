public class backtracking {
    public static void queens(char board[], int row) {   
       
    }

    public static void main(String args[]) {
        int n = 2;
        char board[][] = new char[n][n];
        //initialize
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        queens(board, 0);
    }
}