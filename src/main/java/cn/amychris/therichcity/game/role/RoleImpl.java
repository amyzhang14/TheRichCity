package cn.amychris.therichcity.game.role;

import java.awt.Color;


public class RoleImpl implements Role {
	
	private boolean isKilled = false;;
	
	private boolean isStolen = false;
	
	private RoleInfo roleInfo;
	
	private Color color;
	
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
	public boolean isStolen() {
		return isStolen;
	}


	protected void setStolen(boolean isStolen) {
		this.isStolen = isStolen;
	}

	@Override
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public int getPlayOrder() {
		return playOrder;
	}

	@Override
	public void performPrePassiveSkill(Role... roles) {
		this.prePassiveSkill.perform(this, roles);
	}

	@Override
	public void performPostPassiveSkill(Role... roles) {
		this.postPassiveSkill.perform(this, roles);
	}

	@Override
	public void performActiveSkill(Role... roles) {
		this.activeSkill.perform(this, roles);
	}

	@Override
	public void acquireMoney() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildConstructure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acuireConstuctureCard() {
		// TODO Auto-generated method stub
		
	}


}
