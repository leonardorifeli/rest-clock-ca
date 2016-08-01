package com.leonardorifeli.ca.clock.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class SillyDummyCacheImpl<K, V> implements DummyCache<K, V> {

    private Map<K, V> internalCache = new ConcurrentHashMap<>();

    @Override
    public V get(K key) {
        return this.internalCache.get(key);
    }

    @Override
    public void put(K key, V value) {
        this.internalCache.put(key, value);
    }

    @Override
    public boolean contains(K key) {
        return this.internalCache.containsKey(key);
    }

}