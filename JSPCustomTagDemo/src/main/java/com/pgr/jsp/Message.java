package com.pgr.jsp;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Message extends SimpleTagSupport {
	
	public void doTag() throws JspException, IOException {
		/*
		 * This is just to display a message, when we will use our custom tag. This
		 * message would be displayed
		 */
		JspWriter out = getJspContext().getOut();
		out.println("Hi, First Custom Tag Demo");
	}
}