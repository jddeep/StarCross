package com.jddeep.android.stardroid_updated.base;

import android.support.annotation.Nullable;

import java.util.Comparator;

public class Pair <E, F> {
    private E first;
    private F second;

    public Pair(@Nullable E first, @Nullable F second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public void setFirst(@Nullable E first) {
        this.first = first;
    }

    public F getSecond() {
        return second;
    }

    public void setSecond(@Nullable F second) {
        this.second = second;
    }

    public static <S, T> Pair<S, T> of(S first, T second) {
        return new Pair<S, T>(first, second);
    }

    /**
     * Returns a new comparator which compares the first object in a set of pairs using the
     * specified Comparator.
     */
    public static <S> Comparator<Pair<S, ?>> comparatorOfFirsts(Comparator<S> comparator) {
        return new FirstComparator<S>(comparator);
    }

    private static class FirstComparator<E> implements Comparator<Pair<E, ?>> {
        private final Comparator<E> comparator;

        public FirstComparator(Comparator<E> comparator) {
            this.comparator = comparator;
        }

        public int compare(Pair<E, ?> object1, Pair<E, ?> object2) {
            return comparator.compare(object1.getFirst(), object2.getFirst());
        }
    }
}

