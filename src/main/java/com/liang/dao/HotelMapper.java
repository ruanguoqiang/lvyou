package com.liang.dao;

import com.liang.model.Hotel;

public interface HotelMapper {
    int deleteByPrimaryKey(String hotelnum);

    int insert(Hotel record);

    int insertSelective(Hotel record);

    Hotel selectByPrimaryKey(String hotelnum);

    int updateByPrimaryKeySelective(Hotel record);

    int updateByPrimaryKey(Hotel record);
}