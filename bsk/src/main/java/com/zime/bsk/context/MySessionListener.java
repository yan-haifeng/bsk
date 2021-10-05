package com.zime.bsk.context;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 94704
 * @DATE: 2019/12/13
 * @TIME: 14:03
 */
@WebListener
public class MySessionListener implements HttpSessionListener {
    public static Map userMap = new HashMap();
    private   MySessionContext myc=MySessionContext.getInstance();

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        myc.AddSession(httpSessionEvent.getSession());
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        myc.DelSession(session);
    }
}
