## Arrays and Strings

### BASICS
字节 = 1 Byte
1024 Byte = 1 KB
1M = 1024KB
1. Hash Tables
A hash table is a data structure that maps keys to valus for highly efficient lookup.
We must use a linked list because of collisions!

(pic here)

2. ArrayList & Resizable Arrays

1) A typical implementation is that when the array is full,the array doubles in size.
2) When you need an array-like data structure that offers dynamic resizing, you would usually use an ArrayList.
```
 ArrayList<String> merge(String[] words,String[] more) {
        ArrayList<String> sentence = new ArrayList<String>();
        for (String w : words) sentence.add(w);
        for (String w : more) sentence.add(w);
        return sentence;
    }
```