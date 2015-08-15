import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 8002273 on 6/3/2015.
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        int level = 0;
        List<Integer[]> lastLevelSquares = getSquares(matrix, level, null);

        while(lastLevelSquares.size() > 0){
            level++;
            lastLevelSquares = getSquares(matrix, level, lastLevelSquares);
        }

        return level * level;
    }

    public List<Integer[]> getSquares(char[][] matrix, int level, List<Integer[]> lastLevelSquares){

        List<Integer[]> squares = new ArrayList<>();

        if(level <= 0){
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[i].length; j++){

                    if(matrix[i][j] == 1){
                        squares.add(new Integer[]{i,j});
                    }
                }
            }
        } else {
            for(Integer[] lastSquare : lastLevelSquares){

                int x = lastSquare[0];
                int y = lastSquare[1];
                int d = level;

                if(matrix.length > x+d && matrix[x].length > y+d && matrix[x+d][y] == 1 && matrix[x][y+d] == 1 && matrix[x+d][y+d] == 1){
                    squares.add(new Integer[]{x,y});
                }
            }
        }

        return squares;
    }

    public static void main(String[] args){

        char[][] level0 = new char[][]{};

        char[][] level1 = new char[][]{
            {1},
        };

        char[][] level2 = new char[][]{
            {1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0}
        };

        MaximalSquare solution = new MaximalSquare();
        Assert.assertEquals(0, solution.maximalSquare(level0));
        Assert.assertEquals(1, solution.maximalSquare(level1));
        Assert.assertEquals(4, solution.maximalSquare(level2));
    }
}
