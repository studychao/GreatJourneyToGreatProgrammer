import java.util.Arrays;

public class FastCollinearPoints {
    private LineSegment[] lines = new LineSegment[1];
    private int lines_index = 0;
    private Point[] aux = new Point[1];
    private int aux_index = 0;

    public FastCollinearPoints(Point[] points)     // finds all line segments containing 4 or more points
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
        for(int i = 0; i < points.length ; i++)
        {
            Arrays.sort(points);
            Arrays.sort(points,points[i].slopeOrder());
           // for (Point m : points)
           // {
            //    System.out.println(m.toString());
            //}
            int runner = 1;
            int start = 1;
            while (runner < points.length-1)
            {
                //System.out.println("r = " +runner +"s = " +start );
                if (points[0].slopeTo(points[runner]) != points[0].slopeTo(points[runner+1]))
                {
                    if (runner - start >= 2)
                    {
                        Point max = findmax(points[0],points[runner],points[runner-1],points[runner-2]);
                        Point min = findmin(points[0],points[runner],points[runner-1],points[runner-2]);
                        if (exam_aux(max,min)) {
                            add_to_lines(points[0], points[runner]);
                            add_to_aux(max);
                            add_to_aux(min);
                        }
                            start = runner + 1;
                        }

                    else{

                        start = runner +1;
                    }

                }
                else
                {
                    if (runner == (points.length-2) && runner-start == 1 )
                    {
                        Point max = findmax(points[0],points[runner],points[runner-1],points[runner+1]);
                        Point min = findmin(points[0],points[runner],points[runner-1],points[runner+1]);
                       // System.out.println("max = " + max.toString() + "min = " + min.toString());
                        if (exam_aux(max,min)) {
                            add_to_lines(min,max);
                            add_to_aux(max);
                            add_to_aux(min);
                        }
                        start = runner + 1;
                    }
                }
                runner++;
                }
            }
    removeExtraSpace();
    }
    private void add_to_aux (Point a)
    {
        if (aux_index == aux.length)
        {
            Point[] temp = new Point[lines.length*2];
            for (int i = 0; i<aux.length;i++)
            {
                temp[i] = aux[i];
            }
            aux = temp;
        }
        aux[aux_index++] = a;
    }

    private void add_to_lines (Point min,Point max)
    {
        if (lines_index == lines.length)
        {
            LineSegment[] temp = new LineSegment[lines.length*2];
            for (int i = 0; i<lines.length;i++)
            {
                temp[i] = lines[i];
            }
            lines = temp;
        }
        lines[lines_index++] = new LineSegment(min,max);
    }
    private boolean exam_aux (Point max,Point min)
    {
        for(int i = 0; i< aux_index;i++)
        {
            if (aux[i] == max)
            {
                if (aux[i+1] == min )
                {
                    return false;
                }
            }
        }
        return true;
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

    private Point findmax(Point a, Point b ,Point c, Point d)
    {
        Point max,submax1,submax2;
        if (a.compareTo(b) >= 0)
        {
            submax1 = a;
        }
        else
        {
            submax1 = b;
        }

        if (c.compareTo(d) >= 0)
        {
            submax2 = c;
        }
        else
        {
            submax2 = d;
        }
        if (submax1.compareTo(submax2) >0)
        {
            max = submax1;
        }
        else
        {
            max = submax2;
        }
    return max;
    }

    private Point findmin(Point a, Point b ,Point c, Point d)
    {
        Point min,submin1,submin2;
        if (a.compareTo(b) < 0)
        {
            submin1 = a;
        }
        else
        {
            submin1 = b;
        }

        if (c.compareTo(d) < 0)
        {
            submin2 = c;
        }
        else
        {
            submin2 = d;
        }
        if (submin1.compareTo(submin2) <0)
        {
            min = submin1;
        }
        else
        {
            min = submin2;
        }
        return min;
    }
    public static void main(String[] args) {


    }

}
