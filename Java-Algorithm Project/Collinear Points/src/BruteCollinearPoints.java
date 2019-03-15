import java.util.Arrays;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
    private LineSegment[] lines = new LineSegment[1];
    private int lines_index = 0;
    public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
    {
        if (points == null)
        {
            throw new java.lang.IllegalArgumentException();
        }

        for (int i = 0 ; i < points.length -1; i++)
        {
            if (points[i] == null)
            {
                throw new java.lang.IllegalArgumentException();
            }
        }
        Arrays.sort(points);
        for (int i = 0 ; i < points.length -1; i++)
        {
            if (points[i].compareTo(points[i+1]) == 0)
            {
                throw new java.lang.IllegalArgumentException();
            }
        }
        int i = points.length;
        for (int m1 = 0 ; m1 < i; m1++)
        {
            for (int m2 = m1+1; m2 < i ; m2++)
            {
                for (int m3 = m2 +1 ; m3<i ; m3++)
                {
                    for (int m4 = m3 + 1 ; m4<i ; m4++)
                    {
                        if (points[m1].slopeTo(points[m2]) == points[m2].slopeTo(points[m3]) && points[m2].slopeTo(points[m3]) ==
                                points[m3].slopeTo(points[m4]))
                        {
                            LineSegment a = new LineSegment(points[m1],points[m4]);
                            if (lines_index == lines.length)
                            {
                                LineSegment[] temp = new LineSegment [2*lines.length];
                                for (int newIdx=0; newIdx<lines.length; newIdx++) {
                                    temp[newIdx] = lines[newIdx];
                                }
                                lines = temp;
                            }
                            lines[lines_index] = a;
                            lines_index++;
                        }

                    }
                }
            }
        }
        removeExtraSpace();
    }
    public           int numberOfSegments()        // the number of line segments
    {
        return lines_index;
    }
    public LineSegment[] segments()                // the line segments
    {
        return lines.clone();
    }
    private void removeExtraSpace()
    {
        LineSegment[] copy = new LineSegment[lines_index];

        for(int i = 0 ;  i < lines_index ; i++)
            copy[i] = lines[i];

        lines = copy;
    }
    public static void main(String[] args) {
    }
}