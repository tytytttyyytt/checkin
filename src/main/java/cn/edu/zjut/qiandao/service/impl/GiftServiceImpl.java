package cn.edu.zjut.qiandao.service.impl;

import cn.edu.zjut.qiandao.constant.ErrorCode;
import cn.edu.zjut.qiandao.dao.GiftRespository;
import cn.edu.zjut.qiandao.dao.StudentGiftRespository;
import cn.edu.zjut.qiandao.dao.StudentScoreRespository;
import cn.edu.zjut.qiandao.dao.UserRepository;
import cn.edu.zjut.qiandao.dto.GiftDTO;
import cn.edu.zjut.qiandao.entity.Gift;
import cn.edu.zjut.qiandao.entity.Sign;
import cn.edu.zjut.qiandao.entity.StudentGift;
import cn.edu.zjut.qiandao.entity.StudentScore;
import cn.edu.zjut.qiandao.exception.SignException;
import cn.edu.zjut.qiandao.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * author: huangdan
 */
@Service
public class GiftServiceImpl implements GiftService {

    @Autowired
    GiftRespository giftRespository;
    @Autowired
    StudentGiftRespository studentGiftRespository;
    @Autowired
    StudentScoreRespository studentScoreRespository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Gift> getAllGift() {

        return giftRespository.findAll();
    }

    @Override
    public StudentScore getStudentScoreBystuId(String openid) {
        int studentid=userRepository.findByOpenid(openid).getStudentId();
        return studentScoreRespository.findByStudentId(studentid);
    }

    @Override
    public void updateScoreOfStudentScore(String openid, int score) {
        int studentid=userRepository.findByOpenid(openid).getStudentId();
        StudentScore studentScore=studentScoreRespository.findByStudentId(studentid);
        studentScore.setScore(score);
        studentScoreRespository.save(studentScore);
    }

    @Override
    public void insertIntoStudentGift(String openid, int giftId) {
        int studentid=userRepository.findByOpenid(openid).getStudentId();
        StudentGift studentGift=new StudentGift();
        studentGift.setStudentId(studentid);
        studentGift.setGiftId(giftId);
        studentGift.setResult(0);
        studentGiftRespository.save(studentGift);
    }

    @Override
    public Gift getGiftByGiftId(int giftId) {
        return giftRespository.findByGiftId(giftId);
    }

    @Override
    public void updateGift(Gift gift) {
        giftRespository.save(gift);
    }
    @Override
    @Transactional
    public void convertGift(String openid, List<GiftDTO> gifts){
        Integer studentId=userRepository.findByOpenid(openid).getStudentId();
        if(null==studentId)
            throw new SignException(ErrorCode.STUID_NOT_EXIST,"学号={}",studentId);
        int scores=0;
        for(GiftDTO g:gifts){
            //int giftId=g.getGiftId();
          //  System.out.println("giftId:"+g.getGiftId());
            Gift gift1=giftRespository.findByGiftId(g.getGiftId());
            int x=gift1.getGiftQuantity();//库存
            int cur_x=x-g.getGiftQuantity();//修改过后库存
            if (cur_x<0)
                //return Results.error(0,gift1.getGiftName()+"添加超出库存");
                throw new SignException(ErrorCode.QUANTITY_NOT_ENOUGH,"剩余库存={}",x);
            gift1.setGiftQuantity(cur_x);
            scores+=gift1.getGiftScore();
            giftRespository.save(gift1);
            StudentGift studentGift=new StudentGift();
            studentGift.setStudentId(studentId);
            studentGift.setGiftId(g.getGiftId());
            studentGift.setGiftQuantity(g.getGiftQuantity());
            studentGift.setResult(1);
            studentGiftRespository.save(studentGift);
        }

        StudentScore studentScore=studentScoreRespository.findByStudentId(studentId);
        int score=studentScore.getScore()-scores;
        if(score<0)
            throw new SignException(ErrorCode.SCORE_NOT_ENOUGH,"兑换后积分={}",score);
        studentScore.setScore(score);
        studentScoreRespository.save(studentScore);
      //  scoreCartService.updateScoreOfStudentScore(openid,score);
       // return Results.success(null);
    }
}
