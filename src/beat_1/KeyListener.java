package beat_1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(Beat.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			Beat.game.pressS();
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			Beat.game.pressD();
		}else if(e.getKeyCode() == KeyEvent.VK_F) {
			Beat.game.pressF();
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			Beat.game.pressSpace();
		}else if(e.getKeyCode() == KeyEvent.VK_J) {
			Beat.game.pressJ();
		}else if(e.getKeyCode() == KeyEvent.VK_K) {
			Beat.game.pressK();
		}else if(e.getKeyCode() == KeyEvent.VK_L) {
			Beat.game.pressL();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(Beat.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			Beat.game.releasedS();
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			Beat.game.releasedD();
		}else if(e.getKeyCode() == KeyEvent.VK_F) {
			Beat.game.releasedF();
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			Beat.game.releasedSpace();
		}else if(e.getKeyCode() == KeyEvent.VK_J) {
			Beat.game.releasedJ();
		}else if(e.getKeyCode() == KeyEvent.VK_K) {
			Beat.game.releasedK();
		}else if(e.getKeyCode() == KeyEvent.VK_L) {
			Beat.game.releasedL();
		}
	}
	
	
}
