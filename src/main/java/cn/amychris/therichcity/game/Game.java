package cn.amychris.therichcity.game;

import java.util.List;

import cn.amychris.therichcity.game.constructure.Constructure;
import cn.amychris.therichcity.game.role.Role;

public interface Game extends Runnable {

	List<Role> getAvailableRoles();
	
	List<Role> getSelectedRoles();
	
	Constructure[] getTop2Constructures();
	
	void pickConstructure(Constructure constructure);
	
	List<Player> getPlayers();
}
