# Stacks 
- - - -
## Fundamental data types
* Operations: insert, remove, iterate, test if empty.
* LIFO = “last in first out”

![alt text](https://github.com/studychao/GreatJourneyToGreatProgrammer/blob/master/Algorithms/Screen%20Shot%202018-12-14%20at%2000.39.18.png)

```
//First way of implementing stacks through inner class
public class StackOfStrings
			    StackOfStrings() //create an empty stack
		 void push(String item) //insert a new string onto stack
       String pop() //remove and return the string most recently added
       boolean isEmpty() // is the stack empty?
       int size() //number of strings on the stack
```

* Performance Proposition: Every operation takes constant time in the worst case.

* Time Proposition: 16bytes (object overhead)+ 8 bytes (inner class extra overhead)+ 8bytes(reference to String) + 8 bytes (reference to Node) = 40 bytes
[1. in Java 2. Stack of stings]

* Using Array **Defect : Stack overflows when N exceeds capacity**
```
//Second way of implementing stacks through array
public class FixedCapacityStackOfStrings
{
	private String[] s;
	private int N = 0;
  public FixedCapacityStackOfStrings(int capacity)
	public boolean isEmpty()
	public void push (String item)
  public String pop()
 
}
```

**Overflow and underflow**
Underflow: throw exception if pop from an empty stack
Overflow: use resizing array for array implementation

**Loitering**
Holding a reference to an object when it’s no longer needed
[in the example above, change the function pop()]