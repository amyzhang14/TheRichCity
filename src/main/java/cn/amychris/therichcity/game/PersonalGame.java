package cn.amychris.therichcity.game;

import java.util.List;

import cn.amychris.therichcity.entity.User;
import cn.amychris.therichcity.exception.IllegalOperationException;
import cn.amychris.therichcity.game.constructure.Constructure;
import cn.amychris.therichcity.game.role.Role;

public class PersonalGame implements Game {

	private List<Player> players;

	private List<Constructure> constructures;

	private List<Role> availableRoles;

	private List<Role> selectedRoles;

	public PersonalGame(List<User> users, List<Constructure> constructures, List<Role> availableRoles) {
		this.constructures = constructures;
		this.availableRoles = availableRoles;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Role> getAvailableRoles() {
		return this.availableRoles;
	}

	@Override
	public List<Role> getSelectedRoles() {
		return this.selectedRoles;
	}

	@Override
	public Constructure[] getTop2Constructures() {
		if (this.constructures.isEmpty()) {
			return null;
		}

		return this.constructures.size() == 1 ? new Constructure[] { this.constructures.get(0) } 
				: new Constructure[] { this.constructures.get(0), this.constructures.get(1) };
	}

	@Override
	public void pickConstructure(Constructure constructure) {
		if ( ! this.constructures.contains(constructure) ) {
			throw new IllegalOperationException("Couldn't pick Constructure[" + constructure
					+ "], because it does not belong to constructures left in this game.");
		}
		
		this.constructures.remove(constructure);
	}

	@Override
	public List<Player> getPlayers() {
		return this.players;
	}

}
