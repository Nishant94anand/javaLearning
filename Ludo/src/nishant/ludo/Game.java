package nishant.ludo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Game {
	int numberOfCoinsPerPlayer;
	int specialNumber;
	Board board;
	Die die;
	PlayerDLLNode playingPlayerNode;
	List<Player> leaderBoard;
	Deque<Integer> moveScores;
	boolean isFinished;

	public Game() {
		System.out.println("\n====> Let's configure your game. It's gonna be fun. \n");

		board = new Board();
		Scanner sc = new Scanner(System.in);
		configureNumberOfCoins(sc);
		configurePlayers(sc);
		configureDie();
		isFinished = false;
		moveScores = new ArrayDeque<Integer>();
		System.out.println("\n====> All right ... Game is configured..\n" + this);
	}
	
	public void printLeaderBoard() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n\n").append("================= LEADERBOARD =================\n");
		sb.append(leaderBoard);
		sb.append("\n\n").append("===============================================\n");
		System.out.println(sb.toString());
	}

	public void play() {
		System.out.println("\n====> Alright!! Let's PLAY !! \n");
		while (!isFinished) {
			roll();
			System.out.println("\n==> OK.. Here's your final score order: " + moveScores);
			move();
		}
		
		System.out.println("\n\n==> Game FINISHED !!");
		printLeaderBoard();
	}

	private void move() {
		Player playingPlayer = playingPlayerNode.player;
		PlayerDLLNode nextPlayerToPlay = playingPlayerNode.next;

		while (!moveScores.isEmpty()) {
			System.out.println("\n\n==> Moving for player: " + playingPlayer.getName() + " | " + playingPlayer.getColor());
			System.out.println("Scores: " + moveScores);
			int score = moveScores.poll();
			System.out.println("\n\n==>Moving for score: " + score);
			boolean isSpecialNumber = score == specialNumber;

			Coin movedCoin = playingPlayer.makeMove(score, isSpecialNumber);

			if (movedCoin == null) {
				System.out.println("Nothing to move... going to next score");
				continue;
			}

			boolean hasCaptured = board.updateMovedCoinAndCheckCapture(movedCoin);
			
			// If player has won, there will no more moves even if there are pending scores or captures.
			if (playingPlayer.hasPlayerWon()) {
				leaderBoard.add(playingPlayer);
				PlayerDLLHelper.removeFromDLL(playingPlayerNode);
				moveScores.clear(); // clear all upcoming moves for player
				isFinished = checkIfGameIsFinished(nextPlayerToPlay);
			} else if (hasCaptured) {
				System.out.println("\n\n==>Congrats!! You captured. You get another die roll!!");
				roll(); // Roll again if captured and player has not yet won. Extra chance for capturing
			}

		}

		playingPlayerNode = nextPlayerToPlay;
	}

	private boolean checkIfGameIsFinished(PlayerDLLNode playerNode) {
		if (PlayerDLLHelper.isSinglePlayerLeft(playerNode)) {
			leaderBoard.add(playerNode.player);
			return true;
		}
		return false;

	}

	private void roll() {
		System.out.println("\n==> New Die Roll Time. Score till now: " + moveScores);
		System.out.println("\n ==> Rolling !!");
		int score = die.roll();
		System.out.println("== You scored " + score + " ==");
		recordScore(score);
	}

	private void recordScore(int score) {
		if (score == specialNumber) {
			// Check if 3 repeatations of spl number
			if (moveScores.size() >= 2) {
				Iterator<Integer> it = moveScores.descendingIterator();
				int lastScore = it.next();
				int secondLastScore = it.next();
				if (lastScore == specialNumber && secondLastScore == specialNumber) {
					System.out.println("ooops!! You got 3 in a row.. your last 2 special numbers get cancelled!!");
					moveScores.removeLast();
					moveScores.removeLast();
				} else {
					moveScores.addLast(score);
					System.out.println("\n==>Final Scores: " + moveScores);
				}
			} else {
				moveScores.addLast(score);
				System.out.println("\n==>Final Scores: " + moveScores);
			}		
			

			System.out.println("\nRoll again!!");
			roll();

		} else {
			moveScores.addLast(score);
			System.out.println("\n==>Final Scores: " + moveScores);
		}

	}

	private void configureDie() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n==== Ok.. Now what is the maximum number you want the die to return? ====");
		int maxNumber = sc.nextInt();
		die = new Die(maxNumber);

		System.out.println("\n\n==== And now that you have the die, which number do you designate to be special? ====");
		System.out.println(
				"=> Beware!! If you enter an invalid number, I will just assign the highest number of the die as the special one... So you have just 1 chance!!");

		int splNumber = sc.nextInt();

		if (splNumber < 1 || splNumber > maxNumber) {
			splNumber = maxNumber;
		}

		this.specialNumber = splNumber;
	}

	private void configureNumberOfCoins(Scanner sc) {
		System.out.println("\n\n==== Ok.. Now for the fun part.. How many coins should each player have? ====");
		System.out.println("Default ludo has 4. But don't let that stop you.\nYou can enter anything between 1 and 10. Anything else and you get only 4!!\nTell me.... How many??\n");
		
		int numOfCoinsEntered = sc.nextInt();
		numberOfCoinsPerPlayer = (numOfCoinsEntered >= 1 && numOfCoinsEntered <= 10) ? numOfCoinsEntered : 4;
	}

	private void configurePlayers(Scanner sc) {
		System.out.println("\n\n==== Ok Now .. let's configure the players! ====");

		int numberOfPlayers = configureNumberOfPlayers();
		List<Player> activePlayers = new ArrayList<>();
		leaderBoard = new ArrayList<>();

		int diff = board.getTotalSize() / numberOfPlayers;

		Set<String> colors = new HashSet<>();
//		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < numberOfPlayers; ++i) {
			System.out.println("\n\n==== Configuring Player #" + (i + 1) + " ====\n");
			int startLocation = i * diff;
			int endLocation = startLocation + board.getPlayerJourneySize() - 1;
			String color = null;

			boolean colorUnique = false;
			while (!colorUnique) {
				System.out.print("\n==>Color: ");
				if (i == 0) {					
					sc.nextLine();
				}
				
				color = sc.nextLine();

				if (colors.contains(color)) {
					System.out.println("\n ===> Color already taken. Think of something unique will you !!");
				} else {
					colorUnique = true;
					colors.add(color);
				}
			}
			
			Player player = new Player(startLocation, endLocation, numberOfCoinsPerPlayer, color, board);

			activePlayers.add(player);
		}

		this.playingPlayerNode = PlayerDLLHelper.createDLL(activePlayers);
	}

	private int configureNumberOfPlayers() {
		Scanner sc = new Scanner(System.in);
		boolean numberOfPlayersEntered = false;
		int numberOfPlayers = 1;
		int totalSize = board == null ? 0 : board.getTotalSize();

		while (!numberOfPlayersEntered) {
			System.out.println(
					"\n==> How many players do you want (minimum 2)? [The default ludo has a minimum of 2 and  maximum of 4]");
			numberOfPlayers = sc.nextInt();

			if (numberOfPlayers < 2) {
				System.out.println("\nCome on !! We need atleast 2.. Common Sense.. duh!!");
			} else if (numberOfPlayers > totalSize) {
				System.out.println(
						"\nReally ?? Higher than the board size?? Seriously!!?? Have you even configured the board properly???!!");
			} else if (totalSize % numberOfPlayers != 0) {
				System.out.println(
						"\nCome on I am not an AI!! Enter a number so that the board gets easily divided.. !!");
			} else {
				numberOfPlayersEntered = true;
			}
		}
		return numberOfPlayers;
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    sb.append("\n================== GAME ==================\n");

	    sb.append("Coins per Player : ").append(numberOfCoinsPerPlayer).append("\n");
	    sb.append("Special Number   : ").append(specialNumber).append("\n");
	    sb.append("Game Finished    : ").append(isFinished).append("\n");

//	    // Current Player
//	    sb.append("\nPlayers (Turn Order):\n");
//
//	    if (playingPlayerNode == null) {
//	        sb.append("  None\n");
//	    } else {
//	        sb.append(playingPlayerNode); // 👈 full DLL print
//	    }

	    // Move Scores
	    sb.append("\nMove Scores Queue: ");
	    if (moveScores == null || moveScores.isEmpty()) {
	        sb.append("Empty\n");
	    } else {
	        sb.append(moveScores).append("\n");
	    }

	    // Leaderboard
	    sb.append("\n==============");
	    sb.append("\nLeaderboard\n");
	    sb.append("==============\n");
	    if (leaderBoard == null || leaderBoard.isEmpty()) {
	        sb.append("  None\n");
	    } else {
	        int rank = 1;
	        for (Player p : leaderBoard) {
	            sb.append("  ").append(rank++).append(". ")
	              .append(p.getName())
	              .append(" (")
	              .append(p.getColor())
	              .append(")\n");
	        }
	    }
	    sb.append("\n==============\n\n");

	    // DLL (Players circle)
	    sb.append("\nPlayers (Turn Order)\n");
	    sb.append("=====================\n");
	    if (playingPlayerNode == null) {
	    	sb.append("\nPlayers (Turn Order)\n");
		    sb.append("---------------------\n");
	        sb.append("  None\n");
	    } else {
	        sb.append(playingPlayerNode.toString());
	    }
	    
	    // Player Details
	    sb.append("\n\n=========================== Players =========================== \n");
	    PlayerDLLNode currNode = playingPlayerNode;
	    do {
	    	sb.append("\n").append(currNode.player).append("\n");
	    	currNode = currNode.next;
	    } while (currNode != playingPlayerNode);
	    sb.append("\n\n=============================================================== \n");

	    // Board
	    sb.append("\n").append(board == null ? "Board: None\n" : board.toString());

	    // Die
	    sb.append("\n").append(die == null ? "Die: None\n" : die.toString());
	    
	    sb.append("\n===========================================\n");

	    return sb.toString();
	}

}
