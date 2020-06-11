package com.hongshen.boke.controller;

import com.hongshen.boke.dao.object.TouristDO;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.service.TouristService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/11/9 14:28
 * @Desc: 游客
 */
@Controller
public class TouristController {
    private static final Logger logger = LoggerFactory.getLogger(TouristController.class);

    @Autowired
    private TouristService touristService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 游客新增或修改接口
     * @param touristDO
     * @return
     */
    @RequestMapping("/manager/toutist/edit.html")
    @ResponseBody
    public ResultResponse<String> edit(@RequestBody TouristDO touristDO){
        ResultResponse<String> response = touristService.edit(touristDO);
        return response;
       // return ResultResponse.successResponse("成功",null);
    }

    @RequestMapping("/manager/toutist/delete.html")
    @ResponseBody
    public ResultResponse<String> delete( Integer id){
        ResultResponse<String> response = touristService.delete(id);
        return response;
    }

    @RequestMapping("/manager/toutist/query.html")
    public String query(Model model,Integer id){
        ResultResponse<TouristDO> response = touristService.query(id);
        model.addAttribute("tourist",response.getData());
        return "manager/tourist-query.html";
    }
    @RequestMapping("/manager/toutist/queryList.html")
    @ResponseBody
    public ResultResponse<List<TouristDO>> list(Integer page,Integer limit, String username){
        ResultResponse<List<TouristDO>> response = touristService.list(page,limit,username);
        return response;
    }

    /**
     * 游客登录
     * @return
     */
    @RequestMapping("/manager/toutist/login.html")
    @ResponseBody
    public ResultResponse<TouristDO> login(HttpServletRequest request , @RequestBody Map<String,String> map){
        String username = map.get("username");
        String password = map.get("password");
        ResultResponse<TouristDO> response = touristService.login(username,password);
        TouristDO aDo = response.getData();
        //request.setAttribute("tourist",aDo);
        request.getSession().setAttribute("tourist",aDo);
        return response;
    }


    @RequestMapping("/manager/tourist/list.html")
    public String tourist(){
        return "manager/tourist-list";
    }
    @RequestMapping("manager/tourist-edit.html")
    public String touristEdit(){
        return "manager/tourist-edit.html";
    }

}
