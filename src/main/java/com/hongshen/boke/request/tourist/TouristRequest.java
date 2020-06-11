package com.hongshen.boke.request.tourist;

import com.hongshen.boke.request.PageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/11/12 12:01
 * @Desc:
 */
public class TouristRequest extends PageRequest {
    private static final Logger logger = LoggerFactory.getLogger(TouristRequest.class);

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
