package com.leonardorifeli.ca.clock.util;

public class DummyCacheProvider {

    public static <K, V> DummyCache<K, V> getCache() {
        return new SillyDummyCacheImpl<>();
    }

}