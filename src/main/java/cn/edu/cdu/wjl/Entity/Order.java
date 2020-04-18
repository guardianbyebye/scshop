package cn.edu.cdu.wjl.Entity;

import java.util.Date;

public class Order {
    private int order_id;//订单id
    private int order_good_id;//订单中的商品id
    private int order_user_id;//订单生成者的id
    private int status;//支付状态 0:未支付 1:已支付 2:未发货 3：已发货 4：已收货未评价 5：已评价交易完成
    private String order_number;//唯一订单号
    private Date create_time;//订单创建时间
    private String order_remark;//订单留言
    private int order_amount;//订单金额
    private Date consign_time;//发货时间
    private int buy_number;//购买数量
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_good_id() {
        return order_good_id;
    }

    public void setOrder_good_id(int order_good_id) {
        this.order_good_id = order_good_id;
    }

    public int getOrder_user_id() {
        return order_user_id;
    }

    public void setOrder_user_id(int order_user_id) {
        this.order_user_id = order_user_id;
    }


    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }


    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getOrder_remark() {
        return order_remark;
    }

    public void setOrder_remark(String order_remark) {
        this.order_remark = order_remark;
    }

    public int getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(int order_amount) {
        this.order_amount = order_amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getConsign_time() {
        return consign_time;
    }

    public void setConsign_time(Date consign_time) {
        this.consign_time = consign_time;
    }

    public int getBuy_number() {
        return buy_number;
    }

    public void setBuy_number(int buy_number) {
        this.buy_number = buy_number;
    }
}
