package bfs;

import org.assertj.core.api.Assertions;

import java.util.LinkedList;

/**
 * Solution : BFS
 */
public class SurroundedRegions {

    public void solve(char[][] board) {

        if(board == null || board.length == 0){
            return;
        }

        int m = board.length;
        int n = board[0].length;

        // flag from boarder cases
        for(int i = 0; i<m;i++){
           for(int j = 0; j<n;j++){
               if((i==0||j==0||i==m-1||j==n-1) && board[i][j] == 'O'){
                   bfsFlag(board, i, j);
               }
           }
        }

        // replace symbols
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfsFlag(char[][] board, int nodeX, int nodeY){

        LinkedList<int[]> nodes = new LinkedList<>();
        nodes.add(new int[]{nodeX, nodeY});

        while (!nodes.isEmpty()){

            int[] node = nodes.removeFirst();
            int x = node[0];
            int y = node[1];

            if(x < 0 || x >= board.length || y<0 || y >= board[0].length || board[x][y] != 'O'){
                continue;
            }

            board[x][y] = '#';
            nodes.add(new int[]{x-1, y});
            nodes.add(new int[]{x+1, y});
            nodes.add(new int[]{x, y-1});
            nodes.add(new int[]{x, y+1});
        }
    }

    public static void main(String[] args) {
        SurroundedRegions solution = new SurroundedRegions();

        char[][] board = new char[][]{
            {'X', 'X', 'X', 'X',},
            {'X', 'O', 'O', 'X',},
            {'X', 'X', 'O', 'X',},
            {'X', 'O', 'X', 'X',}
        };
        solution.solve(board);
        Assertions.assertThat(board).containsExactly(
            new char[]{'X', 'X', 'X', 'X',},
            new char[]{'X', 'X', 'X', 'X',},
            new char[]{'X', 'X', 'X', 'X',},
            new char[]{'X', 'O', 'X', 'X',}
        );
    }
}
