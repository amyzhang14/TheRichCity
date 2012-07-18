package cn.amychris.therichcity.service;

import java.util.List;
import java.util.Set;

import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.game.Table;

public interface TableService {

	Set<Table> getAllTables();
	
	Table getTable(int tableNumber);
	
	List<String> createTable(Table table, UserEntity tableMaster);
	
	List<String> joinTable(int tableNumber, UserEntity user);
	
	List<String> startGame(int tableNumber, UserEntity tableMaster);
	
	List<String> quitTable(int tableNumber, UserEntity user);
	
}
