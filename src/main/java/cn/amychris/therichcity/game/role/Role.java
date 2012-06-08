package cn.amychris.therichcity.game.role;

import java.awt.Color;


/*
 * @author Christian Chen
 */
public interface Role {

	boolean isKilled();
	
	boolean isStolen();
	
	Color getColor();
	
	RoleInfo getRoleInfo();
	
	int getPlayOrder();
	
	void acquireMoney();
	
	void acuireConstuctureCard();
	
	void buildConstructure();
	
	void performPrePassiveSkill(Role... roles);
	
	void performPostPassiveSkill(Role... roles);
	
	void performActiveSkill(Role... roles);
	
}
