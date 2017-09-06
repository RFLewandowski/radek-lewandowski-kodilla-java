import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.user.calculator.Calculator;

public class TestingMain {

    public static void main(String[] args) {

        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Errored user!");
        }

        Calculator calc = new Calculator();

        int sumResult = calc.add(2, 2);

        if (sumResult == 4) {
            System.out.println("test OK");
        } else {
            System.out.println("Errored addition!");
        }

        int subtrResult = calc.subtract(2, 2);

        if (subtrResult == 0) {
            System.out.println("test OK");
        } else {
            System.out.println("Errored subtraction!");
        }
    }
}