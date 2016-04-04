package clueGame;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

public class ClueGame extends JFrame {
	public static Board board;
	
	public ClueGame(){
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Clue");
		
		board = new Board();
		board.initialize();
		add(board, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		ClueGame ourGame = new ClueGame();
		
		
		ourGame.setSize((board.getNumRows()*40>1000) ? board.getNumRows()*40 : 1000, board.getNumColumns()*40);
		
		DetectiveNotes notes = new DetectiveNotes();
		notes.setSize(500,500);
		notes.setVisible(true);
		
		
		ControlGUI gui = new ControlGUI();
		ourGame.add(gui, BorderLayout.SOUTH);
		ourGame.setVisible(true);
		
	}
}
