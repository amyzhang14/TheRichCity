package cn.amychris.therichcity.command;

import java.util.Map;

import cn.amychris.therichcity.exception.TheRichCityException;

public class CommandFactory {

	private Map<String, Command> commands;
	
	public CommandFactory(Map<String, Command> commands) {
		if ( null == commands ) {
			throw new TheRichCityException("Commands can not be null.");
		}
		this.commands = commands;
	}
	
	public Command getCommand(String commandName) {
		return commands.get( commandName );
	}
	
}
