package cn.edu.zjut.qiandao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gift")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gift {
    @Id
    @GeneratedValue
    Integer giftId;
    String giftName;
    String giftDescript;
    String giftImg;
    Integer giftScore;
    Integer giftQuantity;
}
