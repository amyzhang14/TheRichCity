package cn.amychris.therichcity.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.game.Table;
import cn.amychris.therichcity.service.TableService;

@Scope("singleton")
@Service("tableService")
public class TableServiceImpl implements TableService {
	
	private Map<Integer, Table> tables = new HashMap<Integer, Table>();

	@Override
	public Set<Table> getAllTables() {
		Set<Table> re = new TreeSet<Table>();
		
		for ( Table t : tables.values() ) {
			re.add( (Table) t.clone() );
		}
		
		return re;
	}

	@Override
	public Table getTable( int tableNumber ) {
		return tables.get( tableNumber );
	}

	@Override
	public List<String> createTable( Table table, UserEntity tableMaster ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> joinTable( int tableNumber, UserEntity user ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> startGame( int tableNumber, UserEntity tableMaster ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> quitTable( int tableNumber, UserEntity user ) {
		// TODO Auto-generated method stub
		return null;
	}

}
