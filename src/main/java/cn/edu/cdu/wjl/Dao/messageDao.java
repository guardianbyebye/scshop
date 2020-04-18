package cn.edu.cdu.wjl.Dao;

import cn.edu.cdu.wjl.Entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface messageDao {
    /**
     * 增加留言
     */
    boolean addMessage(Message message);
    /**
     * 搜索留言
     */
    List<Message> selectMessageByGoodId(int message_good_id);
    /**
     * 全部留言
     */
    List<Message> getAllMessages();
    /**
     * 删除留言
     */
    boolean deleteMessage(int message_id);
}

