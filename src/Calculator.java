import java.util.Arrays;
import java.util.List;

class Calculator {
    private final String a;
    private final String b;
    private final String operation;


    public Calculator(String[] args) {
        this.operation = args[1];
        this.a = args[0];
        this.b = args[2];
    }


    public String calc(int a, int b, boolean isRoman) {
        if (isRoman && (a <= b) && operation.equals("-")) throw new CalculateException("Incorrect input, a <= b");

        return switch (this.operation) {
            case ("+") -> (a + b) + "";
            case ("-") -> (a - b) + "";
            case ("*") -> (a * b) + "";
            case ("/") -> (a / b) + "";
            default -> throw new CalculateException("Incorrect input, unknown operation: " + operation);
        };
    }


    public String execute() {
        List<String> romanLiterals = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
        List<String> arabicLiterals = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        String result;


        if (romanLiterals.contains(a) && romanLiterals.contains(b)) {
            result = calc(Integer.parseInt(arabicLiterals.get(romanLiterals.indexOf(a)))
                    , Integer.parseInt(arabicLiterals.get(romanLiterals.indexOf(b)))
                    , true);
            return convertToRoman(Integer.parseInt(result));
        } else
        if (arabicLiterals.contains(a) && arabicLiterals.contains(b)) {
            result = calc(Integer.parseInt(a)
                    , Integer.parseInt(b)
                    , false);
            return result;
        }
        throw new CalculateException("Incorrect input");
    }


    public String convertToRoman(int number) {
        int[] arabicLiterals = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arabicLiterals.length; i++) {
            while (number >= arabicLiterals[i]) {
                number -= arabicLiterals[i];
                result.append(romanLiterals[i]);
            }
        }
        return result.toString();
    }
}
