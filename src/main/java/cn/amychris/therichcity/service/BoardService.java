package cn.amychris.therichcity.service;

import java.util.List;

import cn.amychris.therichcity.entity.Board;
import cn.amychris.therichcity.entity.User;

public interface BoardService {
	
	int getMaxPlayersPerBoard();

	List<Board> getAllBoards();
	
	Board getBoard(int boardNumber);
	
	Board createBoard(User boardCreator);
	
	void joinBoard(int boardNumber, User user);
	
	void startGame(int boardNumber, User boardCreator);
	
	void quitBoard(User user);
	
}
