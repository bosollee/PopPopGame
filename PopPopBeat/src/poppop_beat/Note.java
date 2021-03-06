package poppop_beat;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import poppop_beat.Main;

public class Note extends Thread {
	private int noteSpeed = 10;
	private int sleepTime = 10;
	private int reachTime = 2;
	private boolean proceeded = true;

	public String getNoteType() {
		return noteType;
	}

	public boolean isProceeded() {
		return proceeded;
	}

	public void close() {
		proceeded = false;
	}

	private Image noteImage = new ImageIcon(Main.class.getResource("../images/note.png")).getImage();
	private int x, y = 850 - (1000 / sleepTime * noteSpeed) * reachTime;
	private String noteType;

	public Note(String noteType) {
		if (noteType.equals("Left")) {
			x = 600;
		} else if (noteType.equals("Up")) {
			x = 750;
		} else if (noteType.equals("Space")) {
			x = 900;
		} else if (noteType.equals("Down")) {
			x = 1050;
		} else if (noteType.equals("Right")) {
			x = 1200;
		}
		this.noteType = noteType;
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteImage, x, y, null);
	}

	public void drop() {
		y += noteSpeed;
		if (y > 910) {
			System.out.println("Miss!");
			close();
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				drop();
				if (proceeded) {
					Thread.sleep(10);
				} else {
					interrupt();
					break;
				}
				Thread.sleep(sleepTime);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public String judge() {
		if (y >= 910) {
			System.out.println("Late");
			close();
			return "Late";
		} else if (y >= 890) {
			System.out.println("Great");
			close();
			return "Great";
		} else if (y >= 870) {
			System.out.println("Prefect");
			close();
			return "Perfect";
		} else if (y >= 850) {
			System.out.println("Early");
			close();
			return "Early";
		} else if (y >= 830) {
			System.out.println("Miss");
			close();
			return "Miss";
		}
		return "None";
	}
	
	public int getY(){
		return y;
	}
}
