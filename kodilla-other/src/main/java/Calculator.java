import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {

    public Integer addSubtract(String operation) {

        Object[] components = decodeOperation(operation);
        Integer a = (Integer) components[0];
        String sign = (String) components[1];
        Integer b = (Integer) components[2];

        switch (sign) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            default:
                System.out.println("Please buy full version for other operations;)");
                return null;
        }
    }

    private Object[] decodeOperation(String line) {
        Object[] result = {null, null, null};
        String pattern = "(\\d+)([+-])(\\d+)";
        Pattern pattInst = Pattern.compile(pattern);
        Matcher matcher = pattInst.matcher(line);

        if (matcher.find()) {
            result[0] = Integer.valueOf(matcher.group(1));
            result[1] = matcher.group(2);
            result[2] = Integer.valueOf(matcher.group(3));
        } else
            System.out.println("Seems there is nothing to calculate...");

        return result;
    }
}
