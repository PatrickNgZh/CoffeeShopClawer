package com.patrick.coffeeshopclawer;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author peicong
 * @date 2018/3/1 0001
 */
public class test implements Comparable<test> {
    int index;
    int num;

    public test(int index, int num) {
        this.index = index;
        this.num = num;
    }

    public int getIndex() {
        return index;
    }

    public int getNum() {
        return num;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        return new Integer(num).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        test t = (test) obj;
        if (num == t.getNum()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<test> set = new TreeSet<>();
        int num = scanner.nextInt();
        test te = null;
        for (int i = 0; i < num; i++) {
            test temp = new test(scanner.nextInt(), scanner.nextInt());
            if (set.contains(temp)) {
                for (test tes : set) {
                    if (tes.getIndex() == temp.getIndex()) {
                        te = tes;
                        set.remove(tes);
                        te.setNum(te.getNum() + temp.getNum());
                        set.add(te);
                        break;
                    }
                }
                continue;
            } else {
                set.add(temp);
            }
        }
        System.out.println(set);
    }

    @Override
    public String toString() {
        return "test{" +
                "index=" + index +
                ", num=" + num +
                '}';
    }

    @Override
    public int compareTo(test o) {
        return (o.getNum() - this.num);
    }
}
