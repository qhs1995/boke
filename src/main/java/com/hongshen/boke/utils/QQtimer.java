package com.hongshen.boke.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/8/6 16:02
 * @Desc:
 */
public class QQtimer {
    private static final Logger logger = LoggerFactory.getLogger(QQtimer.class);
    public static void main(String[]args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run(){
                String sentence = "everybody早上好,今夜阳光明媚,今天多云转晴,早安、早安";// 定义要发送的话
                Robot robot = null;
                try {
                    robot = new Robot();
                } catch (AWTException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }// 创建Robot对象
                robot.delay(3000);// 延迟三秒，主要是为了预留出打开窗口的时间，括号内的单位为毫秒
                Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
                String[] authors = sentence.split("[,]");// 字符串根据,分割
                for (int j = 0; j < 1; j++) {//循环次数
                    for (int i = 0; i < authors.length; i++) {
                        String sentencet = authors[i];
                        Transferable tText = new StringSelection(sentencet);
                        clip.setContents(tText, null);
                        // for (int j = 1; j <= 1; j++) {
                        // 以下两行按下了ctrl+v，完成粘贴功能
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_V);

                        robot.keyRelease(KeyEvent.VK_CONTROL);// 释放ctrl按键，像ctrl，退格键，删除键这样的功能性按键，在按下后一定要释放，不然会出问题。crtl如果按住没有释放，在按其他字母按键是，敲出来的回事ctrl的快捷键。
                        robot.delay(1000);// 延迟一秒再发送，不然会一次性全发布出去，因为电脑的处理速度很快，每次粘贴发送的速度几乎是一瞬间，所以给人的感觉就是一次性发送了全部。这个时间可以自己改，想几秒发送一条都可以
                        robot.keyPress(KeyEvent.VK_ENTER);// 回车
                        // }
                    }
                }
            }
        },  10000, 86400000);//10000表示延迟十秒执行，86400000表示24*60*60秒后也就是每天循环执行一次
    }

}
