package com.jddeep.android.stardroid_updated.base;

public interface Provider<T> {

    /**
     * Provides an instance of type T. Implementors may choose to either return a
     * new instance upon every call, or provide the same instance for all calls.
     */
    T get();
}
