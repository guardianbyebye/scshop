package cn.edu.cdu.wjl.Entity;

public class comment {
    private int comment_id;//评论id
    private String comment_text;//评论内容
    private int comment_good_id;//商品id
    private int comment_user_id;//用户id

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public int getComment_good_id() {
        return comment_good_id;
    }

    public void setComment_good_id(int comment_good_id) {
        this.comment_good_id = comment_good_id;
    }

    public int getComment_user_id() {
        return comment_user_id;
    }

    public void setComment_user_id(int comment_user_id) {
        this.comment_user_id = comment_user_id;
    }
}
