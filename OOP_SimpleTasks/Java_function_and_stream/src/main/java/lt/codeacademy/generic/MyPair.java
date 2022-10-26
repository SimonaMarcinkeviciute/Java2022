package lt.codeacademy.generic;

public class MyPair<K, V> implements Pair<K, V>{

    private final K k;
    private final V v;

    public MyPair(K k, V v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public K getKey() {
        return k;
    }

    @Override
    public V getValue() {
        return v;
    }
}
