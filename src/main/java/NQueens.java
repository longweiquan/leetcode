/**
 * Classic NP Problems. THis class provide a back tracking recursive solution.
 *
 * Data structure : a solution is represented by an one dimensional array where index as row and value as column
 *
 * Constraint :
 *  1. one queen by row      => an index for only one value
 *  2. one queen by column   => values in array should not be identical in array
 *  3. one queen by diagonal => index+value should not be identical in array
 *
 *  rules simplified         => for array A and index i > j, | A[i] - A[j] | != (0 | i-j)
 *
 */
public class NQueens {

    public int totalNQueens(int n) {

        if(n<1){
            return 0;
        }

        Solver solver = new Solver(n);
        return solver.getCount();
    }

    public class Solver{

        private int[] queens;
        private int max;
        private int count;

        public Solver(int n){
            max = n;
            queens = new int[n];
            count = solve(0);
        }
        public int getCount(){
            return count;
        }

        private int solve(int n) {
            if (n == max) {
                return 1;
            } else {
                int total = 0;
                for (int j=0;j<max;j++){
                    queens[n] = j;
                    if(check(n)){
                        total += solve(n+1);
                    }
                }
                return total;
            }
        }

        private boolean check(int n){

            for(int i=0; i<n;i++){
                int diff = Math.abs(queens[i]-queens[n]);
                if(diff == 0 || diff == n-i){
                    return false;
                }
            }
            return true;
        }

    }
}
