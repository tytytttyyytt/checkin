package cn.edu.zjut.qiandao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="student_gift")
@Data
public class StudentGift {
    @Id
    @GeneratedValue
    int autoid;
    int studentId;
    int giftId;
    int result;
    @Column(name="quantity")
    int giftQuantity;

}
