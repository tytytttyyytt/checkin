package cn.edu.zjut.qiandao.service.impl;

import cn.edu.zjut.qiandao.constant.ErrorCode;
import cn.edu.zjut.qiandao.dao.SignInstanceRespository;
import cn.edu.zjut.qiandao.dao.StudentSignRepository;
import cn.edu.zjut.qiandao.dao.UserRepository;
import cn.edu.zjut.qiandao.dto.MonthlySignNameDTO;
import cn.edu.zjut.qiandao.dto.MonthlySignDTO;
import cn.edu.zjut.qiandao.dto.SignInstanceDTO;
import cn.edu.zjut.qiandao.dto.StudentDTO;
import cn.edu.zjut.qiandao.entity.Sign;
import cn.edu.zjut.qiandao.entity.SignInstance;
import cn.edu.zjut.qiandao.entity.Student;
import cn.edu.zjut.qiandao.entity.StudentSign;
import cn.edu.zjut.qiandao.exception.SignException;
import cn.edu.zjut.qiandao.mapper.SignMapper;
import cn.edu.zjut.qiandao.mapper.StudentMapper;
import cn.edu.zjut.qiandao.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    SignMapper signMapper;
    @Autowired
    StudentSignRepository studentSignRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SignInstanceRespository signInstanceRespository;
    @Override
    public StudentDTO getStudentInfo(String openid){
        StudentDTO studentDTO=new StudentDTO();
        if(null==openid)
            throw new SignException(ErrorCode.OPENID_NOT_NULL,"openid={}",openid);
        Student student=studentMapper.getStudentInfo(openid);
        if(null==student)
            throw new SignException(ErrorCode.STUID_NOT_EXIST,"stuid={}",student.getStudentId());
        BeanUtils.copyProperties(student,studentDTO);
        return studentDTO;
    }

    @Override
    public List<Sign> getDailySigns(String openid, String date) {
        int studentid=userRepository.findByOpenid(openid).getStudentId();
        List<Sign> list=signMapper.listDailySigns(openid, date);
        Sign sign;
        for(int i=0;i<list.size();i++){
            sign=list.get(i);
            StudentSign studentSign=studentSignRepository.findBySigninstanceIdAndStudentId(sign.getSignInstanceId(),studentid);
              sign.setStatus(studentSign.getStatus());
        }
        return list;
    }

    @Override
    public List<MonthlySignDTO> getMonthSigns(String openid, String month,Integer signId) {
        month=month+"%";//传过来yyyy-mm格式，数据库模糊查找需要%匹配
      //  System.out.println(month);
      //  System.out.println(openid);
        int studentid=userRepository.findByOpenid(openid).getStudentId();
       // System.out.println(studentid);
        List<Sign> list=signMapper.listMonthSigns(openid, month,signId);
      //  System.out.println("签到数据长度:"+list.size());
        Sign sign;

        List<MonthlySignDTO> monthlySignDTOs=new ArrayList<MonthlySignDTO>();
        for(int i=0;i<list.size();i++){
            MonthlySignDTO monthlySignDTO=new MonthlySignDTO();
            sign=list.get(i);
            StudentSign studentSign=studentSignRepository.findBySigninstanceIdAndStudentId(sign.getSignInstanceId(),studentid);
            sign.setStatus(studentSign.getStatus());
          //  System.out.println(sign.getDate());
            BeanUtils.copyProperties(sign,monthlySignDTO);
         //   System.out.println("dto:"+monthlySignDTO.getDate());
            monthlySignDTOs.add(monthlySignDTO);
        //    System.out.println(monthlySignDTOs.get(i).getDate());
        }
      //  for (int i=0;i<monthlySignDTOs.size();i++)
       //     System.out.println("list:("+i+")"+(monthlySignDTOs.get(i)).getDate());
        return monthlySignDTOs;
    }

    @Override
    public List<MonthlySignNameDTO> getMonthSignNames(String openid, String month) {
        month=month+"%";//传过来yyyy-mm格式，数据库模糊查找需要%匹配
       List<Sign> list=signMapper.listMonthSignNames(openid,month);
       List<MonthlySignNameDTO> monthlySignNameDTOS =new ArrayList<MonthlySignNameDTO>() ;
       for(int i=0;i<list.size();i++)
       {
           MonthlySignNameDTO monthlySignNameDTO =new MonthlySignNameDTO();
           BeanUtils.copyProperties(list.get(i), monthlySignNameDTO);
           monthlySignNameDTOS.add(monthlySignNameDTO);
       }
       return monthlySignNameDTOS;
    }

    @Override
    public SignInstanceDTO getSignLocation(Integer signInstanceId) {
        SignInstance signInstance=signInstanceRespository.getOneBySigninstanceId(signInstanceId);
        SignInstanceDTO signInstanceDTO=new SignInstanceDTO();
        if(null!=signInstance)
        {
            signInstanceDTO.setLatitude(Double.parseDouble(signInstance.getLatitude()));
            signInstanceDTO.setLongitude(Double.parseDouble(signInstance.getLongitude()));
            signInstanceDTO.setRadius(signInstance.getRadius());
        }
        return signInstanceDTO;
    }
}
