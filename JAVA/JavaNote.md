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