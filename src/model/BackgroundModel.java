package model;

import java.awt.*;


import javax.swing.*;

import control.GameRunning;

import ui.JPanelGame;
import util.FileUtil;

/**
 * @className BackgroundModel
 * @author hcr
 * @date  2023/12/1
 **/

public class BackgroundModel extends Tick implements Port{
	//±≥æ∞ÕºœÒ
	private Image bg = null;

	public BackgroundModel (){
	}

	/**
	 * ªÒ»°±≥æ∞Õº∆¨
	 * @return Image
	 */
	public Image getBg() {
		return bg;
	}

	/**
	 * …Ë÷√±≥æ∞Õº∆¨
	 * @param bg
	 */
	public void setBg(Image bg) {
		this.bg = bg;
	}


	//ø™ º”Œœ∑…Ë÷√
	public void startGameInit (){

		this.bg = new ImageIcon("images/background/bg_0"+GameRunning.MAP+".png").getImage();

	}

	@Override
	public void updata(long tick) {
		this.nowTick = tick;
	}


}
