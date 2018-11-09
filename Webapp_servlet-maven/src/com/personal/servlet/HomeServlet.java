package com.personal.servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

public class HomeServlet extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	    HashMap<String, Object> scopes = new HashMap<String, Object>();
	    scopes.put("name", "Mustache");

	    PrintWriter writer=resp.getWriter();
	    MustacheFactory mf = new DefaultMustacheFactory();
	    //Mustache mustache = mf.compile(new StringReader("<html><title>a</title><body><h1>{{name}}</h1></body></html>"), "example");
	    Mustache mustache = mf.compile("./../../../../../jsp/home.jsp");
	    mustache.execute(writer, scopes);
	    writer.flush();
	    writer.close();
	    
		
		
	}
	
}
