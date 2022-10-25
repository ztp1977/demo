package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ProjectMapper {
    Map<String, Object> getInfo(@Param("id") Integer id);

}
