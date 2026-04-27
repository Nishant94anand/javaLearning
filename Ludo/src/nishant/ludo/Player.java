package nishant.ludo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Player {
	private String playerName;
	private String playerColor;
	private int startBoardLocation;
	private int endBoardLocation;
//	private int safeLaneLength;
	private Map<Integer, Coin> idToCoinMap;
	private int completedCoins;
	private boolean playerWon;
//	private int totalBoardSize;
	private Board board;
	
	public boolean hasPlayerWon() {
		return playerWon;
	}
	
	public String getName() {
		return this.playerName;
	}
	
	public String getColor() {
		return this.playerColor;
	}
	
	public int getTotalBoardSize() {
		return this.board.getTotalSize();
	}
	
	public int getPositionOnBoardForPlayer(int pos) {		
		int boardSize = getTotalBoardSize();
		return pos % boardSize;
	}
	
	public Player(int start, int end, int numberOfCoins, String color, Board board) {
		idToCoinMap = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n==> Name: ");
		this.playerName = sc.nextLine();
		this.playerColor = color;
		this.board = board;
		this.startBoardLocation = getPositionOnBoardForPlayer(start);
		this.endBoardLocation = getPositionOnBoardForPlayer(end);
//		this.safeLaneLength = safeLength;
		completedCoins = 0;
		playerWon = false;
		
		for (int i=0; i<numberOfCoins; ++i) {
			Coin coin = new Coin(color, i, startBoardLocation, endBoardLocation, board.getSafeLaneLength(), this);
			idToCoinMap.put(i, coin);
		}
		
	}
	
	public Coin makeMove(int score, boolean isSpecialNumber) {
		if (playerWon) {
			System.out.println("\n\n===== Player "+ playerName + " with color " + playerColor + "has already won!!");
			return null;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n=================================================================================================\n");
		System.out.println("\n\n==> Player " + playerName + " with color " + playerColor + " has to move for score: " + score);		
		
		Set<Coin> eligibleCoins = getEligibleCoins(score, isSpecialNumber);
		System.out.println(eligibleCoins);
		
		if (eligibleCoins.isEmpty()) {
			System.out.println("\n===> No eligible coins!!");
			return null;
		}
		
		System.out.println("\nEligible Coins:");
		
		while (true) {			
			System.out.print("\nSelect coin id to move: ");
			int coinId = sc.nextInt();
			
			if(!idToCoinMap.containsKey(coinId) || !eligibleCoins.contains(idToCoinMap.get(coinId))) {
				System.out.println("\n===> Wrong Coin ID. Choose again!!");
			} else {
				Coin coin = idToCoinMap.get(coinId);
				coin.move(score, isSpecialNumber);			
				recordCoinComplete(coin);
				return coin;
			}
		}
	}
	
	private void recordCoinComplete(Coin coin) {
		if (coin.isComplete()) {
			completedCoins++;
			System.out.println("\n\n==> Coins completed for Player ["+ playerName + "|" + playerColor + "]: " + completedCoins);
			updatePlayerWin();
		}
	}

	private void updatePlayerWin() {
		playerWon = completedCoins == idToCoinMap.size();
		
		if (playerWon) {
			System.out.println("\n\n==> CONGRATULATIONS !! Game Complete for Player ["+ playerName + "|" + playerColor + "]");
		}
	}

	private Set<Coin> getEligibleCoins(int score, boolean isSpecialNumber) {
		Set<Coin> eligibleCoins = new HashSet<>();
		
		for (Coin coin : idToCoinMap.values()) {
			if (coin.isEligibleForMove(score, isSpecialNumber)) {
				eligibleCoins.add(coin);
			}
		}
		
		return eligibleCoins;
	}

	@Override
	public int hashCode() {
		return Objects.hash(playerColor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(playerColor, other.playerColor);
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    sb.append("\n================== Player ==================\n");

	    sb.append("Name              : ").append(playerName).append("\n");
	    sb.append("Color             : ").append(playerColor).append("\n");
	    sb.append("Start Location    : ").append(startBoardLocation).append("\n");
	    sb.append("End Location      : ").append(endBoardLocation).append("\n");
	    sb.append("Safe Lane Length  : ").append(board.getSafeLaneLength()).append("\n");

	    sb.append("Completed Coins   : ").append(completedCoins).append("\n");
	    sb.append("Player Won        : ").append(playerWon).append("\n");

	    // Coins
	    sb.append("\nCoins (ID -> Coin):\n");
	    if (idToCoinMap == null || idToCoinMap.isEmpty()) {
	        sb.append("  None\n");
	    } else {
	        for (Map.Entry<Integer, Coin> entry : idToCoinMap.entrySet()) {
	            sb.append("  ").append(entry.getKey())
	              .append(" -> ")
	              .append(entry.getValue())
	              .append("\n");
	        }
	    }

	    sb.append("============================================\n");

	    return sb.toString();
	}
}
