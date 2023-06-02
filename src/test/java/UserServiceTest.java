import main.exception.UserService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UserServiceTest {
    private static final String[] basicRecords = {"john@gmail.com:78", "rick@yahoo.com:99",
            "greg@gmail.com:20", "russell@mail.us:141", "jerry@mail.us:0", "mortimer@mail.us:53",
            "test@gmail.com:2", "bob@mail.com:141986"};
    private static final String[] EMPTY_ARRAY = {};
    private static final String[] singleElementArray = {"carl@mail.com:30"};
    private static final String EXCEPTION_CLASS = "UserNotFoundException";
    private static UserService userService;

    @BeforeClass
    public static void init() {
        userService = new UserService();
    }

    @Test
    public void getUserScore_validCase() {
        Assert.assertEquals("Wrong score for user with email mortimer@mail.us.\n",
                53, userService.getUserScore(basicRecords, "mortimer@mail.us"));
        Assert.assertEquals("Wrong score for user with email rick@yahoo.com\n",
                99, userService.getUserScore(basicRecords, "rick@yahoo.com"));
        Assert.assertEquals("Wrong score for user with email greg@gmail.com\n",
                20, userService.getUserScore(basicRecords, "greg@gmail.com"));
        Assert.assertEquals("Wrong score for user with email jerry@mail.us\n",
                0, userService.getUserScore(basicRecords, "jerry@mail.us"));
        Assert.assertEquals("Wrong score for user with email bob@mail.com\n",
                141986, userService.getUserScore(basicRecords, "bob@mail.com"));
        Assert.assertEquals("Wrong score for user with email test@gmail.com\n",
                2, userService.getUserScore(basicRecords, "test@gmail.com"));
    }

    @Test
    public void exceptionClass_exceptionClassExists() {
        Class<?> exceptionClass = null;
        try {
            exceptionClass = Class.forName(EXCEPTION_CLASS);
        } catch (ClassNotFoundException e) {
            Assert.assertEquals("You should create class called 'UserNotFoundException'\n",
                    true, exceptionClass != null);
        }
    }

    @Test
    public void exceptionClass_exceptionClassExtendsFromRuntime() {
        Class<?> runtimeClass = null;
        try {
            runtimeClass = Class.forName(EXCEPTION_CLASS).getSuperclass();
            Assert.assertEquals("Your own exception should be unchecked\n",
                    runtimeClass, RuntimeException.class);
        } catch (ClassNotFoundException e) {
            Assert.assertEquals("You should create class called 'UserNotFoundException'\n",
                    true, runtimeClass != null);
        }
    }

    @Test
    public void exceptionClass_exceptionClassHasConstructorWithString() {
        Class<?> customExceptionClass = null;
        try {
            boolean containsConstructorWithParameter = false;
            customExceptionClass = Class.forName(EXCEPTION_CLASS);
            Constructor<?>[] constructors = customExceptionClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if(containsConstructorWithParameter
                        = Arrays.asList(parameterTypes).contains(String.class)){
                    break;
                }
            }
            Assert.assertEquals("Don't hardcode the message in the exception class, " +
                    "let's pass it to constructor\n", true, containsConstructorWithParameter);
        } catch (ClassNotFoundException e) {
            Assert.assertEquals("You should create class called 'UserNotFoundException'\n",
                    true, customExceptionClass != null);
        }
    }

    @Test
    public void getUserScore_withoutThrowsException() {
        Class<? extends UserService> userServiceClass = userService.getClass();
        Method getUserScoreMethod = null;
        try {
            getUserScoreMethod = userServiceClass
                    .getDeclaredMethod("getUserScore", String[].class, String.class);
            Class<?>[] throwsExceptions = getUserScoreMethod.getExceptionTypes();
            Assert.assertEquals("Should method getUserScore() throw an exception in " +
                    "the method signature?\n", 0, throwsExceptions.length);
        } catch (NoSuchMethodException e) {
            Assert.assertEquals("You should not change method signature getUserScore()\n",
                    true, getUserScoreMethod != null);
        }
    }

    @Test
    public void getUserScore_exceptionExpected() {
        String email = "vincent@mail.us";
        Class<?> exceptionClass = null;
        try {
            exceptionClass = Class
                    .forName(EXCEPTION_CLASS);
            userService.getUserScore(EMPTY_ARRAY, email);
        } catch (ClassNotFoundException e) {
            Assert.assertEquals("Should create a class called 'UserNotFoundException'.\n",
                    true, exceptionClass != null);
        } catch (UserNotFoundException e) {
            Assert.assertEquals("Your exception should have a description message\n",
                    true, e.getMessage() != null);
            return;
        }
        Assert.assertEquals(String.format("You should throw an " +
                "exception 'UserNotFoundException' with message " +
                "'User with given email doesn't exist' for input email " +
                "%s in the records: %s\n", email, Arrays.toString(EMPTY_ARRAY)), true, false);
    }

    @Test
    public void getUserScore_wrongEmailFormatInputFirstCase() {
        String email = "carl@mail.com:30";
        Class<?> exceptionClass = null;
        try {
            exceptionClass = Class
                    .forName(EXCEPTION_CLASS);
            userService.getUserScore(EMPTY_ARRAY, email);
        } catch (ClassNotFoundException e) {
            Assert.assertEquals("Should throw exception whenever user with given email doesn't exist\n",
                    true, exceptionClass != null);
        } catch (UserNotFoundException e) {
            Assert.assertEquals("Your exception should have a description message\n",
                    true, e.getMessage() != null);
            return;
        }
        Assert.assertEquals(String.format("You should throw an " +
                "exception 'UserNotFoundException' with message " +
                "'User with given email doesn't exist' for input email " +
                "%s in the records: %s\n", email, Arrays.toString(EMPTY_ARRAY)), true, false);
    }

    @Test
    public void getUserScore_wrongEmailFormatInputSecondCase() {
        String email = "jerry@mail.us:0$@";
        Class<?> exceptionClass = null;
        try {
            exceptionClass = Class
                    .forName(EXCEPTION_CLASS);
            userService.getUserScore(EMPTY_ARRAY, email);
        } catch (ClassNotFoundException e) {
            Assert.assertEquals("Should throw exception whenever user with given email doesn't exist\n",
                    true, exceptionClass != null);
        } catch (UserNotFoundException e) {
            Assert.assertEquals("Your exception should have a description message\n",
                    true, e.getMessage() != null);
            return;
        }
        Assert.assertEquals(String.format("You should throw an " +
                "exception 'UserNotFoundException' with message " +
                "'User with given email doesn't exist' for input email " +
                "%s in the records: %s\n", email, Arrays.toString(EMPTY_ARRAY)), true, false);
    }

    @Test
    public void getUserScore_wrongEmailFormatInputThirdCase() {
        String email = "bob@mail.com:1419";
        Class<?> exceptionClass = null;
        try {
            exceptionClass = Class
                    .forName(EXCEPTION_CLASS);
            userService.getUserScore(EMPTY_ARRAY, email);
        } catch (ClassNotFoundException e) {
            Assert.assertEquals("Should throw exception whenever user with given email doesn't exist\n",
                    true, exceptionClass != null);
        } catch (UserNotFoundException e) {
            Assert.assertEquals("Your exception should have a description message\n",
                    true, e.getMessage() != null);
            return;
        }
        Assert.assertEquals(String.format("You should throw an " +
                "exception 'UserNotFoundException' with message " +
                "'User with given email doesn't exist' for input email " +
                "%s in the records: %s\n", email, Arrays.toString(EMPTY_ARRAY)), true, false);
    }
}
