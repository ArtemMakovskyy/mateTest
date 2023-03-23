package main.dependancy_injection._practice.java.core.basesyntax.lib;



import main.dependancy_injection._practice.java.core.basesyntax.service.*;
import main.dependancy_injection._practice.java.core.basesyntax.service.impl.CalculateServiceImpl;
import main.dependancy_injection._practice.java.core.basesyntax.service.impl.ReadServiceImpl;
import main.dependancy_injection._practice.java.core.basesyntax.service.impl.TransactionParserImpl;
import main.dependancy_injection._practice.java.core.basesyntax.service.impl.WriteServiceImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Injector {
    private static final Injector injector = new Injector();
    public static Injector getInjector() {
        return injector;
    }
    private Map<Class<?>, Object> instances = new HashMap<>();

    public Object getInstance(Class<?> interfaceClazz) {
        Class<?> clazz = findImplementation(interfaceClazz);
        Object clazzImplementationInstance = null;

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(MyInject.class)) {
                //create a new object of "field type"
                Object fieldInstance = getInstance(field.getType());

                //create an "object of Class"
                clazzImplementationInstance = createNewInstance(clazz);

                //set "field type" into "object of Class"

                field.setAccessible(true);
                try {
                    field.set(clazzImplementationInstance,fieldInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Can't initialize", e);
                }
            }
        }
        if (clazzImplementationInstance == null) {
            clazzImplementationInstance = createNewInstance(clazz);
        }
        return clazzImplementationInstance;
    }

    private Object createNewInstance(Class<?> clazz) {
        // if we created an object - lets use it
        if (instances.containsKey(clazz)) return instances.get(clazz);
        // else create ne object

        Object instance = null;
        try {
            Constructor<?> constructor = clazz.getConstructor();
            instance = constructor.newInstance();
            instances.put(clazz,instance);
        } catch (InstantiationException | IllegalAccessException
                 | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("can't create instance " + clazz.getName(), e);
        }
        return instance;
    }

    private Class<?> findImplementation(Class<?> interfaceClazz) {
        Map<Class<?>, Class<?>> interfaceImplementation = new HashMap<>();
        interfaceImplementation.put(CalculateService.class, CalculateServiceImpl.class);
        interfaceImplementation.put(ReadService.class, ReadServiceImpl.class);
        interfaceImplementation.put(ReportService.class, ReadServiceImpl.class);
        interfaceImplementation.put(TransactionParser.class, TransactionParserImpl.class);
        interfaceImplementation.put(WriteService.class, WriteServiceImpl.class);
        if (interfaceClazz.isInterface()) {
            return interfaceImplementation.get(interfaceClazz);
        }
        return interfaceClazz;

    }
}
