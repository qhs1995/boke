package com.hongshen.boke.service;


import com.hongshen.boke.dao.object.UserDO;
import com.hongshen.boke.response.ResultResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * author:qianhongshen
 * Date:2018/10/12
 * Time:15:09
 */
public interface UserService {

    ResultResponse<UserDO> login(UserDO userDO);

    ResultResponse<String> out();

    ResultResponse<List<UserDO>> list(Integer page,Integer limit);

    ResultResponse<UserDO> query(Integer id);

    ResultResponse<String> edit( UserDO userDO);

    ResultResponse<String> delete(Integer id);

    UserDO queryUser();


    String updateHead(MultipartFile file);
}
