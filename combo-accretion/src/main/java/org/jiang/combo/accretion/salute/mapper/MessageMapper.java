package org.jiang.combo.accretion.salute.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.jiang.combo.accretion.salute.entity.Message;

@Mapper
public interface MessageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated Sun Jan 09 11:32:47 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated Sun Jan 09 11:32:47 CST 2022
     */
    int insert(Message record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated Sun Jan 09 11:32:47 CST 2022
     */
    Message selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated Sun Jan 09 11:32:47 CST 2022
     */
    List<Message> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table message
     *
     * @mbg.generated Sun Jan 09 11:32:47 CST 2022
     */
    int updateByPrimaryKey(Message record);
}