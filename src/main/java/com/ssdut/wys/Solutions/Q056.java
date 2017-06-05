package com.ssdut.wys.Solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ryan on 17/5/21.
 */
/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */
public class Q056 {
    class Interval {
        int start;
        int end;
        Interval() {start = 0; end = 0;}
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<2) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if(o1.start<o2.start) {
                    return -1;
                } else if(o1.start > o2.start) {
                    return 1;
                } else {
                    if(o1.end <o2.end) {
                        return -1;
                    } else if(o1.end > o2.end){
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        List<Interval> result = new ArrayList<Interval>();
        int index = 1;
        int startTemp = intervals.get(0).start;
        int endTemp = intervals.get(0).end;
        while(index<intervals.size()) {
            int start = intervals.get(index).start;
            int end = intervals.get(index).end;
            if(start<=endTemp) {
                startTemp = Math.min(startTemp, start);
                endTemp = Math.max(endTemp, end);
            } else {
                result.add(new Interval(startTemp, endTemp));
                startTemp = start;
                endTemp = end;
            }

            index++;
        }

        result.add(new Interval(startTemp, endTemp));

        return result;
    }

    public void print(List<Interval> intervals) {
        for(int i=0;i<intervals.size();i++) {
            System.out.print("["+intervals.get(i).start+","+intervals.get(i).end+"] ");
        }
    }

    @Test
    public void testSolution() {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(2, 6));

        intervals.add(new Interval(15,18));

        Q056 solution = new Q056();
        List<Interval> result = solution.merge(intervals);
        solution.print(result);
    }
}
