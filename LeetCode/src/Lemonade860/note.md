#本题思路

首先，如果顾客给5¥ 那么就收下这笔钱，同时代表5¥纸币数量的变量+1
     如果顾客给10¥ 那么就要找5¥ 5¥纸币数量-1 10¥数量+1
     如果顾客给20¥ 那么就要找15¥ 要么3*5¥（即5¥数量-3） 要么 10¥ + 5¥

     这些条件首先判断纸币数量是否符合要求，若不符合就返回false，然后进行运算直到bills数组的所有元素都被遍历。


##知识
没啥数据结构，都是对于情景的模拟，注意一下仔细读题和思考！