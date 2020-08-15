package com.org.codell.dmg.mapper;

import com.org.codell.dmg.model.UmsRelationRoleMenu;
import com.org.codell.dmg.model.UmsRelationRoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsRelationRoleMenuMapper {
    long countByExample(UmsRelationRoleMenuExample example);

    int deleteByExample(UmsRelationRoleMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsRelationRoleMenu record);

    int insertSelective(UmsRelationRoleMenu record);

    List<UmsRelationRoleMenu> selectByExample(UmsRelationRoleMenuExample example);

    UmsRelationRoleMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsRelationRoleMenu record, @Param("example") UmsRelationRoleMenuExample example);

    int updateByExample(@Param("record") UmsRelationRoleMenu record, @Param("example") UmsRelationRoleMenuExample example);

    int updateByPrimaryKeySelective(UmsRelationRoleMenu record);

    int updateByPrimaryKey(UmsRelationRoleMenu record);
}