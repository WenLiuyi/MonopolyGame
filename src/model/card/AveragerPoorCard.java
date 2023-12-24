package model.card;

import javax.swing.JOptionPane;

import context.GameState;

import model.PlayerModel;

/**
 * 
 * 均贫卡,對一個對手使用均貧卡，可以與此對手平分現金。
 * OK
 * 
 */
/**
 * @className AveragerPoorCard
 * @author hcr
 * @date  2023/12/4
 **/
public class AveragerPoorCard extends Card {

	/**
	 *
	 * @param owner
	 */
	public AveragerPoorCard(PlayerModel owner) {
		super(owner);
		this.name = "AveragerPoorCard";
		this.cName = "均贫卡";
		this.price = 200;
	}

	@Override
	public int useCard() {
		return GameState.CARD_AVERAGERPOOR;
	}

}
