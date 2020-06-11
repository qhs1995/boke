package com.hongshen.boke.controller;

import com.hongshen.boke.dao.object.ArticleDO;
import com.hongshen.boke.dao.object.UserDO;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.response.article.ArticleListResponse;
import com.hongshen.boke.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/11/7 17:50
 * @Desc: 博客文章
 */
@Controller
public class ArticleController {
    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    @Autowired
//    private RedisTemplate redisTemplate;


    @RequestMapping("/manager/article/queryList.html")
    @ResponseBody
    public ResultResponse<List<ArticleListResponse>> list(Integer page,Integer limit){
        ResultResponse<List<ArticleListResponse>> response = articleService.list(page,limit);
        return response;
    }

    /**
     *  添加或者编辑文章
     * @return
     */
    @RequestMapping("/manager/article/edit.html")
    @ResponseBody
    public ResultResponse<String> edit(@RequestBody ArticleDO articleDO){
        ResultResponse<String> response = articleService.edit(articleDO);
        return response;
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @RequestMapping("/manager/article/query.html")
    public String query(Model model,Integer id){
        ResultResponse<ArticleDO> response = articleService.query(id);
        model.addAttribute("article",response.getData());
        return "manager/article-query";
    }


    @RequestMapping("/manager/article/delete.html")
    @ResponseBody
    public ResultResponse<String> delete(Integer id){
        ResultResponse<String> response = articleService.delete(id);
        return response;
    }



    /**
     * 跳转到博客后台文章列表
     * @return
     */
    @RequestMapping("/manager/article/list.html")
    public String article(){
        return "manager/article-list";
    }
    @RequestMapping("/manager/article/article-edit.html")
    public String articleEdit(){
        return "manager/article-edit";
    }

//    @RequestMapping("/manager/redis.html")
//    public void redis(){
//        //redisTemplate
//        UserDO u = new UserDO();
//        u.setUsername("qian");
//        u.setName("钱洪申");
//        u.setQqNumber("1181254657");
//        u.setWechat("我是wechat");
//        u.setHeadPortrait("ssssssssssss");
//        u.setSignature("http/:ssssdsdewjhb.dads/dfdrwq.hg");
//        redisTemplate.opsForValue().set("user",u);
//        System.out.println("成了");
//        UserDO user = (UserDO)redisTemplate.opsForValue().get("user");
//        System.out.println(user.getName());
//    }
}
