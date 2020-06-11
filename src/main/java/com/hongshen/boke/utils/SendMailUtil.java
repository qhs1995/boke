package com.hongshen.boke.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/7/17 16:27
 * @Desc: 163邮箱
 */
public class SendMailUtil {
    private static final Logger logger = LoggerFactory.getLogger(SendMailUtil.class);

    static String HOST = ""; // smtp服务器
    static String FROM = ""; // 发件人地址
    static String TO = ""; // 收件人地址
    static String AFFIX = ""; // 附件地址
    static String AFFIXNAME = ""; // 附件名称
    static String USER = ""; // 用户名
    static String PWD = ""; // 163的授权码
    static String SUBJECT = ""; // 邮件标题
    static String PORT = ""; // 指定邮箱发送的端口号
    static String[] TOS = null;

    static {
        try {
            Properties props = new Properties();
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));//从自定义配置文件获取相关参数
            HOST=props.getProperty("host");
            FROM=props.getProperty("from");
            TO=props.getProperty("to");
            TOS=TO.split(",");
            AFFIX=props.getProperty("affix");
            AFFIXNAME=props.getProperty("affixName");
            USER=props.getProperty("user");
            PWD=props.getProperty("pwd");
            SUBJECT=props.getProperty("subject");
            PORT=props.getProperty("port");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送邮件
     * @param context 内容
     * @param name  标题
     */
    public static void send(String context,String name) {
        Properties props = new Properties();
        //设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
        props.put("mail.smtp.host", HOST);
        //指定端口号
        props.put("mail.smtp.port", PORT);
        //开启ssl协议
        props.put("mail.smtp.ssl.enable", true);
        //需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        props.put("mail.smtp.auth", "true");
        //用props对象构建一个session
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        //用session为参数定义消息对象
        MimeMessage message = new MimeMessage(session);
        try {
            // 加载发件人地址
            message.setFrom(new InternetAddress(FROM));
            // 加载收件人地址
            InternetAddress[] sendTo = new InternetAddress[TOS.length];
            for (int i = 0; i < TOS.length; i++) {
                sendTo[i] = new InternetAddress(TOS[i]);
            }
            message.addRecipients(Message.RecipientType.TO,sendTo);
            //设置在发送给收信人之前给自己（发送方）抄送一份，不然会被当成垃圾邮件，报554错
            message.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(FROM));
//            message.setSubject(SUBJECT);//加载标题
            message.setSubject(name,"UTF-8");
            //向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart();
            //设置邮件的文本内容
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setText(context);
            multipart.addBodyPart(contentPart);
//            if(!AFFIX.isEmpty()){//添加附件
//                BodyPart messageBodyPart = new MimeBodyPart();
//                DataSource source = new FileDataSource(AFFIX);
//                messageBodyPart.setDataHandler(new DataHandler(source));//添加附件的内容
//                sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();//添加附件的标题
//                messageBodyPart.setFileName("=?GBK?B?"+ enc.encode(AFFIXNAME.getBytes()) + "?=");
//                multipart.addBodyPart(messageBodyPart);
//            }
            //将multipart对象放到message中
            message.setContent(multipart);
            //保存邮件
            message.saveChanges();
            //发送邮件
            Transport transport = session.getTransport("smtp");
            //连接服务器的邮箱
            transport.connect(HOST, USER, PWD);
            //把邮件发送出去
            transport.sendMessage(message, message.getAllRecipients());
            //关闭连接
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
