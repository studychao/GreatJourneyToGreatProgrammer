package QuickSort;

public class quicksort {
    public static int partition(int[] a,int hi,int lo)
    {
        int i = lo;
        int j = hi + 1;
        while (true) {
        while (a[lo] > a[++i])
            if (i == hi) break;
        while (a[lo] < a[--j])
            if (j == lo) break;

        if (i >= j) break;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
        int tmp = a[lo];
        a[lo] = a[j];
        a[j] = tmp;
        return j;
    }

    public static void sort(int[] a)
    {
        int length = a.length;
        sort(a,0,length-1);
    }

    public static void sort(int[] a,int hi,int lo)
    {
        if (hi <= lo) return;
        int par = partition(a,hi,lo);
        sort(a,par-1,lo);
        sort(a,hi,par+1);
    }
}
