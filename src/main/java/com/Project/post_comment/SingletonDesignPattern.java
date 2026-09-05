package com.Project.post_comment;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonDesignPattern implements Cloneable {

  //TODO: object is created immediately as soon as the class loads(Eager initialization)
  // Disadvantage is Object is created that never used, memory wasted
  private static final SingletonDesignPattern instance = new SingletonDesignPattern();

  private static SingletonDesignPattern object;

//  private static final Object lock = new Object();

  private SingletonDesignPattern() {
//    if (object != null) {    // use to break reflection
//      throw new RuntimeException("Object is already created");
//    }
  }

  ; //constructor is private

  public static void main(String[] args)
    throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException,
    CloneNotSupportedException {

//TODO: Eager loading singleton
    SingletonDesignPattern s1 = getSingletonInstance();
    SingletonDesignPattern s2 = getSingletonInstance();

    System.out.println(s1 == s2);
//TODO: Lazy Initialization
    SingletonDesignPattern s3 = implementDoubleCheckLocking();
    SingletonDesignPattern s4 = implementDoubleCheckLocking();

    System.out.println(s3 == s4);
    System.out.println(s3.hashCode());
    System.out.println(s4.hashCode());

    //TODO: Break singleton (using reflection), reflection can access private constructor

    SingletonDesignPattern instance1 = SingletonDesignPattern.implementDoubleCheckLocking();

    Constructor<SingletonDesignPattern> constructor = SingletonDesignPattern.class.getDeclaredConstructor();

    constructor.setAccessible(true);

    SingletonDesignPattern instance2 =
      constructor.newInstance(); //object created this calls constructor and throws exception

    System.out.println(instance1 == instance2);

// TODO: Break the singleton using cloning(it crates a copy of singleton object)
    SingletonDesignPattern object1 = getSingletonInstance();

    SingletonDesignPattern object2 = (SingletonDesignPattern) object1.clone();
    System.out.println("testing the breaking singleton with cloning.....");
    System.out.println(object1 == object2);


  }

  public static SingletonDesignPattern getSingletonInstance() {
    return instance;
  }

  public static synchronized SingletonDesignPattern getObject() {
//TODO: Problem suppose T1 enters the method create singleton object but when t2 tries to enter
// getObject() method it waits for the lock and after all it should return existing object but t2 still wait for
// a lock even though object already exists T2 still needs a lock i.e performance reduced

    if (object == null) {
      object = new SingletonDesignPattern();

    }
    return object;
  }

  //TODO: Double check lock
  public static SingletonDesignPattern implementDoubleCheckLocking() {

    if (object == null) {

      synchronized (SingletonDesignPattern.class) {
        if (object == null) {
          object = new SingletonDesignPattern();
        }
      }
    }
    return object;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
