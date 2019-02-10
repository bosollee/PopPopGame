package poppop_beat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import poppop_beat.Main;

public class Game extends Thread {
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();

	private Image noteRoadLeftImage = new ImageIcon(Main.class.getResource("../images/noteRoad.png")).getImage();
	private Image noteRoadUpImage = new ImageIcon(Main.class.getResource("../images/noteRoad.png")).getImage();
	private Image noteRoadSpaceImage = new ImageIcon(Main.class.getResource("../images/noteRoad.png")).getImage();
	private Image noteRoadDownImage = new ImageIcon(Main.class.getResource("../images/noteRoad.png")).getImage();
	private Image noteRoadRightImage = new ImageIcon(Main.class.getResource("../images/noteRoad.png")).getImage();
	private Image judgeImage;

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	private int score=0;

	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}

	public void screenDraw(Graphics2D g) {

		g.drawImage(noteRoadLeftImage, 600, 0, null);
		g.drawImage(noteRoadUpImage, 750, 0, null);
		g.drawImage(noteRoadSpaceImage, 900, 0, null);
		g.drawImage(noteRoadDownImage, 1050, 0, null);
		g.drawImage(noteRoadRightImage, 1200, 0, null);
		g.drawImage(judgementLineImage, 100, 850, null);

		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (note.getY() > 910) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/miss.png")).getImage();
			}
			if (!note.isProceeded()) {
				noteList.remove(i);
				i--;
			} else {
				note.screenDraw(g);
			}
		}

		g.drawImage(gameInfoImage, 100, 980, null);
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Land", Font.BOLD, 60));
		g.drawString(titleName, 150, 1050);
		g.drawString(String.valueOf(score), 900, 1050);
		g.drawString(difficulty, 1700, 1050);
		g.drawImage(judgeImage, 800, 300, null);
	}

	public void pressLeft() {
		judge("Left");
		noteRoadLeftImage = new ImageIcon(Main.class.getResource("../images/noteRoadPressed.png")).getImage();
	}

	public void releaseLeft() {
		noteRoadLeftImage = new ImageIcon(Main.class.getResource("../images/noteRoad.png")).getImage();
	}

	public void pressUp() {
		judge("Up");
		noteRoadUpImage = new ImageIcon(Main.class.getResource("../images/noteRoadPressed.png")).getImage();
	}

	public void releaseUp() {
		noteRoadUpImage = new ImageIcon(Main.class.getResource("../images/noteRoad.png")).getImage();
	}

	public void pressSpace() {
		judge("Space");
		noteRoadSpaceImage = new ImageIcon(Main.class.getResource("../images/noteRoadPressed.png")).getImage();
	}

	public void releaseSpace() {
		noteRoadSpaceImage = new ImageIcon(Main.class.getResource("../images/noteRoad.png")).getImage();
	}

	public void pressDown() {
		judge("Down");
		noteRoadDownImage = new ImageIcon(Main.class.getResource("../images/noteRoadPressed.png")).getImage();
	}

	public void releaseDown() {
		noteRoadDownImage = new ImageIcon(Main.class.getResource("../images/noteRoad.png")).getImage();
	}

	public void pressRight() {
		judge("Right");
		noteRoadRightImage = new ImageIcon(Main.class.getResource("../images/noteRoadPressed.png")).getImage();
	}

	public void releaseRight() {
		noteRoadRightImage = new ImageIcon(Main.class.getResource("../images/noteRoad.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes(this.titleName);
	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if (titleName.equals("Chill") && difficulty.equals("Easy")) {
			int startTime = 1500;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime + gap * 1, "Left"), 
					new Beat(startTime + gap * 3, "Up"),
					new Beat(startTime + gap * 5, "Right"), 
					new Beat(startTime + gap * 7, "Right"),
					new Beat(startTime + gap * 10, "Down"), 
					new Beat(startTime + gap * 13, "Down"),
					new Beat(startTime + gap * 16, "Left"),
					new Beat(startTime + gap * 22, "Space"),
					new Beat(startTime + gap * 28, "Space"),//
					new Beat(startTime + gap * 40, "Up"),
					new Beat(startTime + gap * 44, "Down"),
					new Beat(startTime + gap * 56, "Down"),
					new Beat(startTime + gap * 58, "Space"),
					new Beat(startTime + gap * 60, "Space"),
					new Beat(startTime + gap * 62, "Up"),
					new Beat(startTime + gap * 65, "Right"),
					new Beat(startTime + gap * 68, "Right"),
					new Beat(startTime + gap * 71, "Up"),
					new Beat(startTime + gap * 74, "Up"),
					new Beat(startTime + gap * 80, "Left"),
					new Beat(startTime + gap * 86, "Left"),
					new Beat(startTime + gap * 92, "Down"),
					new Beat(startTime + gap * 98, "Down"),
					new Beat(startTime + gap * 110, "Right"),
					new Beat(startTime + gap * 114, "Down"),
					new Beat(startTime + gap * 126, "Right"),

					new Beat(startTime + gap * 130, "Up"),
					new Beat(startTime + gap * 132, "Right"),
					new Beat(startTime + gap * 134, "Up"),
					new Beat(startTime + gap * 136, "Left"),
					new Beat(startTime + gap * 139, "Left"),
					new Beat(startTime + gap * 142, "Down"),
					new Beat(startTime + gap * 145, "Space"),
					new Beat(startTime + gap * 148, "Space"),
					


			}; // Chill easy 난이도 노트
		} else if (titleName.equals("Deep Dreams") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] { new Beat(startTime, "Space"), }; // Deep Dreams easy 난이도 미완성																// 노트
		} else if (titleName.equals("White Winds") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] { new Beat(startTime, "Space"), }; // White Winds easy 난이도 미완성
		}

		int i = 0;
		gameMusic.start();

		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void judge(String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}

	public int judgeEvent(String judge) {
		if (judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/late.png")).getImage();
			score += 60;
		} else if (judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/great.png")).getImage();
			score += 100;
		} else if (judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/perfect.png")).getImage();
			score += 150;
		} else if (judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/early.png")).getImage();
			score += 60;
		}return score;

	}

}
