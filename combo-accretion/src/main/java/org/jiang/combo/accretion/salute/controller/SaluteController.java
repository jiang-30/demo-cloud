package org.jiang.combo.accretion.salute.controller;

import com.github.pagehelper.PageInfo;
import org.jiang.combo.accretion.salute.entity.Message;
import org.jiang.combo.accretion.salute.entity.Salute;
import org.jiang.combo.accretion.salute.service.MessageService;
import org.jiang.combo.accretion.salute.service.SaluteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/salute")
public class SaluteController {

    @Resource
    HttpServletRequest req;

    @Resource
    MessageService messageService;

    @Resource
    SaluteService saluteService;

    String getIp(){
        String ip = req.getRemoteAddr();
        if(ip == null ) {
          ip = req.getHeader("X-Forwarded-For");
        } else if(ip == null) {
          ip = req.getHeader("X-Real-IP");
        }
        return ip;
    }


//    {
//        status: { code: 200, message: '成功' },
//        data: res.data,
//        page: { total: res.total, current: query.current, size: query.size },
//    }
    @GetMapping("/salute/count")
    public Integer getCount(){
        Integer count = saluteService.getSaluteCount();
        return  count;
    }

    @GetMapping("/salute")
    public Integer createCount(Salute salute){
        salute.setHost(getIp());
        Integer count = saluteService.createSalute(salute);
        return count;
    }

    @GetMapping("/message/page")
    public PageInfo getMessagePage(Integer current, Integer size){
        if(current == null) {
            current = 1;
        }
        if(size == null) {
            size = 10;
        }
        PageInfo pageInfo = messageService.getMessagePage(current, size);
        return pageInfo;
    }

    @PostMapping("/message")
    public Integer createMessage(Message message){
        Integer count = messageService.createMessage(message);
        return count;
    }
}
