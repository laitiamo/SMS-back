package com.zahory.studentmgsystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zahory.studentmgsystem.model.entity.MajorEntity;
import com.zahory.studentmgsystem.model.vo.response.table.MajorItemVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorMapper extends BaseMapper<MajorEntity> {
    Integer count(@Param("departmentName") String departmentName, @Param("name") String name);

    IPage<MajorItemVO> getPage(IPage<MajorItemVO> page, @Param("departmentName")String departmentName,@Param("name") String name);
}
