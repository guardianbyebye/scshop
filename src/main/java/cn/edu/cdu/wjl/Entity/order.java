package cn.edu.cdu.wjl.Entity;

public class order {
    private int order_id;//订单id
    private int order_good_id;//订单中的商品id
    private int order_user_id;//订单生成者的id
    private int status;//状态 0:未支付 1:已支付

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
