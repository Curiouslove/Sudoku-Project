public class Board {
    int[][] fakeSudoku = new int[9][9];

    public boolean isFilled(int row, int col){
        return fakeSudoku[row][col] != 0;
    }

    public void displayBoard(){
        int rowCount = 0;
        for (int[] rows: fakeSudoku) {
            if(rowCount==0) System.out.printf("%s%n", "-".repeat(40));
            int colCount = 0;
            for (int cell: rows) {
                colCount++;
                if(colCount==1) System.out.printf("%3s", "|");
                System.out.printf("%3d", cell);
                if(colCount % 3 == 0) System.out.printf("%3s", "|");
            }
            rowCount++;
            if(rowCount % 3 == 0) System.out.printf("%n%s", "-".repeat(40));
            System.out.println();
        }
    }

    public boolean fillCell(int row, int col, int number){
        // check if any cell on the same row has the number or filled
        for (int i = 0; i < row; i++) {
            if(!(isFilled(i, col) || fakeSudoku[i][col] == number)) {
                fakeSudoku[row][col] = number;
                return true;
            }

        }

        // check if any cell on the same column has the number or filled
        for (int i = 0; i < col; i++) {
            if(!(isFilled(row, i) || fakeSudoku[row][i] == number)) {
                fakeSudoku[row][col] = number;
                return true;
            }
        }

        return false;
    }
}
