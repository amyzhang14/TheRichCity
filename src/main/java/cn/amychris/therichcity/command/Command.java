package cn.amychris.therichcity.command;

import cn.amychris.therichcity.exception.CommandExecutingException;

public interface Command {

	String execute( Object arg ) throws CommandExecutingException;
	
	String execute() throws CommandExecutingException;
}
