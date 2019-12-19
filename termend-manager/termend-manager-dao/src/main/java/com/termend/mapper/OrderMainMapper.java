package com.termend.mapper;

import com.termend.common.Statistics;
import com.termend.common.sql.Query;
import com.termend.pojo.OrderMain;
import com.termend.pojo.OrderMainExample;
import java.util.List;


import org.apache.ibatis.annotations.Param;

public interface OrderMainMapper {
    int countByExample(OrderMainExample example);

    int deleteByExample(OrderMainExample example);

    int deleteByPrimaryKey(String id);

    int insert(OrderMain record);

    int insertSelective(OrderMain record);

    List<OrderMain> selectByExample(OrderMainExample example);

    OrderMain selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OrderMain record, @Param("example") OrderMainExample example);

    int updateByExample(@Param("record") OrderMain record, @Param("example") OrderMainExample example);

    int updateByPrimaryKeySelective(OrderMain record);

    int updateByPrimaryKey(OrderMain record);

	Statistics getStatistics(Query query);
}