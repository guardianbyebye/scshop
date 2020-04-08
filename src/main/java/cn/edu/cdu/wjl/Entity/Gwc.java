package cn.edu.cdu.wjl.Entity;

public class Gwc {
    private int gwc_id;//购物车id
    private int gwc_user_id;//用户id
    private int gwc_good_id;//商品id
    private int gwc_good_number;//数量
    public int getGwc_id() {
        return gwc_id;
    }

    public void setGwc_id(int gwc_id) {
        this.gwc_id = gwc_id;
    }

    public int getGwc_user_id() {
        return gwc_user_id;
    }

    public void setGwc_user_id(int gwc_user_id) {
        this.gwc_user_id = gwc_user_id;
    }

    public int getGwc_good_id() {
        return gwc_good_id;
    }

    public void setGwc_good_id(int gwc_good_id) {
        this.gwc_good_id = gwc_good_id;
    }

    public int getGwc_good_number() {
        return gwc_good_number;
    }

    public void setGwc_good_number(int gwc_good_number) {
        this.gwc_good_number = gwc_good_number;
    }
}
