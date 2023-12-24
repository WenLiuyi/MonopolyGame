package main;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.jtattoo.plaf.mint.MintLookAndFeel;

import ui.JFrameGame;
import ui.WaitFrame;
import ui.config.FrameConfig;
/**
 * @className Main
 * @author wly
 * @date  2023/11/3
 **/


public class Main {

	static {
		// 设置样式
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel(new MintLookAndFeel());//绿色边框
			//UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
			UIManager.put("OptionPane.okButtonText", "OK");
		} catch (Exception e1) {
			
		}
	}

	public static void main(String[] args) {
		// 建立等待界面
		
		WaitFrame wFrame = new WaitFrame();
		// 建立游戏主窗口
		JFrameGame frame = new JFrameGame();
		// 建立游戏配置窗口
		new FrameConfig(wFrame,frame);
		
		try {
			Music.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
