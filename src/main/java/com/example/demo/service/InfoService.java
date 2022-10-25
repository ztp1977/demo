package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface InfoService {

    int infoSplitTable();

    int saveInfo(String key, String vlaue);

    int updateInfo(String key, String vlaue, Integer id);

    Map<String, Object> getInfo(int id);

    int delInfo(int id);
}
