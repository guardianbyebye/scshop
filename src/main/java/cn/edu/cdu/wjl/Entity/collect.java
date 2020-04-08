package cn.edu.cdu.wjl.Entity;

public class collect {
    private int collect_id;//收藏id
    private int collect_good_id;//商品id
    private int collect_user_id;//用户id

    public int getCollect_id() {
        return collect_id;
    }

    public void setCollect_id(int collect_id) {
        this.collect_id = collect_id;
    }

    public int getCollect_good_id() {
        return collect_good_id;
    }

    public void setCollect_good_id(int collect_good_id) {
        this.collect_good_id = collect_good_id;
    }

    public int getCollect_user_id() {
        return collect_user_id;
    }

    public void setCollect_user_id(int collect_user_id) {
        this.collect_user_id = collect_user_id;
    }
}
