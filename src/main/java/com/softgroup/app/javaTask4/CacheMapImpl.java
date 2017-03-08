package com.softgroup.app.javaTask4;

import java.util.*;

/**
 * Created by inna on 05.03.17.
 */
public class CacheMapImpl<K, V> implements CacheMap<K, V> {

    private int size;
    private Queue entry;

    CacheMapImpl(int size) {
        this.size = size;
        entry = new Queue(size);
    }

    private static final class Entry<K, V> implements Map.Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;

            return valEquals(key, e.getKey()) && valEquals(value, e.getValue());
        }

        public int hashCode() {
            int keyHash = (key == null ? 0 : key.hashCode());
            int valueHash = (value == null ? 0 : value.hashCode());
            return keyHash ^ valueHash;
        }

        public String toString() {
            return key + "=" + value;
        }

        static boolean valEquals(Object o1, Object o2) {
            return (o1 == null ? o2 == null : o1.equals(o2));
        }
    }

    private final class Queue {
        private Entry[] queue;
        private int maxSize; // максимальное количество элементов в очереди
        private int nElem;  // текущее количество элементов в очереди
        private int front;
        private int rear;

        Queue(int maxSize) {
            this.maxSize = maxSize;
            queue = new Entry[maxSize];
            rear = -1;
            front = 0;
            nElem = 0;
        }

        public void insert(Entry elem) {

            if (getEntryValueByKey((K) elem.getKey()) != null) {
                rewrite(elem);
                return;
            }

            if (rear == maxSize - 1) {  // циклический перенос
                rear = -1;
            }

            if (nElem < maxSize) {
                queue[++rear] = elem;  //увеличение Rear и вставка
                nElem++;  // увеличение количества элементов в очереди
            } else {
                entry.remove();
                queue[++rear] = elem;  //увеличение Rear и вставка
                nElem++;  // увеличение количества элементов в очереди
            }
        }

        void rewrite(Entry elem) {

            for (int i = 0; i < nElem; i++) {
                if (queue[i].getKey().equals(elem.getKey())) {
                    queue[i].setValue(elem.getValue());
                }
            }
        }

        public Entry remove() {
            Entry temp = queue[front++]; // получаем первый элемент из очереди

            if (front == maxSize) { // циклический перенос
                front = 0;
            }
            nElem--; // уменьшаем количество элементов в очереди
            return temp;

        }

        public Entry getFront() {
            return queue[front];
        }

        public Entry getRear() {
            return queue[rear];
        }

        public boolean isFull() {
            return (nElem == maxSize - 1);
        }

        public boolean isEmpty() {
            return (nElem == 0);
        }

        public int getSize() {
            return nElem;
        }

        V getEntryValueByKey(K key) {
            for (Entry en : queue) {
                if (en == null) break;
                if (en.getKey().equals(key))
                    return (V) en.getValue();
            }
            return null;
        }

        Object getEntryValue(Object value) {
            for (Entry en : queue) {
                if (en == null) break;
                if (en.getValue().equals(value))
                    return en.getValue();
            }
            return null;
        }

        Object[] getAllKeys() {

            Object[] keys = new Object[nElem];
            int i = 0;

            for (Entry en : queue) {
                if (en == null) break;
                keys[i] = en.getKey();
                i++;
            }
            return keys;
        }

        Object[] getValues() {
            Object[] values = new Object[nElem];
            int i = 0;

            for (Entry en : queue) {
                if (en == null) break;
                values[i] = en.getValue();
                i++;
            }
            return values;
        }

        Entry[] emtrySet() {
            return queue;
        }

    }

    @Override
    public int getDeleteCount() {
        return entry.maxSize;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return entry.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return entry.getEntryValue(value) != null;
    }

    @Override
    public V get(Object key) {
        return entry.getEntryValueByKey((K) key);
    }

    @Override
    public V put(K key, V value) {

        entry.insert(new Entry<>(key, value));
        return value;
    }

    @Override
    public void clear() {
        size = 0;
        entry = new Queue(size);
    }

    @Override //the remove operation is not supported by this map
    public V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {

        entry = new Queue(map.size());
        Object[] keys = map.keySet().toArray();
        Object[] values = map.values().toArray();
        for (int i = 0; i < map.size(); i++) {
            this.entry.insert(new Entry<>((K) keys[i], (V) values[i]));
        }
    }

    @Override
    public Set<K> keySet() {
        return new LinkedHashSet<>(Arrays.asList((K[]) entry.getAllKeys()));
    }

    @Override
    public Collection<V> values() {
        return new LinkedList<V>(Arrays.asList((V[]) entry.getValues()));
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new LinkedHashSet<>(Arrays.asList((Map.Entry<K, V>[]) entry.emtrySet()));
    }
}
