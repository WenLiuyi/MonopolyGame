package ui;

import javax.swing.*;

import util.FrameUtil;

import java.awt.*;

@SuppressWarnings("serial")
/**
 * @className JFrameGame
 * @author wly
 * @date  2023/11/27
 **/

public class JFrameGame extends JFrame {


	//默认主panel
	private JPanelGame panelGame = null;
	
	public JFrameGame() {

		// 设置名字
		this.setTitle("MonopolyGame");
		// 设置默认关闭属性（程序结束）
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 设置窗口大小
		this.setSize(1000, 800);
		// 不允许用户改变窗口大小
		this.setResizable(true);
		// 居中
		FrameUtil.setFrameCenter(this);
		// 设置默认Panel
		this.panelGame = new JPanelGame();
		add(this.panelGame);
		
		// 设置边框显示
		this.setUndecorated(false);
	}

	public JPanelGame getPanelGame() {
		return panelGame;
	}
}
