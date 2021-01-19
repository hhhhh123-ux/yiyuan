package com.gzq.yiyuan.service.token;

import com.gzq.yiyuan.entiy.token.Token;


import java.util.Date;


public interface TokenService {
    Token createToken(Long id, Date date);
}
