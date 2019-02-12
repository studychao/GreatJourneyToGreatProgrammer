import java.util.Comparator;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

public class Solver {

    private SearchNode goal;

    private class SearchNode{
        private Board board;
        private SearchNode prev;
        private int move;

        public SearchNode(Board b)
        {
            move = 0;
            prev = null;
            board = b;
        }
    }

    public Solver(Board initial)           // find a solution to the initial board (using the A* algorithm)
    {
        if (initial == null)
            throw new java.lang.IllegalArgumentException();
        PriorityOrder pr = new PriorityOrder();
        MinPQ<SearchNode> pq = new MinPQ<SearchNode>(pr);
        SearchNode a = new SearchNode(initial);

        PriorityOrder twinpr = new PriorityOrder();
        MinPQ<SearchNode> twinpq = new MinPQ<SearchNode>(twinpr);
        SearchNode twina = new SearchNode(initial.twin());

        pq.insert(a);
        twinpq.insert(twina);

        SearchNode minNode = pq.delMin();
        SearchNode mintwinNode = twinpq.delMin();

        while (!minNode.board.isGoal() && !mintwinNode.board.isGoal() )
        {
            for (Board i : minNode.board.neighbors())
            {
                SearchNode new_a = new SearchNode(i);
                new_a.prev = minNode;
                new_a.move = minNode.move + 1;
                if (minNode.prev == null)
                {
                    pq.insert(new_a);
                }
                else if (!i.equals(minNode.prev.board))
                {
                    pq.insert(new_a);
                }
            }

            minNode = pq.delMin();

            for (Board i : mintwinNode.board.neighbors())
            {
                SearchNode new_twina = new SearchNode(i);
                new_twina.prev = mintwinNode;
                new_twina.move = mintwinNode.move + 1;
                if (mintwinNode.prev == null)
                {
                    twinpq.insert(new_twina);
                }
                else if (!i.equals(mintwinNode.prev.board))
                {
                    twinpq.insert(new_twina);
                }

            }
            mintwinNode = twinpq.delMin();
        }

        if (minNode.board.isGoal()){
            goal = minNode;
        }
        else
        {  goal = null;}

    }
    public boolean isSolvable()            // is the initial board solvable?
    {
        if (goal == null)
        {
            return false;
        }
        else
            return true;
    }
    public int moves()                     // min number of moves to solve initial board; -1 if unsolvable
    {
        if (!isSolvable())
            return -1;
        else
            return goal.move;
    }
    public Iterable<Board> solution()      // sequence of boards in a shortest solution; null if unsolvable
    {
        Stack<Board> solu = new Stack<Board>();
        if (!isSolvable()) {
            return null;
        }
        else
        {
            SearchNode begin = goal;
            while (begin.prev!=null)
            {
                solu.push(begin.board);
                begin = begin.prev;
            }
            solu.push(begin.board);
        }
        return solu;
    }

    private class PriorityOrder implements Comparator<SearchNode> {
        public int compare(SearchNode s1, SearchNode s2) {
            int priority1 = s1.board.manhattan() + s1.move;
            int priority2 = s2.board.manhattan() + s2.move;

            int man_sub1 = s1.board.manhattan();
            int man_sub2 = s2.board.manhattan();

            if         (priority1 > priority2) return 1;
            else if (priority1 < priority2) return -1;
            else if (man_sub1 < man_sub2) return -1;
            else if (man_sub1 > man_sub2) return 1;
            else
                return 0;
        }
    }

    public static void main(String[] args) // solve a slider puzzle (given below)
    {
        int[][] board_init = {{1,2,3},{4,5,6},{8,7,0}};
        Board board = new Board(board_init);
        Solver board_solver = new Solver(board);
        for (Board i : board_solver.solution())
        {
            System.out.print(i.toString());
        }
    }

}
