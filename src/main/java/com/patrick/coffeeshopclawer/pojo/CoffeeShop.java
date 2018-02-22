package com.patrick.coffeeshopclawer.pojo;

/**
 * @author peicong
 * @date 2018/2/20 0020
 */
public class CoffeeShop {

    private String address;
    private String name;

    public CoffeeShop(String address, String name) {
        super();
        this.address = address;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CoffeeShop{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
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
}
