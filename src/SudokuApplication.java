import java.util.ArrayList;

public class SudokuApplication {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = NineNumbers.getNumbers();
        System.out.print("Our numbers are : ");
        System.out.println(numbers);

        System.out.println();

        int number = GenerateNumber.choice(numbers);
        System.out.print("Our random number is: ");
        System.out.println(number);

        System.out.println();

        ArrayList<Integer> newList = GenerateNumber.delete(number, numbers);
        System.out.print("Our new numbers are : ");
        System.out.println(numbers);

    }
}
