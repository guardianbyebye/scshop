package cn.edu.cdu.wjl.Entity;

public class Catelog {
    private int catelog_id;//类型id
    private String catelog_name;//类型名称
    private String catelog_ddescription;//类型描述

    public int getCatelog_id() {
        return catelog_id;
    }

    public void setCatelog_id(int catelog_id) {
        this.catelog_id = catelog_id;
    }

    public String getCatelog_name() {
        return catelog_name;
    }

    public void setCatelog_name(String catelog_name) {
        this.catelog_name = catelog_name;
    }

    public String getCatelog_ddescription() {
        return catelog_ddescription;
    }

    public void setCatelog_ddescription(String catelog_ddescription) {
        this.catelog_ddescription = catelog_ddescription;
    }
}
