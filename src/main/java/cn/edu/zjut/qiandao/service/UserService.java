package cn.edu.zjut.qiandao.service;

import cn.edu.zjut.qiandao.dto.*;

import java.util.List;

public interface UserService {
     /**
      * 登录
      * @param login
      * @return 带有openid的token
      * @throws Exception
      */
     UserDTO login(Login login)throws Exception;

     /**
      * 将学号和openid绑定
      * @param binding
      * @param openid
      * @throws Exception
      */
     void binding(Binding binding, String openid)throws Exception;
    // StudentDTO getStudentInfo(String openid);

     /**
      * 上传建议
      * @param openid
      * @param suggest
      */
     void addSuggest(String openid,String suggest);

     /**
      * 将通知设置为已读
      * @param noticeId
      */
     void readNotice(Integer noticeId);

     /**
      * 获取通知
      * @param openid
      */
     List<NoticeDTO> getNotice(String openid);
}
