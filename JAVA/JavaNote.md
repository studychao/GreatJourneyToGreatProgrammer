# Java

## Double Brace Initialisation
```
@Test
public void givenAnonymousInnerClass_thenInitialiseList() {
    List<String> cities = new ArrayList() {{
        add("New York");
        add("Rio");
        add("Tokyo");
    }};
 
    assertTrue(cities.contains("New York"));
}
```
There *isn’t* actually a ‘double brace’ syntax element in Java, those are two blocks formatted intentionally this way.

With the outer braces, we declare an anonymous inner class which will be a subclass of the ArrayList. Inside these braces, we can declare the details of our subclass.

As usual, we can use instance initializer blocks and that is where the inner pair of braces come from.

The brevity of this syntax is tempting however it’s considered an anti-pattern.

## HashSet
A Hashset holds a set of objects, but in a way that it allows you to easily and quickly determine whether an obe=ject is already in the set or not.It does so by internally managing an array and storing the object using an index which is calculated from the hashcode of the object.

Add, Remove, Contains functions take O(1)

什么是HashSet
HashSet实现了Set接口，它不允许集合中有重复的值，当我们提到HashSet时，第一件事情就是在将对象存储在HashSet之前，要先确保对象重写equals()和hashCode()方法，这样才能比较对象的值是否相等，以确保set中没有储存相等的对象。如果我们没有重写这两个方法，将会使用这个方法的默认实现。

public boolean add(Object o)方法用来在Set中添加元素，当元素值重复时则会立即返回false，如果成功添加的话会返回true。

什么是HashMap
HashMap实现了Map接口，Map接口对键值对进行映射。Map中不允许重复的键。Map接口有两个基本的实现，HashMap和TreeMap。TreeMap保存了对象的排列次序，而HashMap则不能。HashMap允许键和值为null。HashMap是非synchronized的，但collection框架提供方法能保证HashMap synchronized，这样多个线程同时访问HashMap时，能保证只有一个线程更改Map。

public Object put(Object Key,Object value)方法用来将元素添加到map中。

## Autoboxing
自动装箱(autoboxing)是指 Java 编译器自动将基本数据类型值转换成对应的包装类的对象，例如将 int 转换为 Integer 对象，将 boolean 转换问 Boolean 对象。而拆箱(unboxing)则是反过来转换。

