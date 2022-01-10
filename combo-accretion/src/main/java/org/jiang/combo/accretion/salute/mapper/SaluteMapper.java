package org.jiang.combo.accretion.salute.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.jiang.combo.accretion.salute.entity.Salute;

public interface SaluteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salute record);

    Salute selectByPrimaryKey(Integer id);

    List<Salute> selectAll();

    int updateByPrimaryKey(Salute record);

    int selectCount();
}