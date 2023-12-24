package model.card;

import javax.swing.JOptionPane;

import context.GameState;

import model.PlayerModel;
import model.buildings.Building;

/**
 * 
 * 加盖卡,当前房屋加盖一层
 * OK
 * 
 */

/**
 * @className AddLevelCard
 * @author hcr
 * @date  2023/12/1
 **/
public class AddLevelCard extends Card {

	/**
	 *
	 * @param owner
	 */
	public AddLevelCard(PlayerModel owner) {
		super(owner);
		this.name = "AddLevelCard";
		this.cName = "加盖卡";
		this.price = 30;

	}

	@Override
	public int useCard() {
		return GameState.CARD_ADDLEVEL;
	}

}
