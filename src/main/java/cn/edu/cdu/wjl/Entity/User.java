package cn.edu.cdu.wjl.Entity;

import java.util.Date;

public class User {
    private int user_id;//用户id
    private String user_name;//用户账号
    private String user_pwd;//用户密码
    private String user_realname;//用户真实姓名
    private String user_tel;//用户电话号码
    private String user_email;//用户邮箱
    private Date registe_time;//注册时间
    private String user_address;//地址
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_realname() {
        return user_realname;
    }

    public void setUser_realname(String user_realname) {
        this.user_realname = user_realname;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Date getRegiste_time() {
        return registe_time;
    }

    public void setRegiste_time(Date registe_time) {
        this.registe_time = registe_time;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_realname='" + user_realname + '\'' +
                ", user_tel='" + user_tel + '\'' +
                ", user_email='" + user_email + '\'' +
                ", registe_time=" + registe_time +
                ", user_address='" + user_address + '\'' +
                '}';
    }
}
