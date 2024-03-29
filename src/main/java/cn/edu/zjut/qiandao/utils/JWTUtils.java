package cn.edu.zjut.qiandao.utils;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.Map;
 //import com.alibaba.druid.util.StringUtils;
 import cn.edu.zjut.qiandao.constant.ErrorCode;
 import cn.edu.zjut.qiandao.exception.SignException;
 import com.auth0.jwt.JWT;
 import com.auth0.jwt.JWTVerifier;
 import com.auth0.jwt.algorithms.Algorithm;
 import com.auth0.jwt.interfaces.Claim;
 import com.auth0.jwt.interfaces.DecodedJWT;
 public class JWTUtils {
     /**
      * APP登录Token的生成和解析
      *
      **/

     /**
      * token秘钥，请勿泄露，请勿随便修改 backups:JKKLJOoasdlfj
      */
     public static final String SECRET = "QWpLslLlbmLng";
     /**
      * token 过期时间: 1天
      */
     public static final int calendarField = Calendar.DATE;
     public static final int calendarInterval = 1;

     /**
      * JWT生成Token.<br/>
      * <p>
      * JWT构成: header, payload, signature
      *
      * @param openid 登录成功后用户小程序openid, 参数user_id不可传空 学号
      */
     public static String createToken(String openid) throws Exception {
         Date iatDate = new Date(); // expire time
         Calendar nowTime = Calendar.getInstance();
         nowTime.add(calendarField, calendarInterval);
         Date expiresDate = nowTime.getTime(); // header
         Map<String, Object> map = new HashMap<>();
         map.put("alg", "HS256");
         map.put("typ", "JWT"); // build token // param backups {iss:Service, aud:APP}
         String token = JWT.create().withHeader(map)
                 .withClaim("openid", openid)
                 .withIssuedAt(iatDate)
                 .withExpiresAt(expiresDate)
                 .sign(Algorithm.HMAC256(SECRET));
         return token;
     }
         /**
          * 解密Token
          *
          * @param token
          * @return
          * @throws Exception
          */
//         public static Map<String, Claim> verifyToken (String token)
//         {
//             DecodedJWT jwt = null;
//             try {
//                 JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
//                 jwt = verifier.verify(token);
//             } catch (Exception e) {
//                 // e.printStackTrace(); // token 校验失败, 抛出Token验证非法异常
//                 // } return jwt.getClaims();
//                 throw new SignException(ErrorCode.TOKEN_INVALID,"token={}",token);
//
//             }
//             return jwt.getClaims();
//         }
         /**
          * 根据Token获取user_id
          *
          * @param token
          * @return user_id
          */

     public static String  getOpenid(String token) {
//         Map<String, Claim> claims = verifyToken(token);
//         Claim openid_claim = claims.get("openid");
//         return openid_claim.asString();
         return "oasdN5Sp6g4EgnosuoG7adCR060g";
     }
 }