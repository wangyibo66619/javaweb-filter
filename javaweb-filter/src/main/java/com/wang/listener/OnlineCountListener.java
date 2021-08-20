package com.wang.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// 统计网站在线人数：统计session
public class OnlineCountListener implements HttpSessionListener {
    // 创建session监听
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext sct = se.getSession().getServletContext();
        Integer onlineCount = (Integer) sct.getAttribute("OnlineCount");
        if (onlineCount==null) {
            onlineCount = new Integer(1);
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count+1);
        }
        sct.setAttribute("OnlineCount",onlineCount);
    }
    // 销毁session监听
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext sct = se.getSession().getServletContext();
        Integer onlineCount = (Integer) sct.getAttribute("OnlineCount");
        if (onlineCount==null) {
            onlineCount = new Integer(0);
        }else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count-1);
        }
        sct.setAttribute("OnlineCount",onlineCount);
    }
}
