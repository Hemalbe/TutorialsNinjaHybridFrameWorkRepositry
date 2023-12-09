package Demo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class InvertDemo {

    private final String input;
    private final String expectedOutput;

    public InvertDemo(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {null, null},
                {"", ""},
                {"abcd", "dcba"},
                {"1234", "4321"},
                {"{([", "[({"},
                {"Hema", "ameH"},
                // Add more test cases as needed
        });
    }

    @Test
    public void testInvert() {
        String actualOutput = Invert.invert(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
    
    
    
    
}