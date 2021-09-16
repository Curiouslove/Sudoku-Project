import java.security.SecureRandom;
import java.util.ArrayList;

public class GenerateNumber {

    public static int choice(ArrayList<Integer>  numbers){
        SecureRandom random = new SecureRandom();
        if(numbers.size() == 1) return numbers.get(0);
        int number = random.nextInt(numbers.size());

        return numbers.get(number);
    }

    public static ArrayList<Integer> delete(int existingNumber, ArrayList<Integer> numbers){
        numbers.remove(Integer.valueOf(existingNumber));
        return numbers;
    }

}
