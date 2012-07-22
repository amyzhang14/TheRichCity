package cn.amychris.therichcity.command;

import cn.amychris.therichcity.exception.CommandExecutingException;
import cn.amychris.therichcity.game.Table;
import cn.amychris.therichcity.service.TableService;

import com.google.gson.Gson;

public class CreateTable implements Command {
	
	private TableService tableService;
	
	public CreateTable(TableService tableService) {
		this.tableService = tableService;
	}

	@Override
	public String execute( Object arg ) {
		try {
			Table table = (Table) arg;
			this.tableService.createTable( table, table.getTableMaster() );
			Gson gson = new Gson();
			return gson.toJson( table );
			
		} catch ( Exception e ) {
			throw new CommandExecutingException( e );
		}
	}

	@Override
	public String execute() {
		throw new CommandExecutingException( "A Table is required for CreateTable command." );
	}

}
