package com.liang.dao;

import com.liang.model.Transfor;

public interface TransforMapper {
    int deleteByPrimaryKey(String carnum);

    int insert(Transfor record);

    int insertSelective(Transfor record);

    Transfor selectByPrimaryKey(String carnum);

    int updateByPrimaryKeySelective(Transfor record);

    int updateByPrimaryKey(Transfor record);
}