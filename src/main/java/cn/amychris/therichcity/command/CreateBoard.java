package cn.amychris.therichcity.command;

import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.exception.CommandExecutingException;
import cn.amychris.therichcity.game.Board;
import cn.amychris.therichcity.service.BoardService;
import cn.amychris.therichcity.util.StringUtil;

public class CreateBoard implements Command {
	
	private BoardService tableService;
	
	public CreateBoard(BoardService tableService) {
		this.tableService = tableService;
	}

	@Override
	public String execute( Object arg ) {
		try {
			UserEntity user = (UserEntity)arg;
			Board board = this.tableService.createBoard( user );
			return StringUtil.toJSONString( board );
			
		} catch ( Exception e ) {
			throw new CommandExecutingException( e );
		}
	}

	@Override
	public String execute() {
		throw new CommandExecutingException( "A Board is required for CreateBoard command." );
	}

}
