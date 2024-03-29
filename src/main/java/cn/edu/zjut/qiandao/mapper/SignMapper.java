package cn.edu.zjut.qiandao.mapper;

import cn.edu.zjut.qiandao.entity.Sign;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *
 * @author linyangze
 * @version 1.0
 */
@Repository
public interface SignMapper {
    /**
     *
     * @param openid 微信号
     * @param date 今日日期的字符串(yyyy-mm-dd)
     * @return 对应学生当日的签到信息
     */
    List<Sign> listDailySigns(@Param("openid")String openid,@Param("date")String date);

    /**
     * 查找学生某一个签到对应的月度签到信息
     * @param openid
     * @param date 当月日期 yyyy-mm%
     * @return 对应学生当月的签到信息
     */
    List<Sign> listMonthSigns(@Param("openid")String openid,@Param("date")String date,@Param("sign_id")Integer signId);

    /**
     * 查找学生当月需要的所有签到名称
     * @param openid
     * @param date
     * @return
     */
    List<Sign> listMonthSignNames(@Param("openid")String openid,@Param("date")String date);
}
