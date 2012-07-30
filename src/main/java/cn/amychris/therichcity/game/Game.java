package cn.amychris.therichcity.game;

import java.util.List;

import cn.amychris.therichcity.game.card.ConstructureCard;
import cn.amychris.therichcity.game.card.RoleCard;

public interface Game extends Runnable {

	List<RoleCard> getAvailableRoles();
	
	List<RoleCard> getSelectedRoles();
	
	ConstructureCard[] getTop2Constructures();
	
	void pickConstructure(ConstructureCard constructureCard);
	
	List<Player> getPlayers();
}
