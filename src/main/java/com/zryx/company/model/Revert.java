package com.zryx.company.model;

import java.util.Date;

public class Revert {
    private int revertId;
    private int messageId;
    private String content;
    private String writer;
    private Date writeDate;

    public Revert() {
    }

    public Revert(int revertId,int messageId,String content,String writer,Date writeDate) {
        this.revertId = revertId;
        this.messageId = messageId;
        this.content = content;
        this.writer = writer;
        this.writeDate = writeDate;
    }

    public int getRevertId() {
        return revertId;
    }

    public void setRevertId(int revertId) {
        this.revertId = revertId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    @Override
    public String toString() {
        return "Revert{" +
                "revertId=" + revertId +
                ", messageId=" + messageId +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", writeDate='" + writeDate + '\'' +
                '}';
    }
}
