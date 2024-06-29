public class backtracking {
    public static boolean fun(int sudoku[][], int i, int j) {   
        //base case
        if(i == 9) {
            return true;
        }
        
        //recursion
        int nextrow = i, nextcol = j+1;
        if(j+1 == 9) {
            nextrow = i+1;
            nextcol = 0;
        }

        if(sudoku[i][j] != 0) {
            return fun(sudoku, nextrow, nextcol);
        }

        for(int digit=1; digit<=9; digit++) {
            if(issafe(sudoku, i, j, digit)) {
                sudoku[i][j] = digit;
                if(fun(sudoku, nextrow, nextcol)) {
                    return true;
                }
                sudoku[i][j] = 0;
            }
        }
        return false;
    }

    public static boolean issafe(int sudoku[][], int i, int j, int digit) {
        //column
        for(int k = 0; k <= 8; k++) {
            if(sudoku[k][j] == digit) {
                return false;
            }
        }
        //row
        for(int l = 0; l <= 8; l++) {
            if(sudoku[i][l] == digit) {
                return false;
            }
        }
        //grid
        int sr = (i/3) * 3;
        int sc = (j/3) * 3;

        for(int k=sr; k<sr+3; k++) {
            for(int l=sc; l<sc+3; l++) {
                if(sudoku[k][l] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void print(int sudoku[][]) {
        for(int k=0; k<9; k++) {
            for(int l=0; l<9; l++) {
                System.out.print(sudoku[k][l]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int sudoku[][] = { {0, 0, 8, 0, 0, 0, 0, 0, 0},
        {4, 9, 0, 1, 5, 7, 0, 0, 2},
        {0, 0, 3, 0, 0, 4, 1, 9, 0},
        {1, 8, 5, 0, 6, 0, 0, 2, 0},
        {0, 0, 0, 0, 2, 0, 0, 6, 0},
        {9, 6, 0, 4, 0, 5, 3, 0, 0},
        {0, 3, 0, 0, 7, 2, 0, 0, 4},
        {0, 4, 9, 0, 3, 0, 0, 5, 7},
        {8, 2, 7, 0, 0, 9, 0, 1, 3} };

        if(fun(sudoku, 0, 0)) {
            System.out.println("Solution exists");
            print(sudoku);
        }
        else {
            System.out.println("Solution does not exists");
        }
    }
}