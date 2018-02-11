import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("Write digitA + digitB or digitA - digitB to calculate:");

        String line = sc.next();
        Integer result = calc.addSubtract(line);

        System.out.println("Result: " + result);
        sc.close();
    }
}