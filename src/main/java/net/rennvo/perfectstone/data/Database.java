package net.rennvo.perfectstone.data;

public interface Database<T, V> {

    public void saveAll();

    public void save(T data);

    public T load(V key);
}
