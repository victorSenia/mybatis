package com.leo.test.mybatis.util;

import com.leo.test.mybatis.controller.HomeController;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Senchenko Viktor on 26.09.2016.
 */
public class MybatisUtil {
    private static final SqlSessionFactory FACTORY;

    private static final Logger LOGGER = Logger.getLogger(MybatisUtil.class.getSimpleName());

    static {
        try {
            //            TODO SqlSessionFactory can be configured by java
            //            MysqlDataSource dataSource = new MysqlDataSource();
            //            dataSource.setURL("jdbc:mysql://titan/test?serverTimezone=UTC");
            //            dataSource.setPassword("ZbXUXsFYdVuysNG3");
            //            dataSource.setUser("win");
            //            TransactionFactory transactionFactory = new JdbcTransactionFactory();
            //            Environment environment = new Environment("development", transactionFactory, dataSource);
            //            Configuration configuration = new Configuration(environment);
             //            TODO but XML configuration of mappers has to be by the same path "com\leo\test\mybatis\mapper\BrowserMapper.xml" for example
            //            configuration.addMapper(com.leo.test.mybatis.mapper.BrowserMapper.class);
            //            FACTORY = new SqlSessionFactoryBuilder().build(configuration);

            FACTORY = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            LOGGER.log(Level.INFO, "more information about xml mapping available by link http://www.mybatis.org/mybatis-3/sqlmap-xml.html \n about annotation by link http://www.mybatis.org/mybatis-3/java-api.html");
        } catch (Throwable ex) {
            LOGGER.log(Level.SEVERE, "SqlSessionFactoryBuilder can't be created", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] args) {
        int delete = 112;
        HomeController controller = new HomeController();
        System.out.println(controller.get(delete));
        System.out.println(controller.edit(delete, "{\"browser\":\"testhhgj\", \"cssGrade\":\"test\", \"engine\":\"test\", \"engineVersion\":\"-\", \"platform\":\"-\"}"));
        System.out.println(controller.get(delete));
        controller.delete(delete);
        System.out.println(controller.create("{\"browser\":\"test\", \"cssGrade\":\"test\", \"engine\":\"test\", \"engineVersion\":\"-\", \"platform\":\"-\"}"));
        System.out.println(controller.list());
    }

    public static SqlSession session() {
        return FACTORY.openSession();
    }
}
