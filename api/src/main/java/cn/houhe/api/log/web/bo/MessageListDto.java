package cn.houhe.api.log.web.bo;

import cn.houhe.api.log.entity.Message;

import java.util.List;

/**
 * Created by Administrator on 2017/5/13.
 */
public class MessageListDto {
    private int totalPages;
    private List<Message> messageList;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
