package cn.edu.zjut.qiandao.service.impl;

import cn.edu.zjut.qiandao.dao.GiftRespository;
import cn.edu.zjut.qiandao.entity.Gift;
import cn.edu.zjut.qiandao.service.BackstageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
public class BackstageServiceImpl implements BackstageService {
    @Autowired
    GiftRespository giftRespository;
    @Value("${back.giftuploadurl}")
    String  gifturl;
    @Value("${back.giftuploadpath}")
    String giftpath;
    @Override
    public void saveGift(Gift gift, MultipartFile file)throws Exception {
        if(null!=file)
        {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String filename = giftpath + uuid + ".jpg";
            //    log.info("the file register path is"+filename);
            File saveFile = new File(filename);
            //    File saveFile = new File();
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
            out.write(file.getBytes());
            out.flush();
            out.close();
            gift.setGiftImg(gifturl+uuid+".jpg");
            giftRespository.save(gift);
        }else {
            giftRespository.save(gift);
        }
    }
}
