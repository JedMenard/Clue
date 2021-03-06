package clueGame;

import java.util.*;

public class ComputerPlayer extends Player {
	
	public ComputerPlayer(String n){
		super();
		super.setPlayerName(n);
	}

	public ComputerPlayer() {
		super();
	}

	public BoardCell pickLocation(Set<BoardCell> targets) {
		ArrayList<BoardCell> doors = new ArrayList<BoardCell>();
		ArrayList<BoardCell> notDoors = new ArrayList<BoardCell>();
		
		BoardCell chosenCell;
		
		Random r = new Random();
		
		for(BoardCell t : targets) {
			if(t == super.lastCell) {
				notDoors.add(t);
			} else if(t.isDoorway()) {
				doors.add(t);
			} else {
				notDoors.add(t);
			}
		}
				
		if(doors.size() > 0) {
			int ran = r.nextInt(doors.size());
			chosenCell = doors.get(ran);
		} else {
			int ran = r.nextInt(notDoors.size());
			chosenCell = notDoors.get(ran);
		}
		
		return chosenCell;
	}
	
	public void makeAccustation(Board board) {
		
	}
	
	public Solution makeSuggestion(Board board, BoardCell location) {
		Random r = new Random();
		ArrayList<Card> weaps = new ArrayList<Card>();
		ArrayList<Card> peeps = new ArrayList<Card>();
		for (Card c: board.deck.deck) {
			if (!seenCard(c)){
				if (c.getType() == CardType.WEAPON) weaps.add(c);
				else if (c.getType() == CardType.PERSON) peeps.add(c);
			}
		}
		
		String person = peeps.get(r.nextInt(peeps.size())).getName();
		String weapon = weaps.get(r.nextInt(weaps.size())).getName();
		String room = location.getName();
		
		return new Solution(person, room, weapon);
	}
	
	private boolean seenCard(Card card) {
		for(Card c : seenCards) {
			if(c.equals(card)) {
				return true;
			}
		} 
		return false;
	}
}
