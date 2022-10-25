package com.example.demo.controller;

import com.example.demo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

@Controller
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping(value = "/infoSplitTable", method = RequestMethod.GET)
    @ResponseBody
    public int infoSplitTable() {
        return infoService.infoSplitTable();
    }

    @RequestMapping(value="/updateInfo", method = RequestMethod.POST)
    @ResponseBody
    public int updateInfo(String key, String value, Integer id) {
        return infoService.updateInfo(key, value, id);
    }

    @RequestMapping(value="/saveInfo", method = RequestMethod.POST)
    @ResponseBody
    public int saveInfo(String key, String value) {
        return infoService.saveInfo(key, value);
    }

    @RequestMapping(value="/delInfo", method = RequestMethod.POST)
    @ResponseBody
    public int delInfo(Integer id) {
        return infoService.delInfo(id);
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getInfo(Integer id) {
        return infoService.getInfo(id);
    }
}
