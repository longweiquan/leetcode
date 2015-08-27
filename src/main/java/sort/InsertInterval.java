package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> results = new ArrayList<>();

        List<Interval> i = results.stream().filter(x-> x.start != 0).collect(Collectors.toList());

        // TODO
        return results;
    }
}
