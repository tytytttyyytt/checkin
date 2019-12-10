package cn.edu.zjut.qiandao.constant;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum  ErrorCode {
    FACE_NOT_FOUND(10001,"未识别出人脸"),
    STUID_NOT_EXIST(10002,"学号不存在"),
    STUID_NOT_FOUND(10003,"学号为空"),
    STUID_OR_SIGNINSTANCEID_NULL(10004,"学号或者签到号为空"),
    CODE_ERROR(10005,"code异常"),
    SIGNSIMILARY_ERROR(10006,"相似度错误"),
    FILE_NOT_FOUND(10007,"上传文件为空"),
    SIGN_FAIL(10008,"识别失败，不是同一个人"),
    OPENID_NOT_NULL(10009,"用户openid为空"),
    SUGGEST_NOT_NULL(10010,"建议不能为空"),
    TOKEN_NOT_EXIST(10011,"认证异常"),
    TOKEN_INVALID(10012,"TOKEN非法"),
    NAME_OR_PASSWORD_ERROR(10013, "姓名或密码错误！"),
    QUANTITY_NOT_ENOUGH(10014,"数量超出库存"),
    SCORE_NOT_ENOUGH(10015,"积分不足"),
    SIGN_TIME_ERROR(10016,"签到时间非法");

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private int code;
    private String message;
}
