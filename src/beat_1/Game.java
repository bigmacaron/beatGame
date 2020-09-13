package beat_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

public class Game extends Thread {
	
	
	//이미지
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	private String musicTitle;
	
	public String getMusicTitle() {
		return musicTitle;
	}
	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}
	
	public void scrrenDraw(Graphics2D g) {
		g.drawImage(noteRouteLineImage,224,30,null);
		g.drawImage(noteRouteSImage,228,30,null);
		g.drawImage(noteRouteLineImage,328,30,null);
		g.drawImage(noteRouteDImage,332,30,null);
		g.drawImage(noteRouteLineImage,432,30,null);
		g.drawImage(noteRouteFImage,436,30,null);
		g.drawImage(noteRouteLineImage,536,30,null);
		g.drawImage(noteRouteSpace1Image,540,30,null);
		g.drawImage(noteRouteSpace2Image,640,30,null);
		g.drawImage(noteRouteLineImage,740,30,null);
		g.drawImage(noteRouteJImage,744,30,null);
		g.drawImage(noteRouteLineImage,844,30,null);
		g.drawImage(noteRouteKImage,848,30,null);
		g.drawImage(noteRouteLineImage,948,30,null);
		g.drawImage(noteRouteLImage,952,30,null);
		g.drawImage(noteRouteLineImage,1052,30,null);
		g.drawImage(noteBasicImage,228,120,null);
		g.drawImage(noteBasicImage,332,580,null);
		g.drawImage(noteBasicImage,436,500,null);
		g.drawImage(noteBasicImage,540,340,null);
		g.drawImage(noteBasicImage,640,340,null);
		g.drawImage(noteBasicImage,744,325,null);
		g.drawImage(noteBasicImage,848,305,null);
		g.drawImage(noteBasicImage,952,305,null);
		
		//하단글자
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Cafe24Syongsyong",Font.BOLD,30));
		g.drawString(musicTitle,20, 702);
		g.drawString("Easy",1190, 702);
		g.setFont(new Font("Elephant",Font.BOLD,30));
		g.drawString("000000",565, 702);
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("S",270, 649);
		g.drawString("D",374, 649);
		g.drawString("F",478, 649);
		g.drawString("Space Bar",578, 649);
		g.drawString("J",784, 649);
		g.drawString("K",889, 649);
		g.drawString("L",993, 649);
		
		
		//하단그림
		g.drawImage(gameInfoImage,0,670,null);
		g.drawImage(judgementLineImage,226,580,null);
	}
	
	public void pressS() {noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();}
	public void pressD() {noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();}
	public void pressF() {noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();}
	
	public void pressSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		}
	
	public void pressJ() {noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();}
	public void pressK() {noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();}
	public void pressL() {noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();}
	
	public void releasedS() {noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();}
	public void releasedD() {noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();}
	public void releasedF() {noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();}
	
	public void releasedSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		}
	
	public void releasedJ() {noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();}
	public void releasedK() {noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();}
	public void releasedL() {noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();}
	
	
	@Override
	public void run() {
		}
}
