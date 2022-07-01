
import java.util.Scanner;

public class TestTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));

    }
    public static String calc(String input) {
        String[] inputs = input.split(" ");
        if (inputs.length != 3) throw new CalculateException("Incorrect input");


        Calculator calculator = new Calculator(inputs);
        return calculator.execute();
    }


}
