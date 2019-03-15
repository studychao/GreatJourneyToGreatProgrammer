import edu.princeton.cs.algs4.MinPQ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Board {
    private int[][] board;
    private int Hamming = 0;
    private int Manhattan = 0;
    private int SpaceX;
    private int SpaceY;
    private int dimension;
    private int move=0;

    public Board(int[][] blocks)           // construct a board from an n-by-n array of blocks// (where blocks[i][j] = block in row i, column j)
    {
        dimension = blocks.length;
        board = new int[dimension][dimension];
        for (int i = 0 ; i< dimension ;i++){
            for (int j = 0; j < dimension ; j++){
                board[i][j] = blocks[i][j];
                if (!isCorrect(i,j,board[i][j])){
                    Hamming++;
                }
                Manhattan = Manhattan + CalManhattan(i,j,board[i][j]);
                if (blocks[i][j] == 0){
                    SpaceX = i;
                    SpaceY = j;
                }
            }
        }

    }
    public int dimension()                 // board dimension n
    {
        return dimension;
    }
    public int hamming()                   // number of blocks out of place
    {
        return Hamming;
    }
    public int manhattan()                 // sum of Manhattan distances between blocks and goal
    {
        return Manhattan ;
    }
    public boolean isGoal()                // is this board the goal board?
    {
        for (int i = 0 ;i<dimension ; i++){
            for (int j = 0;j<dimension ; j++){
                if(!isCorrect(i,j,board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }
    public Board twin()                    // a board that is obtained by exchanging any pair of blocks
    {
        Board tBoard;
        int flag = 0;
        int tmp=0;
        int tmp_x=0;
        int tmp_y=0;
        tBoard = new Board(board);
        if (tBoard.board[0][0] != 0 && tBoard.board[0][1] != 0)
        {
           tmp = tBoard.board[0][0] ;
           tBoard.board[0][0] = tBoard.board[0][1];
            tBoard.board[0][1] = tmp;
        }
        else if (tBoard.board[0][0] == 0)
        {
            tmp = tBoard.board[1][0] ;
            tBoard.board[1][0] = tBoard.board[0][1];
            tBoard.board[0][1] = tmp;
        }
        else if (tBoard.board[0][1] == 0)
        {
            tmp = tBoard.board[0][0] ;
            tBoard.board[0][0] = tBoard.board[1][0];
            tBoard.board[1][0] = tmp;
        }
        return tBoard;

    }
    public boolean equals(Object y)        // does this board equal y?
    {
        if (y == null)
            return false;
        if (y == this)
            return true;

        if (y.toString().equals(toString()))
            return true;
        else
            return false;
    }
    public Iterable<Board> neighbors()     // all neighboring boards
    {
        List<Board> neighbors = new LinkedList<Board>();
        if ((SpaceX-1) >= 0) // Can move up
        {
            Board up;
            int[][] board_up = Copyof(board);
            board_up[SpaceX][SpaceY] = board[SpaceX-1][SpaceY];
            board_up[SpaceX-1][SpaceY] = 0;
            up = new Board(board_up);
            neighbors.add(up);
        }

        if ((SpaceX+1) < dimension) // Can move down
        {
            Board down;
            int[][] board_down = Copyof(board);
            board_down[SpaceX][SpaceY] = board[SpaceX+1][SpaceY];
            board_down[SpaceX+1][SpaceY] = 0;
            down = new Board(board_down);
            neighbors.add(down);
        }

        if ((SpaceY-1) >= 0) // Can move up
        {
            Board left;
            int[][] board_left = Copyof(board);
            board_left[SpaceX][SpaceY] = board[SpaceX][SpaceY-1];
            board_left[SpaceX][SpaceY-1] = 0;
            left = new Board(board_left);
            neighbors.add(left);
        }

        if ((SpaceY+1) < dimension) // Can move up
        {
            Board right;
            int[][] board_right = Copyof(board);
            board_right[SpaceX][SpaceY] = board[SpaceX][SpaceY+1];
            board_right[SpaceX][SpaceY+1] = 0;
            right = new Board(board_right);
            neighbors.add(right);

        }
        return neighbors;
    }
    public String toString()               // string representation of this board (in the output format specified below)
    {
        StringBuilder s = new StringBuilder();
        s.append(dimension + "\n");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                s.append(String.format("%2d ", board[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }
    private boolean isCorrect(int i,int j,int num){
        if (num == (i*dimension()+j+1) || num == 0){
            return true;
        }
        else
            return false;
    }

    private int CalManhattan(int i,int j,int num){
        if (num == 0){
            return 0;
        }
        int result;
        int i_should = (num-1) / dimension();
        int j_should = num - i_should*dimension() - 1;
        result = Math.abs(i - i_should) + Math.abs(j - j_should);
        return result;
    }

    private int[][] Copyof(int[][] a){
        int[][] b = new int[a.length][a.length];
        for (int i = 0 ;i<dimension ; i++){
            for (int j = 0;j<dimension ; j++){
                b[i][j] = a[i][j];
                }
            }
        return b;
    }

    public static void main(String[] args) // unit tests (not graded)
    {
        int[][] board = {{1,2,3},{8,0,7},{4,5,6}};
        Board a = new Board(board);
        for (Board i : a.neighbors())
        {
           System.out.print(i.toString());
            System.out.println(i.hamming());
        }
    }
}