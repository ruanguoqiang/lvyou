package com.liang.dao;

import com.liang.model.Flight;

public interface FlightMapper {
    int deleteByPrimaryKey(String flightnum);

    int insert(Flight record);

    int insertSelective(Flight record);

    Flight selectByPrimaryKey(String flightnum);

    int updateByPrimaryKeySelective(Flight record);

    int updateByPrimaryKey(Flight record);
}