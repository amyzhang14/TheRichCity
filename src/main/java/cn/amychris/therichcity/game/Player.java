package cn.amychris.therichcity.game;

import java.util.List;

import cn.amychris.therichcity.entity.UserEntity;
import cn.amychris.therichcity.game.constructure.Constructure;
import cn.amychris.therichcity.game.role.Role;

public interface Player {
	
	UserEntity getUser();

	Role getRole();

	boolean isManagedByServer();

	int getMoney();

	List<Constructure> getConstructures();

	void acquireMoney();

	void acuireConstucture();

	void buildConstructure(Constructure constructure);
}
