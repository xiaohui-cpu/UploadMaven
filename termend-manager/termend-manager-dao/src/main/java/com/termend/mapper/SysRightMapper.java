package com.termend.mapper;

import com.termend.pojo.SysRight;
import com.termend.pojo.SysRightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRightMapper {
    int countByExample(SysRightExample example);

    int deleteByExample(SysRightExample example);

    int deleteByPrimaryKey(String rightCode);

    int insert(SysRight record);

    int insertSelective(SysRight record);

    List<SysRight> selectByExample(SysRightExample example);

    SysRight selectByPrimaryKey(String rightCode);

    int updateByExampleSelective(@Param("record") SysRight record, @Param("example") SysRightExample example);

    int updateByExample(@Param("record") SysRight record, @Param("example") SysRightExample example);

    int updateByPrimaryKeySelective(SysRight record);

    int updateByPrimaryKey(SysRight record);
}