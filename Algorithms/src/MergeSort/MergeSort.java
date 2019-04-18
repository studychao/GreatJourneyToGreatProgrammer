package MergeSort;

public class MergeSort {
    public static void sort(int[] a){
        int[] aux = new int[a.length];
        sort(a,aux,0,a.length-1);
    }

    public static void sort(int[] a,int[] aux, int lo, int hi){
        int mid = (lo + hi) /2;
        if (mid < hi) {
            sort(a,aux,lo, mid);
            sort(a,aux, mid + 1, hi);
            merge(a,aux, lo,mid,hi);
        }
    }

    public static void merge(int[] a ,int[] aux,int lo,int mid, int hi) {
        for (int i = lo; i <= hi; i++){
            aux[i] = a[i];
        }
        int j = lo;
        int m = mid+1;
        for (int i = lo; i <= hi ; i++){
            if (m > hi)
                a[i] = aux[j++];
            else if (j > mid)
                a[i] = aux[m++];
            else if (aux[j] > aux[m])
                a[i] = aux[m++];
            else
                a[i] = aux[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = {3,2};
        sort(a);
        for (int i : a){
            System.out.println(i);
        }
    }
}
