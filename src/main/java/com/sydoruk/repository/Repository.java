package com.sydoruk.repository;

public interface Repository<T> {

    void save(final T object);

}
