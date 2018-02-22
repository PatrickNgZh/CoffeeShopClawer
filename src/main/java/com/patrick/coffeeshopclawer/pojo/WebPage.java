package com.patrick.coffeeshopclawer.pojo;

/**
 * @author peicong
 * @date 2018/2/20 0020
 */
public class WebPage {

    public WebPage(String url,int index,Status status) {
        this.url = url;
        this.index = index;
        this.status = status;
    }

    public enum Status{
        clawed, unclawed,
    }

    @Override
    public String toString() {
        return "WebPage{" +
                "url='" + url + '\'' +
                ", status=" + status +
                ", index=" + index +
                '}';
    }

    private String url;
    private Status status;
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
