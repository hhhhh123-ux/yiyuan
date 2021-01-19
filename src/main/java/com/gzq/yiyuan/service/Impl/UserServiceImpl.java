package com.gzq.yiyuan.service.Impl;

import com.gzq.yiyuan.dao.TokenDao;
import com.gzq.yiyuan.dao.UserDao;
import com.gzq.yiyuan.entiy.User;
import com.gzq.yiyuan.entiy.token.Token;
import com.gzq.yiyuan.result.AjaxResult;
import com.gzq.yiyuan.service.UserService;
import com.gzq.yiyuan.utils.DateUtil;
import com.gzq.yiyuan.utils.RandomUtil;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import javax.annotation.Resource;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    @Resource
    TokenDao tokenDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        String date = DateUtil.getDateTime();
        record.setSalt(RandomUtil.random32());
        record.setCreatetime(sdf.parse(date));
        record.setEditetime(sdf.parse(date));
        record.setDeleted(true);
        record.setState(true);
        return userDao.insert(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }


    @Override
    public User selectByMobilePassword(String mobile, String password) {
        return userDao.selectByMobilePassword(mobile, password);
    }

    @Override
    public AjaxResult<User> login(String mobile, String password) {

        if (mobile == null && password == null) {
            return AjaxResult.failed("手机号和密码不能为空");
        }
        User user = userDao.selectByMobilePassword(mobile, password);
        if (user == null) {
            return AjaxResult.failed("手机号和密码错误");
        }
        //生成token
        return AjaxResult.success(operateToKen(user, user.getId()));
    }

    public String operateToKen(User user, Long id) {
        Token token = tokenDao.selectByPrimaryKey(id);
        String TokenStr = "";
        Date date = new Date();
        int nowTime = (int) (date.getTime() / 1000);
        TokenStr = creatToken(id, date);
        if (null == TokenStr) {
            token = new Token();
            token.setId(Long.valueOf(user.getMobile()));
            token.setUserid(id);
            token.setToken(TokenStr);
            tokenDao.insertSelective(token);
        }else {
            token.setToken(TokenStr);
            tokenDao.updateByPrimaryKey(token);
        }
        return TokenStr;
    }


    private String creatToken(Long userId, Date date) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                // 设置header
                .setHeaderParam("alg", "HS256").setIssuedAt(date)
                // 设置签发时间
                .setExpiration(new Date(date.getTime() + 1000 * 60 * 60))
                .claim("userId", String.valueOf(userId))
                // 设置内容
                .setIssuer("lws");
                // 设置签发;
        // 签名，需要算法和key
        String jwt = builder.compact();
        System.out.println(jwt);
        return jwt;
    }
}
