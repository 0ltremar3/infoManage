package com.zryx.company.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class News {
    private int newsId;
    private String title;
    private String content;
    private Date writeDate;

    public News() {
    }

    public News(int newsId,String title, String content,Date writeDate){
        this.newsId = newsId;
        this.title = title;
        this.content = content;
        this.writeDate = writeDate;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public String toString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "新闻编号:" + newsId + " 新闻标题:" + title + "\n新闻内容:\n" + content
                + "\n发表时间:" + simpleDateFormat.format(writeDate);
    }
}
