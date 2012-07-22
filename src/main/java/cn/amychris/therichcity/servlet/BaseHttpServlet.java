package cn.amychris.therichcity.servlet;

import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;

import cn.amychris.therichcity.command.CommandFactory;

@SuppressWarnings("serial")
public abstract class BaseHttpServlet extends HttpServlet {

	protected WebApplicationContext getWebApplicationContext() {

		return ( WebApplicationContext ) this.getServletContext().getAttribute( "org.springframework.web.context.WebApplicationContext.ROOT" );
	}

	protected CommandFactory getGetCommandFactory() {
		return ( CommandFactory ) this.getWebApplicationContext().getBean( "getCommandsFactory" );
	}
	
	protected CommandFactory getPostCommandFactory() {
		return ( CommandFactory ) this.getWebApplicationContext().getBean( "postCommandsFactory" );
	}

}
