package cn.edu.zjut.qiandao.mapper;

import cn.edu.zjut.qiandao.dto.NoticeDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {
    /**
     * 获取某个openid对应学生的消息内容
     * @param student_id
     * @param openid
     * @return
     */
    List<NoticeDTO> listUnreadNotice(@Param("studentId") Integer student_id, @Param("openid") String openid);
}
