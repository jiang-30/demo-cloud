package org.jiang.combo.accretion.salute.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.jiang.combo.accretion.salute.entity.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    Message selectByPrimaryKey(Integer id);

    List<Message> selectAll();

    int updateByPrimaryKey(Message record);

    List<Message> selectPage();
}