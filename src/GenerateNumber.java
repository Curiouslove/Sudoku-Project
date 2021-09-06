import java.security.SecureRandom;
import java.util.ArrayList;

public class GenerateNumber {

    public static int choice(ArrayList<Integer>  numbers){
        SecureRandom random = new SecureRandom();

        int number = random.nextInt(numbers.size() - 1);

        return number;
    }

    public static ArrayList<Integer> delete(int existingNumber, ArrayList<Integer> numbers){
        numbers.remove(existingNumber);
        return numbers;
    }

}
