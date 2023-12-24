package ui;

import java.awt.Graphics;
import java.awt.Image;

import util.FileUtil;

import model.BackgroundModel;
import java.awt.Color;

/**
 * @className Background
 * @author xjy
 * @date  2023/12/2
 **/

public class Background extends Layer {
	//背景图片
	private Image bg = null;
	//背景模型
	private BackgroundModel background = null;
	private JPanelGame panel;

	/**
	 *
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param background
	 * @param panel
	 */
	public Background(int x, int y, int w, int h,
			BackgroundModel background,JPanelGame panel) {
		super(x, y, w, h);
		this.background = background;
		this.panel = panel;
	}

	/**
	 * 绘制背景
	 * @param g  the <code>Graphics</code> context in which to paint
	 */
	public void paint(Graphics g) {
		this.paintBg(g);
	}

	/**
	 * 将窗体隐藏
	 */
	public void moveToBack() {
		this.panel.getLayeredPane().moveToBack(this);
	}

	/**
	 * 将窗体显现
	 */
	public void moveToFront() {
		this.panel.getLayeredPane().moveToFront(this);
	}
	
	//背景绘制方法

	/**
	 *
	 * @param g
	 */
	public void paintBg(Graphics g){
		// 绘制背景图像
		g.drawImage(this.bg, 0, 0, getWidth(), getHeight(), null);

		// 绘制边框
		int borderWidth = 5; // 你可以根据需要调整边框的宽度
		g.setColor(new Color(0,0,0)); // 设置边框颜色为黑色
		g.fillRect(0, 0, getWidth(), borderWidth); // 上边框
		g.fillRect(0, 0, borderWidth, getHeight()); // 左边框
		g.fillRect(getWidth() - borderWidth, 0, borderWidth, getHeight()); // 右边框
		g.fillRect(0, getHeight() - borderWidth, getWidth(), borderWidth); // 下边框

	}


	@Override
	public void startPanel() {
		this.bg = background.getBg();
	}

}
