package model.buildings;

import model.PlayerModel;
import model.TextTipModel;
import context.GameState;
import control.Control;

/**
 * @className Lottery
 * @author hcr
 * @date  2023/12/9
 **/

public class Lottery extends Building {

	private PlayerModel player;
	
	public Lottery(int posX, int posY) {
		super(posX, posY);
		this.name = "¿÷Õ∏";
	}
	
	@Override
	public int getEvent() {
		return GameState.LOTTERY_EVENT;
	}
}
