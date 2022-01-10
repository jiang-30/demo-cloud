package org.jiang.combo.accretion.salute.controller;

import org.jiang.combo.accretion.salute.entity.Message;
import org.jiang.combo.accretion.salute.mapper.MessageMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/salute")
public class MessageController {

    @Resource
    MessageMapper messageMapper;

    @GetMapping("")
    public Message index(){
        Message message = messageMapper.selectByPrimaryKey(1);
        return message;
    }
}