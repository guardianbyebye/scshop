package cn.edu.cdu.wjl.service.impl;

import cn.edu.cdu.wjl.Dao.messageDao;
import cn.edu.cdu.wjl.Entity.Message;
import cn.edu.cdu.wjl.service.messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class messageServiceImpl implements messageService {
    @Autowired
    messageDao messageDao;
    @Override
    public boolean addMessage(Message message) {
        return messageDao.addMessage(message);
    }

    @Override
    public List<Message> selectMessage(int good_id) {
        return messageDao.selectMessageByGoodId(good_id);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageDao.getAllMessages();
    }

    @Override
    public boolean deleteMessage(int message_id) {
        return messageDao.deleteMessage(message_id);
    }
}
