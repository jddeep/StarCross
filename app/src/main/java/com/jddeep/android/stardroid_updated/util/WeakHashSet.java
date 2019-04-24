package com.jddeep.android.stardroid_updated.util;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class WeakHashSet<E> extends AbstractSet<E> implements Set<E> {
    private final WeakHashMap<E, Void> hashMap = new WeakHashMap<E, Void>();

    @Override
    public Iterator<E> iterator() {
        return hashMap.keySet().iterator();
    }

    @Override
    public boolean add(E object) {
        if (hashMap.containsKey(object)) {
            return false;
        }
        hashMap.put(object, null);
        return true;
    }

    @Override
    public int size() {
        return hashMap.size();
    }
}
