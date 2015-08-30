package org.lwq.sort;

import org.assertj.core.api.Assertions;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 */
public class MergeInterval {

    public List<Interval> merge(List<Interval> intervals) {

        // sort intervals by start
        Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);

        List<Interval> results = new ArrayList<>();
        Interval current = null;

        for(Interval interval: intervals){
            if(current == null){
                current = interval;
            } else if(current.end < interval.start){
                results.add(current);
                current = interval;
            } else {
                current = new Interval(current.start, Math.max(current.end, interval.end));
            }
        }
        if(current != null){
            results.add(current);
        }
        return results;
    }

    public static void main(String[] args) {
        MergeInterval solution = new MergeInterval();

        List<Interval> input = Arrays.asList(
            new Interval(1, 3), new Interval(2, 6), new Interval(8, 10), new Interval(15, 18));
        List<Interval> output = solution.merge(input);

        Assertions.assertThat(output.size()).isEqualTo(3);
        Assertions.assertThat(output.get(0)).isEqualToComparingFieldByField(new Interval(1, 6));
        Assertions.assertThat(output.get(1)).isEqualToComparingFieldByField(new Interval(8, 10));
        Assertions.assertThat(output.get(2)).isEqualToComparingFieldByField(new Interval(15, 18));

        output = solution.merge(new ArrayList<>());
        Assertions.assertThat(output.size()).isEqualTo(0);

        input = Arrays.asList(new Interval(1, 4), new Interval(0, 4));
    }
}
