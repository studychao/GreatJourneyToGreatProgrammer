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

## 线性表
特例：“关联数组”是一种具有特殊索引方式的数组。不仅可以通过整数来索引它，还可以使用字符串或者其他类型的值（除了NULL）来索引它。

*字符串本身也相当于字符的线性表，空字符串数组的意思就是这个线性表为空而已。*

## C Part
### 结构体大小
结构体的总大小,也就是sizeof的结果,.必须是其内部最大成员的"最宽基本类型成员"的整数倍.不足的要补齐.

### 迭代器
vector::erase()：从指定容器删除指定位置的元素或某段范围内的元素 
vector::erase()方法有两种重载形式 
如下： 
```
iterator erase(   iterator _Where); 
iterator erase(   iterator _First,   iterator _Last); 
```
如果是删除指定位置的元素时： 
返回值是一个迭代器，指向删除元素下一个元素; 
如果是删除某范围内的元素时：返回值也表示一个迭代器，指向最后一个删除元素的下一个元素;

### 算法
朴素匹配算法 时间复杂度O（(N-P+1)* P）
KMP匹配算法 时间复杂度为O（N+P）

### inline
内联函数：
Tip： 只有当函数只有 10 行甚至更少时才将其定义为内联函数.
定义: 当函数被声明为内联函数之后, 编译器会将其内联展开, 而不是按通常的函数调用机制进行调用.
优点: 当函数体比较小的时候, 内联该函数可以令目标代码更加高效. 对于存取函数以及其它函数体比较短, 性能关键的函数, 鼓励使用内联.
缺点: 滥用内联将导致程序变慢. 内联可能使目标代码量或增或减, 这取决于内联函数的大小. 内联非常短小的存取函数通常会减少代码大小, 但内联一个相当大的函数将戏剧性的增加代码大小. 现代处理器由于更好的利用了指令缓存, 小巧的代码往往执行更快。
结论: 一个较为合理的经验准则是, 不要内联超过 10 行的函数. 谨慎对待析构函数, 析构函数往往比其表面看起来要更长, 因为有隐含的成员和基类析构函数被调用!
另一个实用的经验准则: 内联那些包含循环或 switch 语句的函数常常是得不偿失 (除非在大多数情况下, 这些循环或 switch 语句从不被执行).
有些函数即使声明为内联的也不一定会被编译器内联, 这点很重要; 比如虚函数和递归函数就不会被正常内联. 通常, 递归函数不应该声明成内联函数.(递归调用堆栈的展开并不像循环那么简单, 比如递归层数在编译时可能是未知的, 大多数编译器都不支持内联递归函数). 虚函数内联的主要原因则是想把它的函数体放在类定义内, 为了图个方便, 抑或是当作文档描述其行为, 比如精短的存取函数.

-inl.h文件：


Tip： 复杂的内联函数的定义, 应放在后缀名为 -inl.h 的头文件中.


内联函数的定义必须放在头文件中, 编译器才能在调用点内联展开定义. 然而, 实现代码理论上应该放在 .cc 文件中, 我们不希望 .h 文件中有太多实现代码, 除非在可读性和性能上有明显优势.

如果内联函数的定义比较短小, 逻辑比较简单, 实现代码放在 .h 文件里没有任何问题. 比如, 存取函数的实现理所当然都应该放在类定义内. 出于编写者和调用者的方便, 较复杂的内联函数也可以放到 .h 文件中, 如果你觉得这样会使头文件显得笨重, 也可以把它萃取到单独的 -inl.h 中. 这样把实现和类定义分离开来, 当需要时包含对应的 -inl.h 即可。


A 如果只声明含有inline关键字，就没有内联的效果。 内联函数的定义必须放在头文件中, 编译器才能在调用点内联展开定义.   有些函数即使声明为内联的也不一定会被编译器内联, 这点很重要; 比如虚函数和递归函数就不会被正常内联. 通常, 递归函数不应该声明成内联函数.
B 内联函数应该在头文件中定义，这一点不同于其他函数。编译器在调用点内联展开函数的代码时，必须能够找到 inline 函数的定义才能将调用函数替换为函数代码，而对于在头文件中仅有函数声明是不够的。
C 当然内联函数定义也可以放在源文件中，但此时只有定义的那个源文件可以用它，而且必须为每个源文件拷贝一份定义(即每个源文件里的定义必须是完全相同的)，当然即使是放在头文件中，也是对每个定义做一份拷贝，只不过是编译器替你完成这种拷贝罢了。但相比于放在源文件中，放在头文件中既能够确保调用函数是定义是相同的，又能够保证在调用点能够找到函数定义从而完成内联(替换)。
对于由两个文件compute.C和draw.C构成的程序来说，程序员不能定义这样的min()函数，它在compute.C中指一件事情，而在draw.C中指另外一件事情。如果两个定义不相同，程序将会有未定义的行为：
      为保证不会发生这样的事情，建议把inline函数的定义放到头文件中。在每个调用该inline函数的文件中包含该头文件。这种方法保证对每个inline函数只有一个定义，且程序员无需复制代码，并且不可能在程序的生命期中引起无意的不匹配的事情。

D 正确。 定义在类声明之中的成员函数将自动地成为内联函数，例如：
1
class A {   public:  void Foo(int x, int y) { ... }   // 自动地成为内联函数   } 

EF 在每个调用该inline函数的文件中包含该头文件。这种方法保证对每个inline函数只有一个定义，且程序员无需复制代码，并且不可能在程序的生命期中引起无意的不匹配的事情。最好只有一个定义！
