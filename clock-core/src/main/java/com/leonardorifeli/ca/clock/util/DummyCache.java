package com.leonardorifeli.ca.clock.util;

public interface DummyCache <K, V> {

    public V get(K key);
    public void put(K key, V value);
    public boolean contains(K key);

}