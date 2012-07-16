package cn.amychris.therichcity.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;

import cn.amychris.therichcity.servlet.command.Command;

public class TableServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		WebApplicationContext ctx = ( WebApplicationContext ) request.getSession().getServletContext()
				.getAttribute( "org.springframework.web.context.WebApplicationContext.ROOT" );
		
		String commandName = request.getParameter( "command" );
		Command command = (Command)ctx.getBean( commandName );
		String commandPara = request.getParameter( "para" );
		
		response.getWriter().print( command.execute( commandPara ) );
	}

	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		;
	}

}
