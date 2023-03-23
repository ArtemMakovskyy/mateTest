package main.dependancy_injection.lib;

import main.dependancy_injection.service.AccountService;
import main.dependancy_injection.service.AuthenticationManager;
import main.dependancy_injection.service.BankService;
import main.dependancy_injection.service.impl.AccountServiceImpl;
import main.dependancy_injection.service.impl.AuthenticationManagerImpl;
import main.dependancy_injection.service.impl.BankServiceImpl;

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
        //пример класса реализации
        Object clazzImplementationInstance = null;

        //класс реализации
        Class<?> clazz = findImplementation(interfaceClazz);

        //все поля класса
        Field[] declaredFields = interfaceClazz.getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Inject.class)) {
//                create new object of field type
                Object fieldInstance = getInstance(field.getType());
                System.out.println("fieldInstance " + fieldInstance);

//                create an object of interfaceClazz
                clazzImplementationInstance = createNewInstance(clazz);
                System.out.println("clazzImplementationInstance " + clazzImplementationInstance);

//                set field type object
                field.setAccessible(true);
                try {
                    field.set(clazz, fieldInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Can't initialize field value. Claaa "
                            + clazz.getName() + field.getName(), e);
                }
            }
        }
        if (clazzImplementationInstance == null) {
            clazzImplementationInstance = createNewInstance(clazz);
        }
        return clazzImplementationInstance;
    }

    private Object createNewInstance(Class<?> clazz) {
        if (instances.containsKey(clazz)) {
            return instances.get(clazz);
        }
        try {
            Constructor<?> constructor = clazz.getConstructor();
            Object instance = constructor.newInstance();
            instances.put(clazz, instance);
            return instance;
        } catch (NoSuchMethodException | InvocationTargetException
                 | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Can't create new Instance of " + clazz.getName(), e);
        }
    }

    private Class<?> findImplementation(Class<?> interfaceClazz) {
        Map<Class<?>, Class<?>> interfaceImplementation = new HashMap<>();
        interfaceImplementation.put(BankService.class, BankServiceImpl.class);
        interfaceImplementation.put(AccountService.class, AccountServiceImpl.class);
        interfaceImplementation.put(AuthenticationManager.class, AuthenticationManagerImpl.class);
        if (interfaceClazz.isInterface()) {
            return interfaceImplementation.get(interfaceClazz);
        }
        return interfaceClazz;

    }
}
