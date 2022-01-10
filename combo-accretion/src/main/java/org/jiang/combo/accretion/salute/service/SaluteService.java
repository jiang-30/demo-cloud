package org.jiang.combo.accretion.salute.service;

import org.jiang.combo.accretion.salute.entity.Salute;
import org.jiang.combo.accretion.salute.mapper.SaluteMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SaluteService {

    @Resource
    SaluteMapper saluteMapper;

    public Integer getSaluteCount() {
        int count = saluteMapper.selectCount();
        return  count;
    }

    public Integer createSalute(Salute salute) {
        Integer count = saluteMapper.insert(salute);
        return  count;
    }
}
