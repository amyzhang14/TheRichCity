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
public class Board implements Cloneable, Comparable<Board> {

	private int					boardNumber;

	// All users sitting around this table.
	private Set<UserEntity>	users;

	private boolean				gameStarted = false;

	// The maximum number of users(players) can sit around this table.
	private int					maxPlayers = 6;

	// Who created this table.
	private UserEntity			boardCreator;

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

	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber( int tableNumber ) {
		this.boardNumber = tableNumber;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers( int maxPlayers ) {
		this.maxPlayers = maxPlayers;
	}

	public UserEntity getBoardCreator() {
		return boardCreator;
	}

	public void setBoardCreator( UserEntity tableMaster ) {
		this.boardCreator = tableMaster;
	}

	@Override
	public Object clone() {
		Board copy = new Board();

		copy.boardNumber = this.boardNumber;
		copy.maxPlayers = this.maxPlayers;
		copy.gameStarted = this.gameStarted;

		Set<UserEntity> users = new TreeSet<UserEntity>();
		users.addAll( this.users );
		copy.users = users;

		return copy;
	}

	@Override
	public boolean equals( Object o ) {
		if ( null == o || ! (o instanceof Board) ) {
			return false;
		}

		Board t = ( Board ) o;

		return this.boardNumber == t.boardNumber;
	}

	@Override
	public int hashCode() {
		return this.boardNumber;
	}

	@Override
	public int compareTo( Board o ) {
		return this.boardNumber - o.boardNumber;
	}

}
