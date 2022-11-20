import main.pattern.builder.Plane;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PlaneTest {
    @Test
    public void planeClass_checkCountOfPrivateFields() {
        List<Field> privateFields = new ArrayList<>();
        List<Field> allFields = Arrays.asList(Plane.class.getDeclaredFields());
        for (Field field : allFields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                privateFields.add(field);
            }
        }
        Assert.assertEquals("You should have private fields only!\n", allFields.size(), privateFields.size());
        Assert.assertEquals("You should have at least 5 fields\n", true, privateFields.size() >= 5);
    }

    @Test
    public void planeClass_checkThatBuilderClassIsPresent() {
        List<Class<?>> planeInnerClasses = Arrays.asList(Plane.class.getClasses());
        Assert.assertEquals("PlaneBuilder class should be present as inner class\n",
                true, !planeInnerClasses.isEmpty());
        Optional<Class<?>> planeBuilderClass = planeInnerClasses.stream()
                .filter(Objects::nonNull)
                .filter(c -> c.getSimpleName().equals("PlaneBuilder"))
                .findFirst();
        Assert.assertEquals("PlaneBuilder class should be present\n",
                true, planeBuilderClass.isPresent());

        Method method = null;
        try {
            method = planeBuilderClass.get().getMethod("build");
        } catch (NoSuchMethodException e) {
        }
        Assert.assertEquals("Builder class should contain method 'build'\n",
                true,  method != null);
    }

    @Test
    public void solution_checkThatBuildMethodIsNotPresentInMainClass() {
        Method method = null;
        try {
            method = Plane.class.getMethod("build");
        } catch (NoSuchMethodException e) {
            return;
        }
        Assert.assertEquals("Method 'build' should not be present in the Plane.class\n",
                true, method == null);
    }

    @Test
    public void builderClass_checkThatAllFieldsFromPlaneExistsInBuilderAsSetters() {
        List<Field> planeFields = Arrays.asList(Plane.class.getDeclaredFields());

        List<Class<?>> planeInnerClasses = Arrays.asList(Plane.class.getClasses());
        Optional<Class<?>> planeBuilderClass = planeInnerClasses.stream()
                .filter(Objects::nonNull)
                .filter(c -> c.getSimpleName().equals("PlaneBuilder"))
                .findFirst();
        Assert.assertEquals("PlaneBuilder class should be present\n", true,
                planeBuilderClass.isPresent());


        List<Method> builderMethods = Arrays.asList(planeBuilderClass.get().getMethods());
        for (Field f : planeFields) {
            String fieldName = f.getName();
            Optional<Method> methodOptional = builderMethods.stream()
                    .filter(m -> m.getName().equalsIgnoreCase("set" + fieldName))
                    .findFirst();
            Assert.assertEquals("Setter for " + fieldName + " field should be present in builder\n",
                    true, methodOptional.isPresent());
        }
    }

    @Test
    public void planeClass_checkNoSettersArePresentInPlaneClass() {
        List<Field> planeFields = Arrays.asList(Plane.class.getDeclaredFields());
        Assert.assertEquals(false, planeFields.isEmpty());

        List<Method> planerMethods = Arrays.asList(Plane.class.getMethods());
        for (Field f : planeFields) {
            String fieldName = f.getName();
            Optional<Method> method = planerMethods.stream()
                    .filter(m -> m.getName().equalsIgnoreCase("set" + fieldName))
                    .findFirst();
            Assert.assertEquals(String.format("Setter for %s field should NOT be present in Plane class\n", fieldName),
                    false, method.isPresent());
        }
    }

    @Test
    public void planeClass_checkTheOnlyOnePlaneConstructorIsPresent() {
        List<Field> planeFields = Arrays.asList(Plane.class.getDeclaredFields());
        Assert.assertEquals(false, planeFields.isEmpty());

        List<Constructor<?>> constructors = Arrays.asList(Plane.class.getDeclaredConstructors());
        Assert.assertEquals("You should have only one constructor in the Plane.class\n",
                1, constructors.size());

        int actualParameterCount = constructors.get(0).getParameterCount();

        Assert.assertEquals("Your constructor should have one parameter\n",
                1, actualParameterCount);

        Class<?> actualConstructorParameterType = constructors.get(0).getParameterTypes()[0];
        Class<?> expectedPlaneBuilderClass = Plane.class.getClasses()[0];
        Assert.assertEquals("Your constructor should have one parameter of PlaneBuilder class\n",
                expectedPlaneBuilderClass, actualConstructorParameterType);
    }
}
