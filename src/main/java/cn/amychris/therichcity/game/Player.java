package cn.amychris.therichcity.game;

import java.util.List;

import cn.amychris.therichcity.entity.User;
import cn.amychris.therichcity.game.constructure.Constructure;
import cn.amychris.therichcity.game.role.Role;

public interface Player {
	
	User getUser();

	Role getRole();

	boolean isManagedByServer();

	int getMoney();

	List<Constructure> getConstructures();

	void acquireMoney();

	void acquireConstucture();

	void buildConstructure(Constructure constructure);
}
