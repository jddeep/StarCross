package com.jddeep.android.stardroid_updated.base;

import android.support.annotation.VisibleForTesting;

import com.jddeep.android.stardroid_updated.util.WeakHashSet;

import java.util.Iterator;

public abstract class AbstractListenerAdapter<E> {
    private WeakHashSet<E> listeners = new WeakHashSet<E>();

    protected abstract void fireNewListenerAdded(E listener);

    public void addListener(E listener) {
        if(listener != null)
        if (listeners.add(listener)) {
            fireNewListenerAdded(listener);
        }
    }

    public void removeListener(E listener) {
        listeners.remove(listener);
    }

    public void removeAllListeners() {
        listeners.clear();
    }

    /**
     * Returns an upper bound on the number of listeners listening to this object.
     * The number of listeners returned is equal to the true number of listeners,
     * plus any listeners that have been garbage collected since the last time
     * getListeners() was called.
     */
    public int getNumListeners() {
        return listeners.size();
    }

    /**
     * Adds a WeakReference with no payload to the listeners map to ensure that
     * garbage collected listeners are correctly skipped.
     */
    @VisibleForTesting
    void addNullReference() {
        listeners.add(null);
    }

    /** Return an Iterable over the listeners referenced by this adaptor. */
    public Iterable<E> getListeners() {
        return new Iterable<E>() {
            public Iterator<E> iterator() {
                return listeners.iterator();
            }
        };
    }
}
