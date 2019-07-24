package com.zryx.company.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "page")
public class PageConfig<T> {
    public int pageSize;
    public int pageNum;
    private List<T> pageData;
    private int pageCount;
    private int dataCount;

    public PageConfig() {
    }

    public PageConfig(int pageSize, int pageNum, List<T> pageData, int pageCount, int dataCount) {
        this.setPageSize(pageSize);//
        this.setPageNum(pageNum);//
        this.setPageData(pageData);
        this.setPageCount(pageCount);//总页数
        this.setDataCount(dataCount);
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

//    计算总页数
    public int getPageCount() {
        return (dataCount % pageSize == 0) ? (dataCount/pageSize) : (dataCount/pageSize + 1);
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    @Override
    public String toString() {
        return "PageConfig{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", pageData=" + pageData +
                ", pageCount=" + pageCount +
                ", dataCount=" + dataCount +
                '}';
    }
}
