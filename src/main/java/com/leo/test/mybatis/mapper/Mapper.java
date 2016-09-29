package com.leo.test.mybatis.mapper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Senchenko Viktor on 26.09.2016.
 */
public interface Mapper<T> {

    public List<T> list();

    public T get(Serializable id);

    public void delete(T object);

    public void create(T object);

    public void edit(T object);
}
