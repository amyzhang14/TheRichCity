package cn.amychris.therichcity.command;

public interface Command {

	String execute( Object arg );
	
	String execute();
}
