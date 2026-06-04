package org.funpilot.coding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinPrice {
    public record Interval(int startTime, int endTime, int price) {}

    public List<Interval> run(List<Interval> vendors) {
        if (!isValid(vendors)) {
            System.out.println("invalid input");
            return new ArrayList<>();
        }
        System.out.print("vendors: ");
        printList(vendors);
        Comparator<Interval> priceComparator = Comparator.comparing(Interval::price);
        List<Interval> sortedVendors = vendors.stream().sorted(priceComparator).toList();

        List<Interval> result = new ArrayList<>();
        for (Interval v : sortedVendors) {
            print(v, "v");
            if (result.isEmpty()) {
                result.add(v);
                System.out.println();
                continue;
            }

            List<Interval> newInterval = new ArrayList<>();
            int start = v.startTime;
            int end = v.endTime;
            int r_cnt = 0;  // track if last interval in result list
            for (Interval r : result) {
                print(r, "r");
                ++r_cnt;
                // non-overlapping (front)
                if (start < r.startTime && end < r.startTime) {
                    System.out.print("case1 ");
                    newInterval.add(new Interval(start, end, v.price));
                    break;
                }
                // non-overlapping (back)
                if (start > r.endTime && end > r.endTime) {
                    System.out.print("case2 ");
                    // append if last, otherwise compare next interval
                    if (r_cnt == result.size()) {
                        newInterval.add(new Interval(start, end, v.price));
                        break;
                    }
                    System.out.print("s:" + start + ",e:" + end + " ");
                    continue;
                }
                // within current interval
                if (start >= r.startTime && end <= r.endTime) {
                    System.out.print("case3 ");
                    break;
                }
                // partial overlap (front)
                if (start < r.startTime && end >= r.startTime) {
                    System.out.print("case4 ");
                    newInterval.add(new Interval(start, r.startTime-1, v.price));
                    if (end <= r.endTime) {
                        break;
                    } else {
                        start = r.endTime+1;
                    }

                } else if (start <= r.endTime && end > r.endTime) {  // partial overlap (back)
                    System.out.print("case5 ");
                    start = r.endTime+1;
                }
                if (r_cnt == result.size()) {
                    System.out.print("remain ");
                    newInterval.add(new Interval(start, end, v.price));
                    break;
                }
            }
            result.addAll(newInterval);
            result.sort(Comparator.comparing(Interval::startTime));

            System.out.print("tmp result: ");
            printList(result);
        }
        System.out.print("result: ");
        printList(result);
        return result;
    }

    private boolean isValid(List<Interval> list) {
        for (Interval i : list) {
            if (i.startTime > i.endTime) {
                return false;
            }
        }
        return true;
    }

    private void print(Interval i, String prefix) {
        if (prefix == null) {
            prefix = "";
        }
        System.out.print(prefix + "[" + i.startTime + "," + i.endTime + "," + i.price + "] ");
    }
    public void printList(List<Interval> list) {
        for (Interval i : list) {
            print(i, null);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MinPrice ins = new MinPrice();
        // base
        ins.run(List.of(
                new Interval(1,20,13),
                new Interval(5,10,8),
                new Interval(3,8,15),
                new Interval(1,5,20)));
        System.out.println();

        // non overlapping
        ins.run(List.of(
                new Interval(5,8,13),
                new Interval(1,3,8),
                new Interval(16,20,15),
                new Interval(10,13,20)));
        System.out.println();

        // overlapping
        ins.run(List.of(
                new Interval(3,7,13),
                new Interval(1,3,8),
                new Interval(5,10,15),
                new Interval(9,13,10)));
        System.out.println();

        // one within the other
        ins.run(List.of(
                new Interval(1,18,13),
                new Interval(2,5,8),
                new Interval(7,10,15),
                new Interval(9,13,10)));
        System.out.println();
    }
}
