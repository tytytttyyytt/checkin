package cn.edu.zjut.qiandao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_score")
@Data
public class StudentScore {
    @Id
    int studentId;
    int score;

}
