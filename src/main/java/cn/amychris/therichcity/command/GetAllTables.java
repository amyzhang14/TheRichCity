package cn.amychris.therichcity.command;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.amychris.therichcity.game.Table;
import cn.amychris.therichcity.service.TableService;

import com.google.gson.Gson;

public class GetAllTables implements Command {
	private static final transient Log log = LogFactory.getLog( GetAllTables.class );

	private TableService	tableService;

	public GetAllTables(TableService tableService) {
		this.tableService = tableService;
	}

	@Override
	public String execute( Object arg ) {
		throw new UnsupportedOperationException( "There is no command needed for GetAllTables." );
	}

	@Override
	public String execute() {
		log.debug( "Enter execute()..." );
		Set<Table> tables = tableService.getAllTables();
		
		if ( log.isDebugEnabled() ) {
			log.debug( "Got " + tables.size() + " tables." );
			
			for ( Table t : tables ) {
				log.debug( "Table: " + t );
			}
		}
		
		Gson gson = new Gson();
		String result = gson.toJson( tables );
		
		log.debug( "Return result: " + result );
		return result;
	}

}
