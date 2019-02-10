package poppop_beat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	@Override
	public void keyPressed(KeyEvent e) {
		if (PopPopBeat.game == null) {
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			PopPopBeat.game.pressLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			PopPopBeat.game.pressUp();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			PopPopBeat.game.pressSpace();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			PopPopBeat.game.pressDown();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			PopPopBeat.game.pressRight();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (PopPopBeat.game == null) {
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			PopPopBeat.game.releaseLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			PopPopBeat.game.releaseUp();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			PopPopBeat.game.releaseSpace();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			PopPopBeat.game.releaseDown();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			PopPopBeat.game.releaseRight();
		}
	}

}
