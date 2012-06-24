package cn.amychris.therichcity.game;

import java.util.Set;
import java.util.TreeSet;

import cn.amychris.therichcity.entity.UserEntity;

/**
 * 
 * @author Christian Chen
 * 
 *         A table is place holding some users(or players) and it can start a
 *         game.
 * 
 */
public class Table implements Cloneable, Comparable<Table> {

	private int					tableNumber;

	// All users sitting around this table.
	private Set<UserEntity>	users;

	private boolean				gameStarted;

	// The maximum number of users(players) can sit around this table.
	private int					maxPlayers;

	// Who created this table.
	private UserEntity			tableMaster;

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers( Set<UserEntity> users ) {
		this.users = users;
	}

	public boolean isGameStarted() {
		return gameStarted;
	}

	public void setGameStarted( boolean started ) {
		this.gameStarted = started;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber( int tableNumber ) {
		this.tableNumber = tableNumber;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers( int maxPlayers ) {
		this.maxPlayers = maxPlayers;
	}

	public UserEntity getTableMaster() {
		return tableMaster;
	}

	public void setTableMaster( UserEntity tableMaster ) {
		this.tableMaster = tableMaster;
	}

	public Object clone() {
		Table copy = new Table();

		copy.tableNumber = this.tableNumber;
		copy.maxPlayers = this.maxPlayers;
		copy.gameStarted = this.gameStarted;

		Set<UserEntity> users = new TreeSet<UserEntity>();
		users.addAll( this.users );
		copy.users = users;

		return copy;
	}

	@Override
	public boolean equals( Object o ) {
		if ( null == o || ! (o instanceof Table) ) {
			return false;
		}

		Table t = ( Table ) o;

		return this.tableNumber == t.tableNumber;
	}

	@Override
	public int hashCode() {
		return this.tableNumber;
	}

	@Override
	public int compareTo( Table o ) {
		return this.tableNumber - o.tableNumber;
	}

}
