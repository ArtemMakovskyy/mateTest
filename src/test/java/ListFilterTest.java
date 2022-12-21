import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import main.collection.list.ListFilter;
import main.collection.list.Person;
import org.junit.Assert;
import org.junit.Test;

public class ListFilterTest {
    private final static Person JACK = new Person("Jack", 25, "male");
    private final static Person BOB = new Person("Bob", 19, "male");
    private final static Person SUSAN = new Person("Susan", 23, "female");
    private final static Person DAENERYS = new Person("Daenerys", 24, "female");
    private final static Person JOHN = new Person("John", 30, "male");
    private final static Person KATE = new Person("Kate", 19, "female");
    private final static Person CLARK = new Person("Clark", 17, "male");
    private final static Person EDVARD = new Person("Edvard", 18, "male");
    private final static Person MIKE = new Person("Mike", 45, "male");
    private final static Person TOM = new Person("Tom", 27, "male");
    private final static Person JEAN = new Person("Jean", 27, "female");
    private final static List<Person> NULL_INPUT = null;
    private final static List<Person> EMPTY_INPUT = Collections.emptyList();
    private final static List<Person> VALID_CANDIDATES
            = List.of(JACK, JOHN, BOB, SUSAN, DAENERYS, KATE, CLARK, EDVARD, MIKE, TOM, JEAN);
    private final static List<Person> VALID_CANDIDATES_ONLY = List.of(JACK, BOB, EDVARD, TOM);
    private final static List<Person> INVALID_CANDIDATES
            = List.of(SUSAN, DAENERYS, JOHN, KATE, CLARK, MIKE, JEAN);
    private final ListFilter listFilter = new ListFilter();

    @Test
    public void filter_methodName_OK() {
        Method method = null;
        try {
            method = ListFilter.class.getMethod("filter", List.class);
        } catch (NoSuchMethodException e) {
            Assert.assertEquals("You should create method called 'filter'.\n",
                    true, method != null);
        }
    }

    @Test
    public void filter_methodReturnType_OK() {
        Method method = null;
        try {
            method = ListFilter.class.getMethod("filter", List.class);
            if (method.getReturnType() != List.class) {
                Assert.assertEquals("Your method should return 'List'.\n", true, false);
            }
        } catch (NoSuchMethodException e) {
            Assert.assertEquals("You should create method called 'filter' and it should accept " +
                    "'List' as a parameter.\n", true, method != null);
        }
    }

    @Test
    public void filter_nullInput() {
        List<Person> actual = listFilter.filter(NULL_INPUT);
        Assert.assertEquals(String.format("Result should be %s for null input.\n",
                Collections.emptyList()), Collections.emptyList(), actual);
    }

    @Test
    public void filter_emptyInput() {
        List<Person> actual = listFilter.filter(EMPTY_INPUT);
        Assert.assertEquals(String.format("Result should be %s for input %s.\n",
                Collections.emptyList(), EMPTY_INPUT), Collections.emptyList(), actual);
    }

    @Test
    public void filter_suitableCandidatesPresent() {
        List<Person> actual = listFilter.filter(VALID_CANDIDATES);
        Assert.assertEquals(String.format("Result should be %s for input %s.\n",
                VALID_CANDIDATES_ONLY, VALID_CANDIDATES), VALID_CANDIDATES_ONLY, actual);
    }

    @Test
    public void filter_onlySuitableCandidatesPresent() {
        List<Person> actual = listFilter.filter(VALID_CANDIDATES_ONLY);
        Assert.assertEquals(String.format("Result should be %s for input %s.\n",
                VALID_CANDIDATES_ONLY, VALID_CANDIDATES_ONLY), VALID_CANDIDATES_ONLY, actual);
    }

    @Test
    public void filter_suitableCandidatesAbsent() {
        List<Person> actual = listFilter.filter(INVALID_CANDIDATES);
        Assert.assertEquals(String.format("Result should be %s for input %s.\n",
                Collections.emptyList(), INVALID_CANDIDATES), Collections.emptyList(), actual);
    }
}

