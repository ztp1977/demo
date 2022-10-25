package com.example.demo.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static final Logger log = Logger.getLogger(MybatisUtil.class.getSimpleName());

    /**
     * MyBatis配置文件路径
     */
    private static final String MYBATIS_CONFIG_PATH = "mybatis-config.xml";

    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> localSessions = new ThreadLocal<>();

    /**
     * 加载并解析配置文件
     */
    static {
        try(
                InputStream in = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH)
        ) {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(in);
        } catch (IOException e) {
            log.error("SqlSessionFactory init error", e);
        }
    }

    /**
     * 常见会话
     * @return
     */
    public static SqlSession getSession(){
        SqlSession sqlSession = localSessions.get();
        if (sqlSession == null){
            sqlSession = factory.openSession();
            localSessions.set(sqlSession);
        }

        if (sqlSession == null){
            log.error("#getSession error, session is nulll");
        } else {
            log.info("#getSession successfully");
        }

        return sqlSession;
    }

    /**
     * 销毁会话
     */
    public static void closeSession(){
        SqlSession sqlSession = localSessions.get();
        if (sqlSession != null){
            sqlSession.close();
            localSessions.remove();
        }
        log.info("#closeSession successfully");
    }
}
