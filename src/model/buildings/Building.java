package model.buildings;

import java.awt.Graphics;

import model.Port;
import model.PlayerModel;

import control.Control;

/**
 * @className Building
 * @author hcr
 * @date  2023/12/7
 **/

public class Building{
	/**
	 * 
	 * 房屋拥有者
	 * 
	 */
	protected PlayerModel owner = null;

	/**
	 * 房屋名称
	 */
	protected String name;

	/**
	 * 可购买性
	 */
	protected boolean purchasability = false;

	/**
	 * 购买空地的价格
	 */
	protected int price;
	/**
	 * 税
	 */
	protected int revenue;
	/**
	 * 当前房屋等级
	 */
	protected int level;

	/**
	 * 
	 * 横坐标
	 * 
	 */
	protected int posX;
	/**
	 * 纵坐标
	 */
	protected int posY;
	/**
	 * 最大等级
	 */
	protected int maxLevel;

	/**
	 *
	 * @param posX
	 * @param posY
	 */
	public Building(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	/**
	 *
	 * @return boolean
	 */
	public boolean isPurchasability() {
		return purchasability;
	}

	/**
	 *
	 * @param purchasability
	 */
	public void setPurchasability(boolean purchasability) {
		this.purchasability = purchasability;
	}

	/**
	 * 是否可以升级
	 * @return boolean
	 */
	public boolean canUpLevel() {
		return this.level < maxLevel;
	}

	/**
	 *
	 * @return PlayerModel
	 */
	public PlayerModel getOwner() {
		return owner;
	}

	/**
	 * 设置当前玩家
	 * @param owner
	 */
	public void setOwner(PlayerModel owner) {
		this.owner = owner;
	}

	/**
	 *
	 * @return int
	 */
	public int getLevel() {
		return level;
	}

	/**
	 *
	 * @param level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * 获取姓名
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * 获取姓名
	 * @return String
	 */
	public String getUpName() {
		return name;
	}

	/**
	 *
	 * @return int
	 */
	public int getUpLevelPrice() {
		return price;
	}
	/**
	 * 获取房屋总价值
	 * @return int
	 */
	public int getAllPrice() {
		return 0;
	}

	/**
	 * 获取过路费
	 * @return int
	 */
	public int getRevenue() {
		return revenue;
	}

	/**
	 * 获取横坐标
	 * @return int
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * 获取纵坐标
	 * @return int
	 */
	public int getPosY() {
		return posY;
	}
	/**
	 * 触发事件
	 * @return int
	 */
	public int getEvent() { return 0;}
	
	/**
	 * 路过事件
	 * @return int
	 */
	public int passEvent() { return 0;}

	/**
	 * 绘制
	 * @param g
	 */

	public void paint(Graphics g){}

	
}	
