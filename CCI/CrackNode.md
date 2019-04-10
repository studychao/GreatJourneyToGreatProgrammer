# BASICS
字节 = 1 Byte
1024 Byte = 1 KB
1M = 1024KB

2^10 = 1024

# Arrays and Strings

## Hash Tables
A hash table is a data structure that maps keys to valus for highly efficient lookup.
We must use a linked list because of collisions!

(pic here)

## ArrayList & Resizable Arrays

1. A typical implementation is that when the array is full,the array doubles in size.
2. When you need an array-like data structure that offers dynamic resizing, you would usually use an ArrayList.
3. Each doubling takes O(n) time, The amortized insertion time is O(1);
```
 ArrayList<String> merge(String[] words,String[] more) {
        ArrayList<String> sentence = new ArrayList<String>();
        for (String w : words) sentence.add(w);
        for (String w : more) sentence.add(w);
        return sentence;
    }
```

4. Reason for the amortized insertion runtime O(1)?
The total number of copies to insert N elements is roughly N/2 + N/4 + N/8 + ... + 2 + 1 which is just less than N/
Therefore, inserting N elements takes O(N) work total. Each insertion is O(1) on average, even though some insertions take O(N) time in the worst case

## StringBuilder

```
String joinwords(String[] words){
	String sentence = "";
	for (String w : words){
		sentence = sentence + w;
	}
	return sentence;
}
```
```
The total time : O(x + 2x + 3x + ... + nx) -> O(xn^2)

use StringBuilder to solve this problem !(`sentence.append`)

[Build ur own stringbuilder, ArrayList, HashTable~]
```

## Tree
度数(边数) = 所有节点数-1：
这里度数=2 * 100+100=300，节点数：100+100+叶子节点数

## Sorting & Searching 

1. Bubble Sort | Runtime O(n^2), Memory O(1)
2. Selection Sort | Runtime O(n^2) Memory O(1)
3. Merge Sort | Runtime O(nlogn) Memory:depends
- Merge sort divides the array in half, sorts each of those halves, and then merges them back together. Each of those halves has the same sorting algorithm applied to it. Eventually, you are merging just two single-element arrays.It's the merge part that does all the heavy lifting.
4. Quick Sort | Runtime O(nlogn) O(n^2). Memory:O(logn)
5. Radix Sort | Runtime O(kn) 