package lt.codeacademy.generic.Task.Task3;

import java.util.ArrayList;
import java.util.List;

public class MapCollection<K, V> {

    private final List<Pair<K, V>> poros;

    public MapCollection() {
        this.poros = new ArrayList<>();
    }

    public void add(K key, V value) {
        poros.add(new Pair<>(key, value));

    }

    public V get(K key) {
        return  poros.stream().filter(p -> p.getKey()
                .equals(key)).findFirst().map(Pair::getValue)
                .orElse(null);
    }
}
