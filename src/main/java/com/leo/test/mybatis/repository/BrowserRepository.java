package com.leo.test.mybatis.repository;

import com.leo.test.mybatis.mapper.BrowserMapper;
import com.leo.test.mybatis.mapper.Mapper;
import com.leo.test.mybatis.model.Browser;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by Senchenko Viktor on 27.09.2016.
 */
public class BrowserRepository extends Repository<Browser> {

    public BrowserRepository() {
        super(Browser.class);
    }

    @Override
    protected Mapper<Browser> mapper(SqlSession session) {
        return session.getMapper(BrowserMapper.class);
    }
}
