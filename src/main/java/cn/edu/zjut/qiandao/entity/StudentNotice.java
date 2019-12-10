package cn.edu.zjut.qiandao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentNotice {
    @Id
    @GeneratedValue
    Integer autoid;
    Integer noticeId;
    Integer studentId;
    String openid;
    Integer status;
    String createtime;
}
