package cn.amychris.therichcity.service;

import java.util.List;

import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.game.Board;

public interface BoardService {
	
	int getMaxPlayersPerBoard();

	List<Board> getAllBoards();
	
	Board getBoard(int boardNumber);
	
	Board createBoard(UserEntity boardCreator);
	
	void joinBoard(int boardNumber, UserEntity user);
	
	void startGame(int boardNumber, UserEntity boardCreator);
	
	void quitBoard(UserEntity user);
	
}
