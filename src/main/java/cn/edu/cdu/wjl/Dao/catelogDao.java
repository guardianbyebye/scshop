package cn.edu.cdu.wjl.Dao;

import cn.edu.cdu.wjl.Entity.Catelog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface catelogDao {
    /**
     * 查找所有分类
     */
    List<Catelog> selectAllCatelogs();
    /**
     * 删除分类
     */
    boolean deleteCatelog(int catelog_id);
    /**
     * 更新分类
     */
    boolean updateCatelog(Catelog catelog);
    /**
     * 添加分类
     */
    boolean insertCatelog(Catelog catelog);
    /**
     * 查询分类
     */
    Catelog selectCatelogByName(String catelog_name);
}
