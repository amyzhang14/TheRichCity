package cn.amychris.therichcity.game.card;

import cn.amychris.therichcity.game.Player;

/*
 * @author Christian Chen
 */
public interface RoleCard extends Card {

	Player getPlayer();

	boolean isKilled();

	boolean isMoneyStolen();

	boolean isNowMyTurn();

	int getPlayOrder();

	void performPrePassiveSkill(RoleCard... roles);

	void performPostPassiveSkill(RoleCard... roles);

	void performActiveSkill(RoleCard... roles);

	void endMyTurn();

	void doAcquireMoney();

	void doAcquireConstucture();

	void buildConstructure(ConstructureCard constructureCard);

}
