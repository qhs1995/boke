//package spider;
//
//import com.gargoylesoftware.htmlunit.WebClient;
//import com.gargoylesoftware.htmlunit.html.*;
//import junit.framework.TestCase;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//import java.net.URLConnection;
//import java.util.Map;
//
///**
// * Created with IDEA
// *
// * @author:qianhongshen
// * @Date:2019/7/1 17:48
// * @Desc: 爬虫测试
// */
//public class SpiderTests extends TestCase {
//    private static final Logger logger = LoggerFactory.getLogger(SpiderTests.class);
//
//
//    public void test() throws IOException {
//
//        // 得到浏览器对象，直接New一个就能得到，现在就好比说你得到了一个浏览器了
//        WebClient webclient = new WebClient();
//
//        // 这里是配置一下不加载css和javaScript,配置起来很简单，是不是
//        webclient.getOptions().setCssEnabled(false);
//        webclient.getOptions().setJavaScriptEnabled(false);
//
//        // 做的第一件事，去拿到这个网页，只需要调用getPage这个方法即可
//        HtmlPage htmlpage = webclient.getPage("http://sc.zhaoshang.net/guangan/wusheng/zhengce/1");
//
//        //把获得后的网页转换成document
//        Document document = Jsoup.parse(htmlpage.asXml());
//
//        //获得配对文本结果
//        Element e = document.select("[class=\"news_left\"]").get(0);
//        Element ul = e.select("ul").get(0);
//        Elements lis = ul.select("li");
//        for (int i=1;i<lis.size();i++){
//            Element element = lis.get(i);
//            Element element1 = element.selectFirst("[class=\"news_tit\"]");
//            Element a = element1.selectFirst("a");
//            //得到文章路径
//            String href = a.attr("href");
//            System.out.println(href);
//            HtmlPage html = webclient.getPage(href);
//            Document documents = Jsoup.parse(html.asXml());
//            Element tbody = documents.select("tbody").get(1);
//            String title = tbody.selectFirst("h1").text();
//            System.out.println(title);
//            Element timeElement = tbody.selectFirst("p");
//            String timeStr = timeElement.text();
//            System.out.println(timeStr);
//            Element tbody2 = documents.select("tbody").get(2);
//            Elements p = tbody2.select("p");
//            StringBuffer content = new StringBuffer();
//            for (Element element2:p){
//                content.append(element2.text());
//            }
//            System.out.println(content);
//        }
//    }
//
//
//    @Test
//    public void test2(){
//
//    }
//
//}
