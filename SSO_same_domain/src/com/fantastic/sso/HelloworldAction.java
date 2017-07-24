package com.fantastic.sso;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by wuzhuo on 17/5/23.
 */
public class HelloworldAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("HelloworldAction");
        return SUCCESS;
    }
}
