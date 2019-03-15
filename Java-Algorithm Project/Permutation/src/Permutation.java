import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> a = new RandomizedQueue<>();
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            a.enqueue(s);
        }
        for (int i = 0; i < k; i++) {
            System.out.println(a.dequeue());
        }

    }
}
