package com.org.codell.dmg.mapper;

import com.org.codell.dmg.model.UmsRelationRoleResource;
import com.org.codell.dmg.model.UmsRelationRoleResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsRelationRoleResourceMapper {
    long countByExample(UmsRelationRoleResourceExample example);

    int deleteByExample(UmsRelationRoleResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsRelationRoleResource record);

    int insertSelective(UmsRelationRoleResource record);

    List<UmsRelationRoleResource> selectByExample(UmsRelationRoleResourceExample example);

    UmsRelationRoleResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsRelationRoleResource record, @Param("example") UmsRelationRoleResourceExample example);

    int updateByExample(@Param("record") UmsRelationRoleResource record, @Param("example") UmsRelationRoleResourceExample example);

    int updateByPrimaryKeySelective(UmsRelationRoleResource record);

    int updateByPrimaryKey(UmsRelationRoleResource record);
}