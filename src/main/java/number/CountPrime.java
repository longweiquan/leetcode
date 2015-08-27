package number;

import org.assertj.core.api.Assertions;

/**
 * Created by longweiquan on 15/8/27.
 */
public class CountPrime {

    public int countPrimes(int n) {

        boolean[] multiples = new boolean[n];

        for(int i=2;i*i<n;i++){
            if(!multiples[i]){
                for(int j=i+i;j<n;j+=i){
                    multiples[j] = true;
                }
            }
        }

        int count = 0;
        for(int i=2;i<n;i++){
            if(!multiples[i]){
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrime solution = new CountPrime();
        Assertions.assertThat(solution.countPrimes(120)).isEqualTo(30);
        Assertions.assertThat(solution.countPrimes(2)).isEqualTo(0);
    }
}
