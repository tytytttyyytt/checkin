package cn.edu.zjut.qiandao.dao;


import cn.edu.zjut.qiandao.entity.StudentNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentNoticeRespository extends JpaRepository<StudentNotice,Integer> {
    StudentNotice getOneByAutoid(Integer autoid);
}
