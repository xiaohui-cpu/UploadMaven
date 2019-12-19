package com.termend.mapper;

import com.termend.pojo.Disk;
import com.termend.pojo.DiskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiskMapper {
    int countByExample(DiskExample example);

    int deleteByExample(DiskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Disk record);

    int insertSelective(Disk record);

    List<Disk> selectByExample(DiskExample example);

    Disk selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Disk record, @Param("example") DiskExample example);

    int updateByExample(@Param("record") Disk record, @Param("example") DiskExample example);

    int updateByPrimaryKeySelective(Disk record);

    int updateByPrimaryKey(Disk record);
}