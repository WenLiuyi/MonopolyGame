package model.buildings;

import java.util.List;

import model.LandModel;
import model.PlayerModel;
import model.TextTipModel;

import context.GameState;
import control.Control;

/**
 * @className: Prison
 * @author: wly
 * @date:  2023/12/13
 **/

public class Prison extends Building {

	private String[] events = { "去监狱看望好友，", "被冤枉入狱，", "被监狱管理员抓去打扫卫生，" };

	private PlayerModel player;

	public Prison(int posX, int posY) {
		super(posX, posY);
		this.name = "监狱";
	}

	public String[] getEvents() {
		return events;
	}

	@Override
	public int getEvent() {
		return GameState.PRISON_EVENT;
	}
}
