package mergesort;

public class mergesort {
    static void  sort(int[] sort){
        int low = 0;
        int high = sort.length-1;
        int[] aux = new int[sort.length];
        sort(sort,aux,low,high);
    }

    static void sort(int[] sort,int[] aux,int low,int high)
    {
        int mid = (high+low)/2;
        if(mid<high) {
            sort(sort, aux, low, mid);
            sort(sort, aux, mid + 1, high);
            merge(sort, aux, low, mid, high);
        }
    }

    static void merge(int[] sort,int[] aux, int low, int mid, int high){
        for(int i = low;i<=high;i++)
        {
            aux[i] = sort[i];
        }
        int m = low;
        int j = mid+1;
        for(int i = low;i<=high;i++)
        {
            if (m > mid)
            {
                sort[i] = aux[j++];
            }
           else if (j > high)
            {
                sort[i] = aux[m++];
            }
            else if (aux[m] > aux[j]) {
                sort[i] = aux[j++];
            }
            else
            {
                sort[i] = aux[m++];
            }
        }
    }

    public static void main(String[] args) {
        int[] a ={1,2,8,4,9,6,7};
        sort(a);
        for (int i : a)
        {
            System.out.println(i);
        }

    }
}
