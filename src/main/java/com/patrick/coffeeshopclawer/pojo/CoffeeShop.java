package com.patrick.coffeeshopclawer.pojo;

/**
 * @author peicong
 * @date 2018/2/20 0020
 */
public class CoffeeShop {

    private String address;
    private String name;
    private String tag;
    private String comment;
    private String taste;
    private String environment;
    private String service;
    private String consume;

    public CoffeeShop(String address, String name, String tag,
                      String comment, String taste, String environment,
                      String service, String consume) {
        this.address = address;
        this.name = name;
        this.tag = tag;
        this.comment = comment;
        this.taste = taste;
        this.environment = environment;
        this.service = service;
        this.consume = consume;
    }

    @Override
    public String toString() {
        return "CoffeeShop{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", comment='" + comment + '\'' +
                ", taste='" + taste + '\'' +
                ", environment='" + environment + '\'' +
                ", service='" + service + '\'' +
                ", consume='" + consume + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getConsume() {
        return consume;
    }

    public void setConsume(String consume) {
        this.consume = consume;
    }
}
