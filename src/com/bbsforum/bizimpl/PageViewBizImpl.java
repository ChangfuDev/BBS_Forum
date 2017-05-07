package com.bbsforum.bizimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbsforum.biz.PageViewBiz;
import com.bbsforum.dao.MessageDao;
import com.bbsforum.entity.Message;
import com.bbsforum.entity.PageBean;

public class PageViewBizImpl implements PageViewBiz {
	private static Logger logger=Logger.getLogger(PageViewBizImpl.class);
	@Autowired
	MessageDao messageDao;
	public MessageDao getMessageDao() {
		return messageDao;
	}
	
	@Override
	public PageBean showMessageBypage(int pageIndex, int pageSize,
			String receiverMail) {
		int itemSum=messageDao.getMessageByReceiverMail(receiverMail).size();
		int totalPage=PageBean.countTotalPage(pageSize, itemSum);//������ҳ��
		final int offset=PageBean.countOffset(pageSize, pageIndex);//��ȡ��ҳ��һ����¼���±�
		final int length=pageSize;//ÿҳ�ļ�¼��
		final int currentPage=PageBean.countCurrentPage(pageIndex);
		
		logger.info("pageIndex:"+pageIndex+"offset:"+offset);
		List<Message> messages=messageDao.getMessagesForPage(offset, pageSize, receiverMail);
		logger.info("message size:"+messages.size());
		PageBean pageBean=new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(pageIndex);
		pageBean.setAllRow(itemSum);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(messages);
		pageBean.init();
		return pageBean;
	}

}
