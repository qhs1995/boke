package com.hongshen.boke.jianli.controller.before;

import com.hongshen.boke.dao.jianli.object.*;
import com.hongshen.boke.jianli.service.*;
import com.hongshen.boke.request.email.EmailRequest;
import com.hongshen.boke.response.ResultResponse;
import com.hongshen.boke.utils.IpUtils;
import com.hongshen.boke.utils.JsonUtil;
import com.hongshen.boke.utils.StringUtils;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/9/23 17:02
 * @Desc: 简历前端展示
 */
@Controller
public class JianliIndexController {
    private static final Logger logger = LoggerFactory.getLogger(JianliIndexController.class);

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private WorkService workService;
    @Autowired
    private AppraisalService appraisalService;
    @Autowired
    private SendEmailService sendEmailService;
    @Autowired
    private StatisticsService statisticsService;


    @RequestMapping("/")
    public String index(Model model) {
        List<UserinfoDO> userinfoDOList = userInfoService.queryList(1, 1);
        List<ProjectDO> projectDOList = projectService.queryList(1, 10);
        List<SkillDO> skillDOList = skillService.queryList(1, 10);
        List<WorkDO> workDOList = workService.queryList(1, 10);
        List<AppraisalDO> appraisalDOList = appraisalService.queryList(1, 10);
        if (userinfoDOList.size() > 0) {
            model.addAttribute("userinfo", userinfoDOList.get(0));
        }
        model.addAttribute("projectList", projectDOList);
        model.addAttribute("skillList", skillDOList);
        model.addAttribute("workList", workDOList);
        model.addAttribute("appraisalList", appraisalDOList);
        return "jianli/index";
    }


    /**
     * 发送邮件
     *
     * @param request
     * @return
     */
    @RequestMapping("/jianli/sendEmail")
    @ResponseBody
    public ResultResponse<String> index(@RequestBody EmailRequest request) {
        if (StringUtils.isBlank(request.getName()) || StringUtils.isBlank(request.getContent())) {
            return ResultResponse.successResponse("发送失败，请填写姓名和内容！", null);
        }
        Boolean isSendEmail = statisticsService.queryRegulationTimeIsSendEmail(IpUtils.getIp());
        if (isSendEmail) {
            return ResultResponse.successResponse("请勿频繁发送，我谢谢您！！", null);
        }
        String json = JsonUtil.toJson(request);
        sendEmailService.send(json);
        logger.info("开始发送邮件，发送人={}", request.getName());
        return ResultResponse.successResponse("发送成功，已收到您的邮件！", null);
    }


    /**
     * 简历下载
     */
    @RequestMapping("/jianli/download")
    @ResponseBody
    public void download(HttpServletRequest request, HttpServletResponse response)  {

        InputStream certStream = null;
        try {
            certStream = new BufferedInputStream(new FileInputStream("./static/upload/haha.doc"));
        } catch (FileNotFoundException e) {
           logger.info("为上传简历，下载默认简历！");
            ClassPathResource cp = new ClassPathResource("jianli.doc");
            try {
                certStream = cp.getInputStream();
            } catch (IOException e1) {
                logger.error("未找到默认简历！");
            }

        }
        /**
         * 读取classpath文件下的资源时用这种方法即可
         */
        //        ClassPathResource cp = new ClassPathResource("jianli.doc");
        //        InputStream certStream = null;
        //        try {
        //            certStream = cp.getInputStream();
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }


//     File file = null;
//        try {
//            file = ResourceUtils.getFile("classpath:jianli.doc");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        String fileName=file.getName();
//        String ext=fileName.substring(fileName.lastIndexOf(".")+1);
//        //判断浏览器类型
//        String agent=(String)request.getHeader("USER-AGENT");
//        try {
//            if(agent!=null && agent.indexOf("Fireforx")!=-1) {
//                //UTF-8编码，防止输出文件名乱码
//                fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
//
//            }
//            else {
//                fileName= URLEncoder.encode(fileName,"UTF-8");
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        BufferedInputStream bis = null;
        OutputStream os = null;
        response.reset();
        response.setCharacterEncoding("utf-8");

        // word格式
        response.setContentType("application/msword");
        //pdf格式
        // response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=jianli.doc");

        try {
            bis = new BufferedInputStream(certStream);
            byte[] b = new byte[bis.available() + 1000];
            int i = 0;
            //直接下载导出
            os = response.getOutputStream();
            while ((i = bis.read(b)) != -1) {
                os.write(b, 0, i);
            }
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
