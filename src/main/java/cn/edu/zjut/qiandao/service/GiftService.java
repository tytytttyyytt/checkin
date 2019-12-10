package cn.edu.zjut.qiandao.service;

import cn.edu.zjut.qiandao.dto.GiftDTO;
import cn.edu.zjut.qiandao.entity.Gift;
import cn.edu.zjut.qiandao.entity.StudentScore;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
/**
 * author: huangdan
 */
public interface GiftService {
    /**
     * 得到所有的礼物显示在页面
     * @return
     */
    List<Gift> getAllGift();

    /**
     * 根据学生id查询出学生的积分
     * @param openid
     * @return
     */
    StudentScore getStudentScoreBystuId(String openid);

    /**
     * 更新学生的积分信息
     * @param score
     */
    void updateScoreOfStudentScore(String openid,int score);

    /**
     * 把信息插入到StudentGift表中
     * @param openid
     * @param giftId
     */
    void insertIntoStudentGift(String  openid,int giftId );

    /**
     * 由礼物号获得对应的礼物
     * @param giftId
     * @return
     */
    Gift getGiftByGiftId(int giftId);

    /**\
     * 将礼物库存更新
     * @param gift
     */
    void updateGift(Gift gift);

    /**
     * 兑换礼物
     * @param openid
     * @param gifts
     */
    void convertGift(String openid, List<GiftDTO> gifts);
}
