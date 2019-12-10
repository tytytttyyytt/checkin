package cn.edu.zjut.qiandao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO {
    Integer autoid;
    String title;
    String content;
    String createTime;
    String teacherName;
}
