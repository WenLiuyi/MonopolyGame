package ui.config;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.PlayerModel;
import ui.JFrameGame;
import ui.WaitFrame;
import util.FrameUtil;
import control.Control;
import control.GameRunning;

/**
 * 
 * 读取用户配置
 * 
 * */
public class FrameConfig extends JFrame {

	private JButton jbnStart = new JButton("Start");
	//private JButton jbnradom = new JButton("随机");
	private JButton jbnCancel = new JButton("Reset");
	private JButton jbnAddPlayer=new JButton("Add");


	private JTabbedPane tabs;		//选项卡

	private ImageIcon[] img = Photo.PLAYER_CHOOSE;	//可选图片列表

	private ArrayList<PlayerConfig>playerList=new ArrayList<PlayerConfig>();
	private int playerCoordinateX=12;
	private int playerCoordinateY=0;
	private char keyListener='a';

	/**
	 * 1P 2P可选人物
	 */
	private int[] chooses = { 0, 0 };
	/**
	 * 1P 2P已选人物
	 */
	private int[] selected = { -1, -2 };
	/**
	 * 1P 2P已填名字
	 */
	private String[] selectedName = { "", "" };

	//主面板
	private JFrameGame jFrameGame;
	//玩家数
	private int playerNum=2;

	//游戏配置界面
	public FrameConfig(WaitFrame wFrame,JFrameGame jFrameGame) {
		wFrame.setVisible(false);
		this.jFrameGame = jFrameGame;
		setTitle("User Setting");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置布局管理器为边界布局
		this.setLayout(new BorderLayout());
		// 添加主面板--中央
		this.add(this.createMainPanel(), BorderLayout.CENTER);
		// 添加按钮面板--下方
		this.add(this.createButtonPanel(), BorderLayout.SOUTH);
		this.setResizable(true);
		this.setSize(1200, 800);
		// 居中对齐
		FrameUtil.setFrameCenter(this);
		setVisible(true);
	}

	//添加主面板
	private JTabbedPane createMainPanel() {
		this.tabs = new JTabbedPane();
		this.tabs.setOpaque(false);
		this.tabs.add("Characters", this.createPlayerSelectPanel());
		this.tabs.setToolTipTextAt(0, "choose Characters");
		this.tabs.add("Maps", this.createMapSelectPanel());
		this.tabs.setToolTipTextAt(1, "Choose map");
		this.tabs.add("Rules", this.createGameSelectPanel());
		this.tabs.setToolTipTextAt(2, "Set victory conditions");
		return tabs;
	}

	/**
	 * 
	 * 游戏胜利条件设置
	 * 
	 */
	private Component createGameSelectPanel() {
		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.setBackground(new Color(235,236,237));

		//1.设置游戏天数：
		final JPanel dayPanel = new JPanel();
		dayPanel.setBorder(BorderFactory.createTitledBorder(""));
		JLabel day = new JLabel("Game Days");
		final String[] days = { "no limit", "20", "40", "80", "120", "240", "480" };
		final Choice daysChoice = new Choice();

		for (String a : days) {
			daysChoice.add(a);
		}
		daysChoice.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String str = days[daysChoice.getSelectedIndex()];
				if (str.equals("no limit")) {
					GameRunning.GAME_DAY = -1;
				} else {
					GameRunning.GAME_DAY = Integer.parseInt(str);	//转为整数
				}
			}
		});
		dayPanel.add(day);
		dayPanel.add(daysChoice);

		//2.设置获胜所需钱数：
		JPanel moneyPanel = new JPanel();
		moneyPanel.setBorder(BorderFactory.createTitledBorder(""));
		JLabel money = new JLabel("Money for victory");
		final String[] money_ = { "no limit", "10000", "20000", "40000", "80000",
				"200000" };
		final Choice moneyChoice = new Choice();
		for (String a : money_) {
			moneyChoice.add(a);
		}
		moneyChoice.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String str = money_[moneyChoice.getSelectedIndex()];
				if (str.equals("no limit")) {
					GameRunning.MONEY_MAX = -1;
				} else {
					GameRunning.MONEY_MAX = Integer.parseInt(str);
				}
			}
		});
		moneyPanel.add(money);
		moneyPanel.add(moneyChoice);

		//3.设置玩家初始资本：
		JPanel cashPanel = new JPanel();
		cashPanel.setBorder(BorderFactory.createTitledBorder(""));
		JLabel cash = new JLabel("initial capital");
		final String[] cash_ = { "1000", "2000", "5000", "7000", "10000",
				"20000" };
		final Choice cashChoice = new Choice();
		for (String a : cash_) {
			cashChoice.add(a);
		}
		cashChoice.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String str = cash_[cashChoice.getSelectedIndex()];
					GameRunning.PLAYER_CASH = Integer.parseInt(str);
//					System.out.println(GameRunning.PLAYER_CASH);
				}
		});
		cashPanel.add(cash);
		cashPanel.add(cashChoice);

		//4.设置游戏的胜利条件：
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(BorderFactory.createTitledBorder(""));
		JLabel info = new JLabel();
		info.setText("<html>Change Victory Conditions.<strong>(Regard bankrupt as failure in default.</strong></html>");
		infoPanel.add(info);

		panel.add(dayPanel);
		panel.add(moneyPanel);
		panel.add(cashPanel);
		panel.add(infoPanel);
		return panel;
	}

	/**
	 * 
	 * 地图选择面板
	 * 
	 */
	private JPanel createMapSelectPanel() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout());
		jp.setBackground(new Color(235,236,237));
		JPanel lPane = new JPanel(new BorderLayout());
		String[] maps = { "\"China Map\"", "\"World Map\"" };
		final ImageIcon[] maps1 = {
				new ImageIcon("images/map/1.png"),
				new ImageIcon("images/map/2.png"),
				//new ImageIcon("images/map/3.png")
		};
		final JList jlst = new JList(maps);
		jlst.setSelectedIndex(0);
		final JLabel mapV = new JLabel(maps1[0]);
		final JButton ok = new JButton("Confirm");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameRunning.MAP = jlst.getSelectedIndex() + 1;
				ok.setText("selected");
			}
		});
		jlst.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				mapV.setIcon(maps1[jlst.getSelectedIndex()]);
				ok.setText("Confirm");
			}
		});
		lPane.add(jlst);
		lPane.add(ok, BorderLayout.SOUTH);
		JPanel rPane = new JPanel();
		rPane.add(mapV);
		JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				false, lPane, rPane);
		jp.add(jSplitPane);
		return jp;
	}

	/**
	 * 人物选择面板
	 * */
	private JPanel createPlayerSelectPanel() {
		JPanel jp = new JPanel();
		jp.setLayout(null);
		jp.setBackground(new Color(235,236,237));

		PlayerConfig player1=new PlayerConfig();
		PlayerConfig player2=new PlayerConfig();
		// 增加1P面板
		addPlayerConfig(playerCoordinateX, playerCoordinateY,player1, jp);
		// 增加2P面板
		addPlayerConfig(playerCoordinateX, playerCoordinateY,player2, jp);
		playerList.add(player1);
		playerList.add(player2);
		//增加添加玩家按钮
		addPlayer(jp);
		// 增加重置按钮
		addCancelButton(jp);
		return jp;
	}
	private void addPlayer(JPanel panel){
		jbnAddPlayer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				if(playerNum>=4) return;
				PlayerConfig newPlayer=new PlayerConfig();
				addPlayerConfig(playerCoordinateX, playerCoordinateY, newPlayer,panel);
				playerList.add(newPlayer);
				playerNum+=1;
			}
		});
		jbnAddPlayer.setBounds(12, 235, 80, 30);
		panel.add(jbnAddPlayer);
	}

	private void addCancelButton(JPanel panel) {
		jbnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int cnt=0;
				for(PlayerConfig player:playerList)
				{
					reLoad(player,cnt);
					cnt++;
				}
			}

			/**
			 * 重新加载 人物选择选项卡
			 */
			private void reLoad(PlayerConfig player,int cnt) {
				player.leftButton.setEnabled(true);
				player.rightButton.setEnabled(true);
				player.jlPlayerSelected.setVisible(false);
				player.jlPlayerChoose.setIcon(img[0]);
				player.jbnPlayerNameField.setText("");
				player.jbnPlayerNameField.setEditable(true);

				selected[cnt] = -cnt-1;
				chooses[cnt] = 0;
				repaint();
			}
		});
		jbnCancel.setBounds(256 + 7, 235, 80, 30);
		panel.add(jbnCancel);
	}

	/**
	 * 增加1P面板
	 */
	private void addPlayerConfig(int x, int y, PlayerConfig player,JPanel jp) {
		// 创建 人物图像label
		player.jlPlayerChoose = new JLabel(img[chooses[0]]);
		player.jlPlayerChoose.setBounds(x + 8, y, 128, 128);
		// 创建人物图像已选择label
		player.jlPlayerSelected.setBounds(x + 8, y, 128, 128);
		player.jlPlayerSelected.setVisible(false);
		// 创建左按钮
		player.leftButton = this.createButton(x, 92 + y, Photo.BUTTON_LEFT, keyListener);

		playerCoordinateX+=200;
		keyListener+=1;

		// 添加监听事件:向前切换图片
		player.leftButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 设置为循环
				if (chooses[0] <= 0) {
					chooses[0] = img.length;
				}
				player.jlPlayerChoose.setIcon(img[--chooses[0]]);
			}
		});

		jp.add(player.leftButton);
		// 创建右按钮
		player.rightButton = this.createButton(128 + x, 92 + y, Photo.BUTTON_RIGHT,
				keyListener);
		// 添加监听事件：向后切换图片
		player.rightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 设置循环
				if (chooses[0] >= img.length - 1) {
					chooses[0] = -1;
				}
				player.jlPlayerChoose.setIcon(img[++chooses[0]]);
			}
		});
		jp.add(player.rightButton);
		jp.add(player.jlPlayerSelected);
		jp.add(player.jlPlayerChoose);
		// 增加名字框
		player.jbnPlayerNameLabel.setBounds(x + 12, y + 128 + 36, 50, 30);
		player.jbnPlayerNameField.setBounds(x + 12 + 30, y + 128 + 36, 120 - 30, 30);

		//添加至面板上
		jp.add(player.jbnPlayerNameLabel);
		jp.add(player.jbnPlayerNameField);
	}

	/**
	 * 
	 * 图标按钮
	 * 
	 * */
	public JButton createButton(int x, int y, ImageIcon[] img, char keyLinstenr) {
		JButton add = new JButton("", img[0]);
		add.setPressedIcon(img[3]);
		add.setRolloverIcon(img[2]);
		add.setMnemonic(keyLinstenr);
		add.setBounds(x, y, img[0].getIconWidth(), img[0].getIconHeight());
		return add;
	}

	/**
	 * 添加按钮面板
	 */
	private JPanel createButtonPanel() {
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		// 开始按钮添加监听器
		jbnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (selected[0] < 0 || selected[1] < 0) {
					JOptionPane.showMessageDialog(null, "请完成人物设置!");
				} else if (selectedName[0].equals("")
						|| selectedName[1].equals("")) {
					JOptionPane.showMessageDialog(null, "请完成名字设置!");
				} else {
					int choose = JOptionPane.showConfirmDialog(null, "是否开始？");
					if (choose == JOptionPane.OK_OPTION) {
						// 开始游戏
						startGame();
					}
				}
			}

			/**
			 * 开始游戏
			 * */
			private void startGame() {
				setVisible(false);
				jFrameGame.setVisible(true);
				Control control = jFrameGame.getPanelGame().getControl();
				// 处理玩家数据配置
				dealPlayers(control);
				// 控制器启动
				control.start();
			}

			/**
			 * 处理玩家数据配置
			 */
			private void dealPlayers(Control control) {
				List<PlayerModel> tempPlayer = control.getPlayers();
				// 传入名字
				tempPlayer.get(0).setName(selectedName[0]);
				tempPlayer.get(1).setName(selectedName[1]);
				// 传入使用角色编号
				tempPlayer.get(0).setPart(selected[0]);
				tempPlayer.get(1).setPart(selected[1]);
				// 传入 角色对立角色
				tempPlayer.get(0).setOtherPlayer(tempPlayer.get(1));
				tempPlayer.get(1).setOtherPlayer(tempPlayer.get(0));
			}

		});

		jp.add(jbnStart);
		//jp.add(jbnradom);
		return jp;
	}
}
