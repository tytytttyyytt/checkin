package cn.edu.zjut.qiandao.dao;


import cn.edu.zjut.qiandao.entity.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface StudentScoreRespository extends JpaRepository<StudentScore,Integer> {
    StudentScore findByStudentId(int studentId);
    @Query("update StudentScore ss set ss.score=ss.score-?1 ")
    void updateScore(Integer score);
    @Transactional
    @Modifying
    @Query("update StudentScore ss set ss.score=ss.score+?1 where ss.studentId=?2")
    void addSignScore(Integer score,Integer studentId);
}
