解法1.

如果没有overlap，
那么 矩形2的右上角在矩形1的左下角 之外 ； 或者 矩形2的左下角在矩形1的右上角 之外
即rec2[2] <= rec1[0] || rec2[3] <= rec1[1] || rec2[0] >= rec1[2] || rec2[1] >= rec1[3]

解法2
根据 交叉面积求
交叉面积的高为 矩形2和矩形1的右上角y坐标的min 减去 矩形2和矩形1的左下角y坐标的max
交叉面积的宽为 矩形2和矩形1的右上角x坐标的min 减去 矩形2和矩形1的左下角x坐标的max

宽和高都大于0 则overlap
反之不overlap