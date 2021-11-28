package com.example.jwt3.interceptors;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.jwt3.exception.BusinessException;
import com.example.jwt3.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Chilly Cui on 2020/9/9.
 */
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler){

        //获取请求头中的令牌
        String token = request.getHeader("token");
        //log.info("当前token为：{}", token);
//        if(null == token) {
//            throw new NullPointerException("token为空");
//        }
//
//        try {
//            JWTUtils.verify(token);
//            return true;
//        } catch (SignatureVerificationException e) {
//            //e.printStackTrace();
//            throw new RuntimeException("签名不一致");
//        } catch (TokenExpiredException e) {
//            //e.printStackTrace();
//            throw new RuntimeException("令牌过期");
//        } catch (AlgorithmMismatchException e) {
//            //e.printStackTrace();
//            throw new RuntimeException("算法不匹配");
//        } catch (InvalidClaimException e) {
//            //e.printStackTrace();
//            throw new InvalidClaimException("失效的payload");
//        } catch (Exception e) {
//            //e.printStackTrace();
//            throw new RuntimeException("token无效");
//        }
        if(null == token) {
            throw new BusinessException("token为空");
        }

        try {
            JWTUtils.verify(token);
            return true;
        } catch (SignatureVerificationException e) {
            //e.printStackTrace();
            throw new BusinessException("签名不一致");
        } catch (TokenExpiredException e) {
            //e.printStackTrace();
            throw new BusinessException("令牌过期");
        } catch (AlgorithmMismatchException e) {
            //e.printStackTrace();
            throw new BusinessException("算法不匹配");
        } catch (InvalidClaimException e) {
            //e.printStackTrace();
            throw new BusinessException("失效的payload");
        } catch (Exception e) {
            //e.printStackTrace();
            throw new BusinessException("token无效");
        }
    }
}
