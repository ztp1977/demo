package com.example.demo.service.impl;

import com.example.demo.mapper.InfoMapper;
import com.example.demo.service.InfoService;
import com.example.demo.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public int infoSplitTable() {
        String uuid = null;
        int num = 0;
        for(int i=0; i<6; i++) {
            uuid = Utils.generateUUID();
            System.out.println(uuid);
            if(!StringUtils.isEmpty(uuid)) {
                num = Integer.parseInt(String.valueOf(uuid.charAt(0)), 16) % 3;
                infoMapper.saveTableInfo("test_"+num, uuid, "test");
            }
        }
        return 0;
    }

    @Override
    public int updateInfo(String key, String value, Integer id) {
        return infoMapper.updateInfo(key, value, id);
    }

    @Override
    public int saveInfo(String key, String value) {
        return infoMapper.saveInfo(key, value);
    }

    @Override
    public Map<String, Object> getInfo(int id) {
        return infoMapper.getInfo(id);
    }

    @Override
    public int delInfo(int id) {
        return infoMapper.delInfo(id);
    }
}
