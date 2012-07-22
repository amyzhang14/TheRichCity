package cn.amychris.therichcity.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import cn.amychris.therichcity.command.Command;

public class ExecuteCommandServlet extends BaseHttpServlet {

	private static final transient Log	log					= LogFactory.getLog( ExecuteCommandServlet.class );

	/**
	 * 
	 */
	private static final long			serialVersionUID	= 1L;

	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		if ( log.isDebugEnabled() ) {
			log.debug( "Enter doGet()..." );
			log.debug( "Request: " + request.getQueryString() );
		}

		this.execute( request, response );
	}

	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		if ( log.isDebugEnabled() ) {
			log.debug( "Enter doPost()..." );
			log.debug( "Request: " + request.getQueryString() );
		}

		this.execute( request, response );
	}

	private void execute( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String commandName = request.getParameter( "command" );

		if ( null == commandName ) {
			response.sendError( HttpServletResponse.SC_BAD_REQUEST, "Parameter \"command\" is required." );
			return;
		}

		Command command = this.getGetCommandFactory().getCommand( commandName );

		if ( null == command ) {
			response.sendError( HttpServletResponse.SC_BAD_REQUEST, "Bad Command: " + commandName );
			return;
		}

		String commandPara = request.getParameter( "para" );
		response.setContentType( "text/plain;charset=GB2312" );
		response.getWriter().print( StringUtils.hasLength( commandPara ) ? command.execute( commandPara ) : command.execute() );

	}

}
