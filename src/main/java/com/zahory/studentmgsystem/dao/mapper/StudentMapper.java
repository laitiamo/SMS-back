package com.zahory.studentmgsystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zahory.studentmgsystem.model.entity.StudentEntity;
import com.zahory.studentmgsystem.model.vo.response.StudentInfoVO;
import com.zahory.studentmgsystem.model.vo.response.table.StudentItemVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper extends BaseMapper<StudentEntity> {
    Integer getDepartmentIdById(Integer studentId);

    Integer getGradeById(Integer studentId);

    Integer count(@Param("majorName")String majorName,@Param("className") String className, @Param("name")String name);

    IPage<StudentItemVO> getPage(IPage<StudentItemVO> page, @Param("majorName")String majorName,@Param("className") String className,@Param("name") String name);

    StudentInfoVO getStudentInfoById(Integer studentId);
}
