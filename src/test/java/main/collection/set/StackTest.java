package main.collection.set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.EmptyStackException;

public class StackTest {
    private static final String NEW_LIST_REGEX = ".*newArrayList.*|.*newLinkedList.*";
    private StackWithArray<String> stack;
    private String resultCode;

    @Before
    public void setUp() {
        stack = new StackWithArray<>();
//        resultCode = Solution.getSolution().replaceAll("\\s", "");
    }

    @Test
    public void size_emptyStack_ok() {
        Assert.assertEquals(0, stack.size());
    }

    @Test
    public void size_oneElement_ok() {
        stack.push("Hello");
        Assert.assertEquals(1, stack.size());
    }

    @Test
    public void size_threeElements_ok() {
        stack.push("Hello");
        stack.push("World");
        stack.push("Mate");
        Assert.assertEquals(3, stack.size());
    }

    @Test
    public void peek_oneElement_ok() {
        stack.push("Hello");
        Assert.assertEquals(1, stack.size());
        String actual = stack.peek();
        String expected = "Hello";
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(1, stack.size());
    }

    @Test
    public void peek_severalTimes_ok() {
        stack.push("Hello");
        stack.push("World");
        Assert.assertEquals(2, stack.size());
        String actual = stack.peek();
        String expected = "World";
        Assert.assertEquals(expected, actual);

        String actualSecondTry = stack.peek();
        String expectedSecondTry = "World";
        Assert.assertEquals(expectedSecondTry, actualSecondTry);

        String actualThirdTry = stack.peek();
        String expectedThirdTry = "World";
        Assert.assertEquals(expectedThirdTry, actualThirdTry);

        Assert.assertEquals(2, stack.size());
    }

    @Test(expected = EmptyStackException.class)
    public void peek_emptyStack() {
        Assert.assertEquals(0, stack.size());
        stack.peek();
    }

    @Test
    public void pop_ok() {
        stack.push("Hello");
        Assert.assertEquals(1, stack.size());
        String actual = stack.pop();
        String expected = "Hello";
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(0, stack.size());
    }

    @Test
    public void pop_threeElements_ok() {
        stack.push("Hello");
        stack.push("World");
        stack.push("Mate");
        Assert.assertEquals(3, stack.size());

        String actual = stack.pop();
        String expected = "Mate";
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(2, stack.size());

        String actualSecond = stack.pop();
        String expectedSecond = "World";
        Assert.assertEquals(expectedSecond, actualSecond);
        Assert.assertEquals(1, stack.size());

        String actualThird = stack.pop();
        String expectedThird = "Hello";
        Assert.assertEquals(expectedThird, actualThird);
        Assert.assertEquals(0, stack.size());
    }

    @Test(expected = EmptyStackException.class)
    public void pop_emptyStack() {
        Assert.assertEquals(0, stack.size());
        stack.pop();
    }


}
