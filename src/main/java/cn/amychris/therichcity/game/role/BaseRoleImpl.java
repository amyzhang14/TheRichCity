package cn.amychris.therichcity.game.role;

import cn.amychris.therichcity.game.Player;
import cn.amychris.therichcity.game.card.CardInfo;
import cn.amychris.therichcity.game.card.ConstructureCard;
import cn.amychris.therichcity.game.card.RoleCard;

public abstract class BaseRoleImpl implements RoleCard {

	private boolean isKilled = false;

	private boolean isMoneyStolen = false;

	private CardInfo roleInfo;

	private int playOrder;

	private RoleSkill prePassiveSkill;

	private RoleSkill postPassiveSkill;

	private RoleSkill activeSkill;

	@Override
	public boolean isKilled() {
		return isKilled;
	}

	protected void setKilled(boolean isKilled) {
		this.isKilled = isKilled;
	}

	@Override
	public CardInfo getCardInfo() {
		return roleInfo;
	}

	@Override
	public int getPlayOrder() {
		return playOrder;
	}

	@Override
	public void performPrePassiveSkill(RoleCard... roles) {
		this.prePassiveSkill.perform(this, roles);
	}

	@Override
	public void performPostPassiveSkill(RoleCard... roles) {
		this.postPassiveSkill.perform(this, roles);
	}

	@Override
	public void performActiveSkill(RoleCard... roles) {
		this.activeSkill.perform(this, roles);
	}

	@Override
	public void endMyTurn() {

	}

	@Override
	public void doAcquireMoney() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doAcquireConstucture() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buildConstructure(ConstructureCard constructureCard) {
		// TODO Auto-generated method stub
		
	}

}
