package com.tester.mybatis.dao;

import com.tester.mybatis.pojo.Transfercase;
import com.tester.mybatis.pojo.TransfercaseExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TransfercaseMapper {
    int countByExample(TransfercaseExample example);

    int deleteByExample(TransfercaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(Transfercase record);

    int insertSelective(Transfercase record);

    List<Transfercase> selectByExample(TransfercaseExample example);

    Transfercase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Transfercase record, @Param("example") TransfercaseExample example);

    int updateByExample(@Param("record") Transfercase record, @Param("example") TransfercaseExample example);

    int updateByPrimaryKeySelective(Transfercase record);

    int updateByPrimaryKey(Transfercase record);
}