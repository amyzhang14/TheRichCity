package cn.amychris.therichcity.game.role;

import cn.amychris.therichcity.game.Card;

/*
 * @author Christian Chen
 */
public interface Role extends Card {

	boolean isKilled();

	boolean isStolen();

	int getPlayOrder();

	void performPrePassiveSkill(Role... roles);

	void performPostPassiveSkill(Role... roles);

	void performActiveSkill(Role... roles);

	void endMyTurn();

}
