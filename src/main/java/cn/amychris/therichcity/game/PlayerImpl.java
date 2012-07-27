package cn.amychris.therichcity.game;

import java.util.List;

import cn.amychris.therichcity.entity.User;
import cn.amychris.therichcity.game.constructure.Constructure;
import cn.amychris.therichcity.game.role.Role;
import cn.amychris.therichcity.util.ArrayUtil;

public class PlayerImpl implements Player {
	
	private Game game;
	
	private User user;
	
	private Role role;

	private int money = 0;

	private boolean isManagedByServer = false;

	private List<Constructure> constructures;
	
	public PlayerImpl(User user, Game game) {
		if ( null == user || null == game ) {
			throw new NullPointerException("Neither user nor game could be null.");
		}
		
		this.user = user;
		this.game = game;
	}

	@Override
	public Role getRole() {
		return this.role;
	}

	@Override
	public boolean isManagedByServer() {
		return this.isManagedByServer;
	}

	@Override
	public int getMoney() {
		return this.money;
	}

	@Override
	public List<Constructure> getConstructures() {
		return this.constructures;
	}

	@Override
	public void acquireMoney() {
		this.money += 2;
	}

	@Override
	public void acquireConstucture() {
		Constructure[] selectables = this.game.getTop2Constructures();
		
		if ( ArrayUtil.isBlank(selectables) ) {
			// TODO I don't know what to do in this case at the moment.
			return;
		}
		
		
		
	}

	@Override
	public void buildConstructure(Constructure constructure) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser() {
		return this.user;
	}

}
