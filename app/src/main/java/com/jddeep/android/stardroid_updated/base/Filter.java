package com.jddeep.android.stardroid_updated.base;

public interface Filter<E> {

    /** Returns true if the given object should be included in the collection.
     */
    public boolean accept(E object);
}

