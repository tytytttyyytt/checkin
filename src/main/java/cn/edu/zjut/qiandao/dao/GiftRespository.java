package cn.edu.zjut.qiandao.dao;

import cn.edu.zjut.qiandao.entity.Gift;
import cn.edu.zjut.qiandao.entity.SignInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRespository extends JpaRepository<Gift,Integer> {
    Gift findByGiftId(int gifyId);
}
