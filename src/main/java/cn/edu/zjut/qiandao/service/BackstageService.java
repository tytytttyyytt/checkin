package cn.edu.zjut.qiandao.service;

import cn.edu.zjut.qiandao.entity.Gift;
import org.springframework.web.multipart.MultipartFile;

public interface BackstageService {
    /**
     * 为web端添加、修改gift作ajax后台支持
     * @param gift
     * @param file
     * @throws Exception
     */
    void saveGift(Gift gift, MultipartFile file) throws Exception;
}
