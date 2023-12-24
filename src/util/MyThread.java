package util;

import control.GameRunning;
/**
 * @className MyThread
 * @author wly
 * @date  2023/11/28
 **/

public class MyThread implements Runnable{
	
	private GameRunning run;
	
	int times;
	
	int time;
	
	public MyThread (GameRunning run,int times) {
		this.run = run;
		this.times = times;
	}
	@Override
	public void run() {
		while (true) {
			if (time >= times){
				run.nextState();
				break;
			}
			time++;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void start() {
		this.run();
	}

}
