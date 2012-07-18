package cn.amychris.therichcity.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.amychris.therichcity.command.Command;

public class TableServlet extends BaseHttpServlet {
	
	private static final transient Log log = LogFactory.getLog( TableServlet.class );

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		if ( log.isDebugEnabled() ) {
			log.debug( "Enter doGet()..." );
			log.debug( "Request: " + request );
		}
		
		String commandName = request.getParameter( "command" );
		
		if ( null == commandName ) {
			response.sendError( HttpServletResponse.SC_BAD_REQUEST, "Parameter \"command\" is required." );
			return;
		}
		
		Command command = this.getCommandFactory().getCommand( commandName );

		if ( null == command ) {
			response.sendError( HttpServletResponse.SC_BAD_REQUEST, "Bad Command: " + commandName );
			return;
		}

		String commandPara = request.getParameter( "para" );
		response.getWriter().print( command.execute( commandPara ) );
		
		if ( log.isDebugEnabled() ) {
			log.debug( "Return Response: " + response );
		}
	}

	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		;
	}

}
