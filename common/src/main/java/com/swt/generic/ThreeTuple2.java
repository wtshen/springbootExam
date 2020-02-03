package com.swt.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wtshen
 * @Description:
 * @Date: Created in 10:54 AM 2020/2/3.
 * @Modified By:
 */
public class ThreeTuple2<A, B, C> {
    public final A first;
    public final B second;
    public final C three;

    public ThreeTuple2(A a, B b, C c) {
        this.first = a;
        this.second = b;
        this.three = c;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + "," + three + ")";
    }
}

class TupleList extends ArrayList<ThreeTuple2> {
    static ThreeTuple2<Integer, String, Character> h() {
        return new ThreeTuple2(99, "test", 'a');
    }

    public static void main(String[] args) {
        TupleList ts = new TupleList();
        ts.add(h());
        ts.add(h());
        for (ThreeTuple2 t : ts) {
            System.out.println(t);
        }

        List<String> aa = new ArrayList<String>();
    }
}