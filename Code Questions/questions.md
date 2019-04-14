## C Language

1. 
```
int* pint = 0; 
pint += 6; 
cout << pint << endl;
```
1.在初始化中只有地址才能赋值给指针，因此 `*int p=0`是指p指向地址0x00。
2.int型数占4个字节，因此加6表示偏移了24个字节，结果的地址应为0x18，即是24.

2.
```
#pragma pack(2)
class BU
{
    int number;
    union UBffer
    {
        char buffer[13];
        int number;
    }ubuf;
    void foo(){}
    typedef char*(*f)(void*);
    enum{hdd,ssd,blueray}disk;
}bu;
```
 注意第一行，#pragma pack(2)
 首先考虑没有这句话时，我们在类、结构或者union补齐字节的时候，找它们的成员数据中找字节最大的那个数去衡量如何对齐，假设为z；
 但是有了这句话以后，对齐方式是取 pack(n)中n和z的最小值去对齐；
 可见本题中对齐字节数为2；
 之后往下看 int number; 占4个字节
 接下来考虑union大小
 ```
 union UBffer
 {
     char buffer[13]; // 13
    int number; // 4
}ubuf; buffer 是13个字节，number 是4个字节，取最大的 为13，注意还要字节对齐，对齐字节数为2，所以Union大小为14，既满足buffer的对齐 也满足number的对齐。
void foo(){} 不占
typedef char*(*f)(void*); 不占
enum{hdd,ssd,blueray}disk; 4个字节
```
综上，总大小为14+4+0+0+4=22