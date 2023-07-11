package com.miribit.util;

public class Tuple2<A, B> {
    private final A a;
    private final B b;

    public Tuple2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public static <A, B> Tuple2<A, B> of(final A a, final B b) {
        return new Tuple2<>(a, b);
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    @Override
    public String toString(){
        String stringBuilder =
                "a[" + a.getClass().getName() + "]:" + a + "\n" +
                "b[" + b.getClass().getName() + "]:" + b + "\n";
        return stringBuilder;
    }
}
