package cn.edu.zjut.qiandao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlySignDTO {
    Integer signInstanceId;
    Integer status;
    String date;
}
