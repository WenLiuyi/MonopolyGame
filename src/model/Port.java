package model;

/**
 * @className TextTipModel
 * @author wly
 * @date  2023/12/5
 **/
public interface Port {
	/**
	 * @param tick
	 * 模型更新
	 * 
	 */
	public abstract void updata(long tick);
	
	/**
	 * 
	 * 游戏初始化
	 * 
	 */
	public abstract void startGameInit();
}
