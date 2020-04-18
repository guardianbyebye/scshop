package cn.edu.cdu.wjl.Entity;

public class Good {
    private int good_id;//商品id
    private String good_name;//商品名称
    private String good_price;//商品价格
    private String good_description;//商品描述
    private String good_photo;//商品图片
    private int good_catelog_id;//类型id
    private int good_user_id;//用户id
    private int good_number;//商品库存
    private int good_status;//0 上架中 1下架中
    private int good_isRecommend;//0 推荐  1不推荐
     public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public int getGood_status() {
        return good_status;
    }

    public void setGood_status(int good_status) {
        this.good_status = good_status;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public String getGood_price() {
        return good_price;
    }

    public void setGood_price(String good_price) {
        this.good_price = good_price;
    }

    public String getGood_description() {
        return good_description;
    }

    public void setGood_description(String good_description) {
        this.good_description = good_description;
    }

    public String getGood_photo() {
        return good_photo;
    }

    public void setGood_photo(String good_photo) {
        this.good_photo = good_photo;
    }

    public int getGood_catelog_id() {
        return good_catelog_id;
    }

    public void setGood_catelog_id(int good_catelog_id) {
        this.good_catelog_id = good_catelog_id;
    }

    public int getGood_user_id() {
        return good_user_id;
    }

    public void setGood_user_id(int good_user_id) {
        this.good_user_id = good_user_id;
    }

    public int getGood_number() {
        return good_number;
    }

    public void setGood_number(int good_number) {
        this.good_number = good_number;
    }

    public int getGood_isRecommend() {
        return good_isRecommend;
    }

    public void setGood_isRecommend(int good_isRecommend) {
        this.good_isRecommend = good_isRecommend;
    }
}
