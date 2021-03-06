#Operating System

1. 进程
进程Thread 是 程序运行和资源分配的基本单位，一个程序至少有一个进程，一个进程至少有一个线程，进程在执行过程中占有独立的内存单元，而多个线程共享内存资源，减少切换次数，效率更高。
线程Process 是 进程的实体 是CPU调度和分派的基本单位 它是比进程更小的能独立运行的基本单位
一个进程可以有多个线程，多个线程也可以并发执行。

线程

线程共享的环境包括：进程代码段、进程的公有数据(利用这些共享的数据，线程很容易的实现相互之间的通讯)、进程打开的文件描述符、信号的处理器、进程的当前目录和进程用户ID与进程组ID。
 
    进程拥有这许多共性的同时，还拥有自己的个性。有了这些个性，线程才能实现并发性。这些个性包括：

    1.线程ID
      每个线程都有自己的线程ID，这个ID在本进程中是唯一的。进程用此来标
   识线程。
 
    2.寄存器组的值
       由于线程间是并发运行的，每个线程有自己不同的运行线索，当从一个线
   程切换到另一个线程上 时，必须将原有的线程的寄存器集合的状态保存，以便
   将来该线程在被重新切换到时能得以恢复。
 
    3.线程的堆栈
       堆栈是保证线程独立运行所必须的。
       线程函数可以调用函数，而被调用函数中又是可以层层嵌套的，所以线程
   必须拥有自己的函数堆栈， 使得函数调用可以正常执行，不受其他线程的影
   响。

    4.错误返回码
       由于同一个进程中有很多个线程在同时运行，可能某个线程进行系统调用
   后设置了errno值，而在该 线程还没有处理这个错误，另外一个线程就在此时
   被调度器投入运行，这样错误值就有可能被修改。
       所以，不同的线程应该拥有自己的错误返回码变量。

    5.线程的信号屏蔽码
       由于每个线程所感兴趣的信号不同，所以线程的信号屏蔽码应该由线程自己管理。但所有的线程都共享同样的信号处理器。

    6.线程的优先级
       由于线程需要像进程那样能够被调度，那么就必须要有可供调度使用的参数，这个参数就是线程的优先级。
2. 互斥锁 Mutex exclusion
防止多个线程同时读写某一块内存区域，防止多个线程同时读写某一块内存区域。

3. 信号量 Semaphore
门口挂n把钥匙，进取的人就取一把钥匙，出来时再把钥匙挂回原处，后到的人发现钥匙架空了，就知道必须在门口排队等着了。这种做法叫做信号量，用来保证多个线程不会相互冲突。

它允许同一时刻多个线程访问同一资源，但是需要控制同一时刻访问次资源的最大线程数量。
mutex是semaphore的一种特殊情况（n = 1)

4. 死锁
在两个或者多个并发进程中，如果每个进程持有某种资源而又等待其他进程释放它或他们现在保持着的资源，在未改变这种状态之前都不能向前推进，这一组进程即产生死锁。通俗地讲就是两个或多个进程无限期阻塞、相互等待的一种状态。

死锁产生的死条件：
- 互斥条件：一个资源一次只能被一个进程使用
- 请求与保持条件： 一个进程因请求资源而阻塞时，对已获得资源保持不放
- 不剥夺条件： 进程获得的资源，在未完全使用完之前，不能强行剥夺
- 循环等待条件： 若干进程之间形成一种头尾相接的环形等待资源关系

5. 进程状态
1） 就绪状态
  进程已获得除处理机以外的所需资源，等待分配处理机资源。
2） 运行状态
  占用处理机资源运行，处于此状态的进程数小于CPU数
3） 阻塞状态
  进程等待某种条件，在条件满足之前无法执行。

  多线程上下切换
  CPU控制权由一个已经正在运行的线程切换到另外一个就绪并等待获取CPU执行权的线程的过程。

6. 分段和分页

分页
1） 基本思想
  用户程序的地址空间被划分成若干固定大小的区域，称为“页”，相应地，内存空间分成若干个物理快，页和块的大小相等。可将用户程序的任一页放在内存的任一块中，实现了离散分配。

2) 分页存储管理的地址机构
  15	12	11			0

15-12 页号P
页号4位 每个作业最多2^4=16页 表示页号从0000～1111，页内位移量的位数表示页的大小，若页内位移量12位，则2的12次方=4k，页内地址从000000000000 ~ 111111111111

3）页表
分页系统中，允许将进程的每一页离散地存储在内存的任一物理块中，为了能在内存中找到每个页面对应的物理块，系统为每个进程建立一张页面映射表，简称页表。*页表的作用是实现从页号到物理块号的地址映射*
0        2    

1       15（F）    

2       14（E）    

3       1  

分段
1） 基本思想
将用户程序地址空间分成

7. 守护线程
程序运行完毕，jvm会等待非守护线程完成后关闭，但是jvm不会等待守护线程。
Java GC（Garbage Collection，垃圾收集，垃圾回收）机制，是Java与C++/C的主要区别之一，作为Java开发者，一般不需要专门编写内存回收和垃圾清理代码，对内存泄露和溢出的问题，也不需要像C程序员那样战战兢兢。

8. 操作系统中进程调度策略
FCFS（先来先服务）
优先级
时间片轮转

9. 读取磁盘上多个顺序数据块
（1）程序直接访问方式跟循环检测IO方式，应该是一个意思吧，是最古老的方式。CPU和IO串行，每读一个字节（或字），CPU都需要不断检测状态寄存器的busy标志，当busy=1时，表示IO还没完成；当busy=0时，表示IO完成。此时读取一个字的过程才结束，接着读取下一个字。
（2）中断控制方式：循环检测先进些，IO设备和CPU可以并行工作，只有在开始IO和结束IO时，才需要CPU。但每次只能读取一个字。
（3）DMA方式：Direct Memory Access，直接存储器访问，比中断先进的地方是每次可以读取一个块，而不是一个字。
（4）通道方式：比DMA先进的地方是，每次可以处理多个块，而不只是一个块。

10. 进程间通信方式


 管道( pipe )：管道是一种半双工的通信方式，数据只能单向流动，而且只能在具有亲缘关系的进程间使用。进程的亲缘关系通常是指父子进程关系。  
 信号量( semophore ) ： 信号量是一个计数器，可以用来控制多个进程对共享资源的访问。它常作为一种锁机制，防止某进程正在访问共享资源时，其他进程也访问该资源。因此，主要作为进程间以及同一进程内不同线程之间的同步手段。   
 消息队列( message queue ) ： 消息队列是由消息的链表，存放在内核中并由消息队列标识符标识。消息队列克服了信号传递信息少、管道只能承载无格式字节流以及缓冲区大小受限等缺点。   
 共享内存( shared memory ) ：共享内存就是映射一段能被其他进程所访问的内存，这段共享内存由一个进程创建，但多个进程都可以访问。共享内存是最快的 IPC 方式，它是针对其他进程间通信方式运行效率低而专门设计的。它往往与其他通信机制，如信号两，配合使用，来实现进程间的同步和通信。   
 套接字( socket ) ： 套解口也是一种进程间通信机制，与其他通信机制不同的是，它可用于不同及其间的进程通信。
 回调： 是一种编程机制。

 11. 系统调用 system call
 在计算机中，系统调用（英语：system call），又称为系统调用，指运行在用户空间的程序向操作系统内核请求*需要更高权限运行*的服务。系统调用提供用*户程序与操作系统*之间的接口。大多数系统交互式操作需求在*内核态*运行。如设备IO操作或者进程间通信。

 12. 编译过程
 源文件(.c/.cpp) -> 预编译 -> 编译 -> 汇编 -> 链接[.a/.lib || .so/.dll] -> 可执行文件

 13. 静态库
 之所以成为静态库，是因为在链接过程中，会将汇编生成的目标文件.a与引用的库一起链接打包到可执行文件中。因此对应的链接方式称为 静态链接
 缺点：空间浪费

 14. 动态库
 动态库在程序编译时并不会被连接到目标代码中，而是在程序运行是才被载入。不同的应用程序如果调用相同的库，那么在内存里只需要有一份该共享库的实例，规避了空间浪费问题
 缺点：时间慢

 15. 多道批处理系统
 多道批处理系统有两个特点：
1）多道：系统内可同时容纳多个作业。这些作业放在外存中，组成一个后备队列，系统按一定的调度原则每次从后备作业队列中选取一个或多个作业进入内存运行，运行作业结束、退出运行和后备作业进入运行均由系统自动实现，从而在系统中形成一个自动转接的、连续的作业流。
2） 成批：在系统运行过程中，不允许用户与其作业发生交互作用，即：作业一旦进入系统，用户就不能直接干预其作业的运行。

16. 缓冲区
缓冲区有两块:高速缓存区（物理存在）和磁盘缓存区（逻辑存在，实际是内存一块），都不在外存（硬盘）

17. 一些参数
- 相应比
R = (W+S) / S
W 等待时间 S 服务时间

- 平均周转时间
平均周转时间 =（等待时间+执行时间）/进程数

18. 内部碎片
内部碎片就是已经被分配出去（能明确指出属于哪个进程）却不能被利用的内存空间；
内部碎片是处于（操作系统分配的用于装载某一进程的内存）区域内部或页面内部的存储块。占有这些区域或页面的进程并不使用这个存储块。而在进程占有这块存储块时，系统无法利用它。直到进程释放它，或进程结束时，系统才有可能利用这个存储块。
单道连续分配只有内部碎片。多道固定连续分配既有内部碎片，又有外部碎片

19. 外部碎片
外部碎片指的是还没有被分配出去（不属于任何进程），但由于太小了无法分配给申请内存空间的新进程的内存空闲区域。
外部碎片是处于任何两个已分配区域或页面之间的空闲存储块。这些存储块的总和可以满足当前申请的长度要求，但是由于它们的地址不连续或其他原因，使得系统无法满足当前申请。
产生外部碎片的一种情况：
举个例子，在内存上，分配三个操作系统分配的用于装载进程的内存区域A、B和C。假设，三个内存区域都是相连的。故而三个内存区域不会产生外部碎片。现在假设B对应的进程执行完毕了操作系统随即收回了B，这个时候A和C中间就有一块空闲区域了。


20. LRU
LRU（Least recently used，最近最少使用）算法根据数据的历史访问记录来进行淘汰数据，其核心思想是“如果数据最近被访问过，那么将来被访问的几率也更高”。



 