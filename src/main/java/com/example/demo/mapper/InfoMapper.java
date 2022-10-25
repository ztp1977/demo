package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface InfoMapper {

    int saveTableInfo(@Param("table") String table,
                      @Param("key") String key,
                      @Param("value") String value);

    int saveInfo(@Param("key") String key,
                 @Param("value") String value);

    int updateInfo(@Param("key") String key,
                   @Param("value") String value,
                   @Param("id") Integer id);

    Map<String, Object> getInfo(@Param("id") Integer id);

    int delInfo(@Param("id") Integer id);
}
