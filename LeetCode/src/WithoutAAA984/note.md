## 思路

我的方法：
先判断最大的那个数是A还是B，
大的默认每次都-2，小的那个超过剩余pairs数就-2，否则就-1

别人的方法：
1）如果A的数字比B小，swapA和B的所有
2）每一轮，我们都加1个a
3）然后如果剩余的a大于等于b，就再来一个a
4）否则加b

```
public String strWithout3a3b(int A, int B) {
  StringBuilder res = new StringBuilder(A + B);
  char a = 'a', b = 'b';
  int i = A, j = B;
  if (B > A) { a = 'b'; b = 'a'; i = B; j = A; }
  while (i-- > 0) {
    res.append(a);
    if (i > j) { res.append(a); --i; }
    if (j-- > 0) res.append(b);
  }
```