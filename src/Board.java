import java.util.ArrayList;
import java.util.List;

public class Board {
    int[][] fakeSudoku = new int[9][9];

    public boolean isFilled(int row, int col) {
        return fakeSudoku[row][col] != 0;
    }

    public void displayBoard() {
        int rowCount = 0;
        for (int[] rows : fakeSudoku) {
            if (rowCount == 0) System.out.printf("%s%n", "-".repeat(40));
            int colCount = 0;
            for (int cell : rows) {
                colCount++;
                if (colCount == 1) System.out.printf("%3s", "|");
                System.out.printf("%3d", cell);
                if (colCount % 3 == 0) System.out.printf("%3s", "|");
            }
            rowCount++;
            if (rowCount % 3 == 0) System.out.printf("%n%s", "-".repeat(40));
            System.out.println();
        }
    }

    public boolean fillCell(int row, int col, int number) {
        if (!isFilled(row, col)) {

            // check if any cell on the same row has the number or filled
            for (int i = 0; i < 9; i++) {
                if (col == i) continue;
                if (fakeSudoku[row][i] == number) return false;
            }

            // check if any cell on the same column has the number or filled
            for (int i = 0; i < 9; i++) {
                if (row == i) continue;
                if (fakeSudoku[i][col] == number) return false;
            }

            // check if any cell within the same block has the number
            // 0 - 2, 3 - 5, 6 - 8
            int rowStart = (row / 3) * 3;
            int colStart = (col / 3) * 3;

            for (int i = rowStart; i < rowStart + 3; i++) {
                for (int j = colStart; j < colStart + 3; j++) {
                    if (i == row && j == col) continue;
                    if (fakeSudoku[i][j] == number) return false;
                }
            }


            fakeSudoku[row][col] = number;
            return true;
        }
        return false;


    }

    public void fillBoard(){
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
        for (int i = 0; i < 81; i++) {
            if(i % 9 == 0) numbers = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
            int col = i % 9;
            int row = i / 9;
            int number = GenerateNumber.choice(numbers);
            while (!fillCell(row, col, number)){
                number = GenerateNumber.choice(numbers);
            }

            GenerateNumber.delete(number, numbers);
            displayBoard();
        }

    }

    private boolean isNotFullyFilled() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(fakeSudoku[i][j] == 0) return true;
            }
        }
        return false;
    }


}
