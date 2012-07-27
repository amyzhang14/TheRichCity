package cn.amychris.therichcity.game.role;

import cn.amychris.therichcity.game.card.RoleCard;


public interface RoleSkill {

	void perform (RoleCard myself, RoleCard... targets);
	
}
