package com.leo.test.mybatis.repository;

import com.leo.test.mybatis.mapper.Mapper;
import com.leo.test.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;

/**
 * Created by Senchenko Viktor on 26.09.2016.
 */
public abstract class Repository<T> {

    public Repository(Class<T> c) {
        this.c = c;
    }

    private final Class<T> c;

    private SqlSession session() {
        return MybatisUtil.session();
    }

    public Iterable<T> list() {
        try (SqlSession session = session()) {
            return mapper(session).list();
        }
    }

    protected abstract Mapper<T> mapper(SqlSession session);

    public T create(T object) {
        try (SqlSession session = session()) {
            mapper(session).create(object);
            session.commit();
            return object;
        }
    }

    public T get(Serializable id) {
        try (SqlSession session = session()) {
            return mapper(session).get(id);
        }
    }

    public T edit(T object) {
        try (SqlSession session = session()) {
            mapper(session).edit(object);
            session.commit();
            return object;
        }
    }

    public void delete(T object) {
        try (SqlSession session = session()) {
            mapper(session).delete(object);
            session.commit();
        }
    }
}
