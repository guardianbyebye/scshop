package cn.edu.cdu.wjl.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

public class Message {
    private int message_id;//评论id
    private String message_texts;//评论内容
    private int message_good_id;//商品id
    private int message_user_id;//用户id
    private Date message_time;
    private String message_user_name;

    public String getMessage_user_name() {
        return message_user_name;
    }

    public void setMessage_user_name(String message_user_name) {
        this.message_user_name = message_user_name;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getMessage_texts() {
        return message_texts;
    }

    public void setMessage_texts(String message_texts) {
        this.message_texts = message_texts;
    }

    public int getMessage_good_id() {
        return message_good_id;
    }

    public void setMessage_good_id(int message_good_id) {
        this.message_good_id = message_good_id;
    }

    public int getMessage_user_id() {
        return message_user_id;
    }

    public void setMessage_user_id(int message_user_id) {
        this.message_user_id = message_user_id;
    }

    public Date getMessage_time() {
        return message_time;
    }

    public void setMessage_time(Date message_time) {
        this.message_time = message_time;
    }
}
