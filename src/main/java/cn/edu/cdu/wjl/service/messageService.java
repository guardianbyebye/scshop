package cn.edu.cdu.wjl.service;

import cn.edu.cdu.wjl.Entity.Message;

import java.util.List;

public interface messageService {
    /**
     * 增加留言
     */
    boolean addMessage(Message message);
    /**
     * 搜索留言
     */
    List<Message> selectMessage(int good_id);
    /**
     * 全部留言
     */
    List<Message> getAllMessages();
    /**
     * 删除留言
     */
    boolean deleteMessage(int message_id);
}
