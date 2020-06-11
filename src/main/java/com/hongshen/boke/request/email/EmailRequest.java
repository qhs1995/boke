package com.hongshen.boke.request.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2019/9/23 18:37
 * @Desc:
 */
public class EmailRequest implements Serializable {

    private String name;

    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
