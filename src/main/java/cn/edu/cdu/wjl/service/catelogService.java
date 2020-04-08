package cn.edu.cdu.wjl.service;

import cn.edu.cdu.wjl.Entity.Catelog;


import java.util.List;


public interface catelogService {
    /**
     * 查询所有分类
     */
    List<Catelog> selectAllCatelogs();
    /**
     *删除分类
     */
    boolean deleteCatelogById(int catelog_id);
    /**
     * 更新分类
     */
    boolean updateCatelog(Catelog catelog);
    /**
     * 新增分类
     */
    boolean insertCatelog(Catelog catelog);
    /**
     * 查询分类
     */
    Catelog selectCatelogByName(String catelog_name);

}
