package cn.amychris.therichcity.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Christian Chen
 * 
 *         A table is place holding some users(or players) and it can start a
 *         game.
 * 
 */
public class Board extends BaseEntity implements Cloneable, Comparable<Board> {

	private byte		boardNumber;

	// All users sitting around this table.
	private List<User>	users;

	private boolean		isStarted	= false;

	// The maximum number of users(players) can sit around this table.
	private int			maxPlayers	= 6;

	// Who created this table.
	private User		boardMaster;

	private Date		creationDate;

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate( Date creationDate ) {
		this.creationDate = creationDate;
	}

	public byte getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber( byte boardNumber ) {
		this.boardNumber = boardNumber;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers( List<User> users ) {
		this.users = users;
	}

	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted( boolean started ) {
		this.isStarted = started;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers( int maxPlayers ) {
		this.maxPlayers = maxPlayers;
	}

	public User getBoardMaster() {
		return boardMaster;
	}

	public void setBoardMaster( User tableMaster ) {
		this.boardMaster = tableMaster;
	}

	@Override
	public Object clone() {
		Board copy = new Board();

		copy.boardNumber = this.boardNumber;
		copy.maxPlayers = this.maxPlayers;
		copy.isStarted = this.isStarted;
		List<User> copiedUsers = new ArrayList<User>();

		for ( User user : this.users ) {
			copiedUsers.add( ( User ) user.clone() );
		}

		copy.users = copiedUsers;
		copy.boardMaster = this.boardMaster;

		return copy;
	}

	@Override
	public boolean equals( Object o ) {
		if ( null == o || !(o instanceof Board) ) {
			return false;
		}

		return this.hashCode() == o.hashCode();
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
