package com.zryx.company.mapper;

import com.zryx.company.model.News;

import java.util.List;

public interface NewsMapper {

    /**
     *
     * @return 返回List<News>
     */
    public List<News> getAllNews();

}
