package com.hongshen.boke.response.article;

import com.hongshen.boke.dao.object.ArticleDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created with IDEA
 *
 * @author:qianhongshen
 * @Date:2018/11/13 14:24
 * @Desc:
 */
public class ArticleQueryResponse extends ArticleDO implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(ArticleQueryResponse.class);

    private Integer parentId;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
