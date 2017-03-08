package com.softgroup.app.javaTask4;

import java.util.*;

/**
 * Created by inna on 05.03.17.
 */
public interface CacheMap<K,V> extends Map<K, V> {
    /**
     * Returns the number of key-value mappings in this map.  If the
     * map contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of key-value mappings in this map
     */
    public int getDeleteCount();

}
