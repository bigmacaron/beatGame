package beat_1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Beat extends JFrame {
	
	
	// 더블 버퍼를 위한 것
	private Image screenImage;
	private Graphics scrrenGraphic;

	// 메인클래스의 위치를 기반으로 리소스를 얻어와서 넣음
	// 메뉴바 생성
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	// 버튼생성
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/closeEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/closeBasic.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introbackground.png")).getImage();

	

	//생성한 이미지 사용
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);

	private int mouseX, mouseY;

	private boolean isMainScreen = false; // 트랙 이미지 불린값
	private boolean isGameScreen = false; // 게임으로 온건지 체크여부
	
	
	// 배경음악
	private Music introMusic = new Music("introMusic.mp3", true);
	

	// 트랙 부분 리스트
	ArrayList<Track> trackList = new ArrayList<Track>();
	private Music selectedMusic;
	private Music gameMusic;
	private Image titleImage;
	private Image selectedImage;
	private int nowSelected = 0;
	
	
	public static Game game = new Game();

	// 실행 함수
	public Beat() {
		setUndecorated(true); // 메뉴바가 안보이게됨 (윈도우 기본 메뉴바)
		setTitle("Beat Game!");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임창 사이즈
		setResizable(false); // 게임창 크기 변경 불가
		setLocationRelativeTo(null); // 게임창 중앙실행
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임창 닫으면 프로그램 종료
		setVisible(true);// 화면에 출력 여부 기본값은 false 라서 설정해줘야함
		setBackground(new Color(0, 0, 0, 0));// 메뉴바 색을 하얀색으로(윈도우 기본 메뉴바)
		setLayout(null); // 위치를 그대로 꽃아줌 윈도우 기본메뉴바처럼
		
		addKeyListener(new KeyListener());
		
		introMusic.start();
		

		trackList.add(new Track("밤의멜로디title.png", "밤의멜로디start.png", "밤의멜로디game.png",
				"밤의멜로디select.mp3", "밤의멜로디.mp3","브라운 아이드 소울 - 밤의 멜로디"));
		trackList.add(new Track("오르막길title.png", "오르막길start.png", "오르막길game.png",
				"오르막길select.mp3", "오르막길.mp3" ,"윤종신 - 오르막길"));
		trackList.add(new Track("parisintheraintitle.png", "parisintherainstart.png", "parisintheraingame.png",
				"parisintherainselect.mp3", "parisintherain.mp3","Lauv - paris in the rain"));
		trackList.add(new Track("lovemyselftitle.png", "lovemyselfstart.png", "lovemyselfgame.png",
				"lovemyselfselect.mp3", "lovemyself.mp3","BTS - Answer : Love Myself"));

		// exit 버튼 설정 (추후 다시만듬)
		exitButton.setBounds(1250, 5, 20, 20); // 위치
		exitButton.setBorderPainted(false); // 선제거
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 마우스 올라가면 손모양
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 빠져나오면 디폴트
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("clickSound.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(500);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);

		startButton.setBounds(400, 450, 400, 100); // 위치
		startButton.setBorderPainted(false); // 선제거
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 마우스 올라가면 손모양

			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 빠져나오면 디폴트
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("clickSound.mp3", false);
				buttonPressedMusic.start();
				enterMain();

			}
		});
		add(startButton);

		quitButton.setBounds(400, 550, 400, 100); // 위치
		quitButton.setBorderPainted(false); // 선제거
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 마우스 올라가면 손모양

			}

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 빠져나오면 디폴트
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("clickSound.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);

			}
		});
		add(quitButton);

		// 메뉴바 위치와 크기
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

		leftButton.setVisible(false);
		leftButton.setBounds(150, 310, 60, 60); // 위치
		leftButton.setBorderPainted(false); // 선제거
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 마우스 올라가면 손모양

			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 빠져나오면 디폴트
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("clickSound.mp3", false);
				buttonPressedMusic.start();
				selectLeft();
			}
		});
		add(leftButton);

		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60); // 위치 및 크기
		rightButton.setBorderPainted(false); // 선제거
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 마우스 올라가면 손모양

			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 빠져나오면 디폴트
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("clickSound.mp3", false);
				buttonPressedMusic.start();
				selectRight();
			}
		});
		add(rightButton);

		easyButton.setVisible(false);
		easyButton.setBounds(0, 500, 200, 200); // 위치 및 크기
		easyButton.setBorderPainted(false); // 선제거
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 마우스 올라가면 손모양

			}

			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 빠져나오면 디폴트
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("clickSound.mp3", false);
				buttonPressedMusic.start();
				gameStart(nowSelected,"easy");
			}
		});
		add(easyButton);
		
		hardButton.setVisible(false);
		hardButton.setBounds(150, 500, 200, 200); // 위치 및 크기
		hardButton.setBorderPainted(false); // 선제거
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 마우스 올라가면 손모양

			}

			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 빠져나오면 디폴트
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("clickSound.mp3", false);
				buttonPressedMusic.start();
				gameStart(nowSelected,"hard");
			}
		});
		add(hardButton);
		
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 64, 64); // 위치 및 크기
		backButton.setBorderPainted(false); // 선제거
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));// 마우스 올라가면 손모양

			}

			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 빠져나오면 디폴트
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("clickSound.mp3", false);
				buttonPressedMusic.start();
				backMain();
				isGameScreen = false;
			}
		});
		add(backButton);

		
		
		
		
		
		
		
		
	}

	// 약속된 함수 가장먼저 이미지를 넣어줌
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 버퍼이미지 크기
		scrrenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)scrrenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	private void screenDraw(Graphics2D   g) {
		g.drawImage(background, 0, 0, null);

		if (isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 550, null);
		}
		if (isGameScreen) {
			game.scrrenDraw(g);
			
		}

		paintComponents(g);// JLabel 그리는방법 주로 고정된이미지를 구현
		this.repaint(); // 계속 호출

	}

	// 음악 트랙 선택부분
	public void selectTrack(int nowSelected) {
		if (selectedMusic != null) {
			selectedMusic.close();
		}
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage()))
				.getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage()))
				.getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();

	}

	public void selectLeft() {
		if (nowSelected == 0) {
			nowSelected = trackList.size() - 1; // 제일 마지막곡으로
		} else {
			nowSelected--;
		}
		selectTrack(nowSelected);
	}

	public void selectRight() {
		if (nowSelected == trackList.size() - 1) {
			nowSelected = 0;
		} else {
			nowSelected++;
		}
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected,String difficulty) {
		if (selectedMusic != null) {
			selectedMusic.close();
		}
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getGameImage())).getImage();
		backButton.setVisible(true);
		game.setMusicTitle(trackList.get(nowSelected).getMusicTitle());
		isGameScreen = true;
		gameMusic = new Music(trackList.get(nowSelected).getGameMusic(), true);
		gameMusic.start();
		setFocusable(true);
		
		
		
	}
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		backButton.setVisible(false);
		gameMusic.close();
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.png")).getImage();
		selectTrack(nowSelected);
		isGameScreen = false;
		
	}
	public void enterMain() {
		//큰의미는 없는데 버튼 생동감 약간 주고싶어서 넣은부분
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}		
		//버튼 및 이미지 표기 여부
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.png")).getImage();
		startButton.setVisible(false);
		quitButton.setVisible(false);
		
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);	

		introMusic.close();
		selectTrack(nowSelected);
	}

}
