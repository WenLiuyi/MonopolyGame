package model.card;

import javax.swing.JOptionPane;

import context.GameState;

import model.PlayerModel;

/**
 * 
 * 乌龟卡,對對手或自己使用烏龜卡，會讓對手或自己連續三次只走一步。
 * 
 * 一步卡、六步卡、烏龜卡、停留卡效果會互相覆蓋。
 * 
 */
public class TortoiseCard extends Card {

	private int life = 3;

	public TortoiseCard(PlayerModel owner) {
		super(owner);
		this.name = "TortoiseCard";
		this.cName = "乌龟卡";
		this.price = 50;
	}

	@Override
	public int useCard() {
		return GameState.CARD_TORTOISE;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	/**
	 * 
	 * 卡片持续效果
	 * 
	 */
	@Override
	public int cardBuff() {
		return GameState.CARD_BUFF_TORTOISE;
	}
}
