package com.hongshen.boke.controller.before;

import com.hongshen.boke.dao.object.*;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.response.article.ArticleListResponse;
import com.hongshen.boke.response.comments.CommentsResponse;
import com.hongshen.boke.service.*;
import com.hongshen.boke.utils.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/11/13 18:08
 * @Desc: 前台博客
 */
@Controller
public class MyBokeController {
    private static final Logger logger = LoggerFactory.getLogger(MyBokeController.class);


    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ColumnService columnService;

    @Autowired
    private TouristService touristService;

    @Autowired
    private CommentsService commentsService;

    /**
     * 首页
     */
    @RequestMapping("/boke.html")
    public String index(Model model,HttpServletRequest request){
        String serverName = request.getServerName();
        System.out.println(serverName+"---------------------------");
        logger.info("域名路径为======="+serverName+"================================");
        UserDO user = userService.queryUser();
        ResultResponse<List<ArticleListResponse>> response = articleService.list(1, 10);
        ResultResponse<List<ColumnDO>> parentColumn = columnService.queryParentColumn(null);
        ResultResponse<List<ColumnDO>> allChildColumn = columnService.queryAllChildColumn();
        model.addAttribute("user",user);
        model.addAttribute("articleList",response.getData());
        model.addAttribute("parentColumn",parentColumn.getData());
        model.addAttribute("allChildColumn",allChildColumn.getData());
        return "before/index";
    }

    /**
     * 首页展示文章列表
     */
    @RequestMapping("/article/list.html")
    @ResponseBody
    public ResultResponse<List<ArticleListResponse>> list(Model model,Integer page){
        ResultResponse<List<ArticleListResponse>> response = articleService.list(page, 10);
        return response;
    }

    /**
     * 文章详情
     * @param model
     * @param id 文章id
     * @return 文章详情页
     */
    @RequestMapping("/article/detail.html")
    public String queryArticle(Model model,Integer id){
        ResultResponse<ArticleDO> response = articleService.query(id);
        UserDO user = userService.queryUser();
        ResultResponse<List<CommentsResponse>> CommentsDOResponse = commentsService.findByarticleId(id);
        ResultResponse<List<ColumnDO>> parentColumn = columnService.queryParentColumn(null);
        ResultResponse<List<ColumnDO>> allChildColumn = columnService.queryAllChildColumn();
        model.addAttribute("user",user);
        model.addAttribute("parentColumn",parentColumn.getData());
        model.addAttribute("allChildColumn",allChildColumn.getData());
        model.addAttribute("article",response.getData());
        model.addAttribute("CommentsList",CommentsDOResponse.getData());
        return "before/article-detail";
    }

    /**
     * 查询栏目子节点
     * @param model
     * @param id
     */
    @RequestMapping("/article/column.html")
    public String queryArticleForChildColumn(Model model,Integer id){
        List<ArticleDO> articleList = articleService.queryArticleForChildColumn(id);
        UserDO user = userService.queryUser();
        ResultResponse<List<ColumnDO>> parentColumn = columnService.queryParentColumn(null);
        ResultResponse<List<ColumnDO>> allChildColumn = columnService.queryAllChildColumn();
        model.addAttribute("user",user);
        model.addAttribute("parentColumn",parentColumn.getData());
        model.addAttribute("allChildColumn",allChildColumn.getData());
        model.addAttribute("articleList",articleList);
        return "before/index";
    }

    /**
     * 查询栏目父节点
     * @param model
     * @param id
     */
    @RequestMapping("/article/parentColumn.html")
    public String queryArticleForParentColumn(Model model,Integer id){
        List<ArticleDO> articleList = articleService.queryArticleForParentColumn(id);
        UserDO user = userService.queryUser();
        ResultResponse<List<ColumnDO>> parentColumn = columnService.queryParentColumn(null);
        ResultResponse<List<ColumnDO>> allChildColumn = columnService.queryAllChildColumn();
        model.addAttribute("user",user);
        model.addAttribute("parentColumn",parentColumn.getData());
        model.addAttribute("allChildColumn",allChildColumn.getData());
        model.addAttribute("articleList",articleList);
        return "before/index";
    }

    /**
     * 游客留言 , Integer articleId, String leaveComments
     * @return
     */
    @RequestMapping("/tourist/add.html")
    @ResponseBody
    public  ResultResponse addTourist(HttpServletRequest request , @RequestBody Map<String,String> map){
//        Cookie[] cookies = request.getCookies();
        String articleId = map.get("articleId");
        String leaveComments = map.get("leaveComments");
        HttpSession session=request.getSession();
        TouristDO touristDO= (TouristDO)session.getAttribute("tourist");
        if (touristDO!=null){
            ResultResponse<CommentsResponse> response = touristService.creatMessage(touristDO, articleId, leaveComments);
            return response;
        }
        return ResultResponse.failResponse(2,"去登陆","/toutist/login.html");
    }

    /**
     * 游客注册
     */
    @RequestMapping("/tourist/registered.html")
    public String registered(){
        return "before/registered";
    }

    /**
     *  游客登录
     */
    @RequestMapping("/toutist/login.html")
    public String login(){
        return "before/login";
    }

    /**
     * 搜索文章
     */
    @RequestMapping("/search.html")
    public String search(Model model,String articleTitle){
        List<ArticleDO> articleList = articleService.search(articleTitle);
        UserDO user = userService.queryUser();
        ResultResponse<List<ColumnDO>> parentColumn = columnService.queryParentColumn(null);
        ResultResponse<List<ColumnDO>> allChildColumn = columnService.queryAllChildColumn();
        model.addAttribute("user",user);
        model.addAttribute("parentColumn",parentColumn.getData());
        model.addAttribute("allChildColumn",allChildColumn.getData());
        model.addAttribute("articleList",articleList);
        return "before/search";
    }


}
