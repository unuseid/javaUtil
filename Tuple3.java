package com.miribit.util;

public class Tuple3<A, B, C> {
    private final A a;
    private final B b;
    private final C c;

    public Tuple3(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static <A, B, C> Tuple3<A, B, C> of(final A a, final B b, final C c) {
        return new Tuple3<>(a, b, c);
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    public C getC() {
        return c;
    }

    @Override
    public String toString(){
        String stringBuilder =
                "a[" + a.getClass().getName() + "]:" + a + "\n" +
                "b[" + b.getClass().getName() + "]:" + b + "\n" +
                "c[" + c.getClass().getName() + "]:" + c + "\n";
        return stringBuilder;
    }
}
