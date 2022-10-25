package com.example.demo;

import com.example.demo.mapper.ProjectMapper;
import com.example.demo.util.MybatisUtil;
import org.apache.ibatis.ognl.ObjectElementsAccessor;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.platform.commons.util.CollectionUtils;

import java.util.Map;

public class ProjectMapperTests {

        private static final Logger log = Logger.getLogger(ProjectMapperTests.class.getSimpleName());
        private SqlSession sqlSession;
        private ProjectMapper projectDao;

        @Before
        public void setUp() throws Exception{
            log.info("#setUp start...");
            sqlSession = MybatisUtil.getSession();
            projectDao = sqlSession.getMapper(ProjectMapper.class);
        }

        @Test
        public void testSelectProjectsByUserName(){
            Map<String, Object> projects = projectDao.getInfo(799);
//            Map<String, Object> tmp = new Map<String, Object>() {
//            }
            //Assert.assertTrue(CollectionUtils.isNotEmpty(projects));
        }

        @After
        public void tearDown() throws Exception{
            log.info("#tearDown start...");
            sqlSession.commit();
            MybatisUtil.closeSession();
        }

}
