import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class SudokuTest {

    @Test
    void test1(){
        ArrayList<Integer> a = NineNumbers.getNumbers();
        System.out.println(a);

        Board board = new Board();
        board.displayBoard();
    }
}
