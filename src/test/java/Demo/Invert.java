package Demo;

public class Invert {

    public static String invert(String input) {
        if (input == null) {
            return null;
        }

        // Reverse the characters in the input string
        StringBuilder result = new StringBuilder(input).reverse();
        return result.toString();
    }
}
