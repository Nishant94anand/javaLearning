package nishant.ludo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Board {
	private int totalSize;
	private int playerJourneySize;
	private int safeLaneLength;
	private Set<Integer> safeLocations;
	private Map<Integer, Coin> locationToCoinMap;
	private Map<Coin, Integer> coinToLocationMap;

	public Board() {
		System.out.println("\n\n==== Let's configure the Board first ====");

		Scanner sc = new Scanner(System.in);
		configureBoard(sc);
		configureJourneySize(sc);
		configureSafeLaneLength(sc);
		locationToCoinMap = new HashMap<>();
		coinToLocationMap = new HashMap<>();
	}

	// No setters required. Once game is constructed, this should not be changed.
	public int getTotalSize() {
		return totalSize;
	}

	// No setters required. Once game is constructed, this should not be changed.
	public int getPlayerJourneySize() {
		return playerJourneySize;
	}

	// No setters required. Once game is constructed, this should not be changed.
	public int getSafeLaneLength() {
		return safeLaneLength;
	}	
	
	public boolean updateMovedCoinAndCheckCapture(Coin movedCoin) {
		int newPosition = movedCoin.getPosition();
		
		// Remove old location mapping
		Integer oldPosition = coinToLocationMap.get(movedCoin);
		if (oldPosition != null) {
			locationToCoinMap.remove(oldPosition);
		}
		
		coinToLocationMap.put(movedCoin, newPosition);
		boolean hasCaptured = false;
		
		if (locationToCoinMap.containsKey(newPosition) && !safeLocations.contains(newPosition)) {
			Coin existingCoin = locationToCoinMap.get(newPosition);
			
			// If the coin is of different player, capture it.
			if (!existingCoin.getColor().equals(movedCoin.getColor())) {				
				System.out.println("\n\n==== !!CAPTURE!! ====\n\n");
				existingCoin.capture();
				hasCaptured = true;
				coinToLocationMap.remove(existingCoin);
				System.out.println("\n==> Captured Coin: " + existingCoin);
			}
		}
		
		locationToCoinMap.put(newPosition, movedCoin);
		
		System.out.println("================= Updated Board =================");
		System.out.println("\n\nlocationToCoinMap: " + locationToCoinMap);
		System.out.println("\n\ncoinToLocationMap: " + coinToLocationMap);
		System.out.println("\n===============================================\n");
		
		return hasCaptured;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n================== Board ==================\n");
		
		sb.append("Total Size        : ").append(totalSize).append("\n");
		sb.append("Player Journey    : ").append(playerJourneySize).append("\n");
		sb.append("Safe Lane Length  : ").append(safeLaneLength).append("\n");
		
		// Safe Locations
		sb.append("\nSafe Locations    : ");
		if (safeLocations == null || safeLocations.isEmpty()) {
			sb.append("None");
		} else {
			sb.append(safeLocations);
		}
		
		// Location → Coin Map
		sb.append("\n\nLocation -> Coin Map:\n");
		if (locationToCoinMap == null || locationToCoinMap.isEmpty()) {
			sb.append("  None\n");
		} else {
			for (Map.Entry<Integer, Coin> entry : locationToCoinMap.entrySet()) {
				sb.append("  ").append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
			}
		}
		
		// Coin → Location Map
		sb.append("\nCoin -> Location Map:\n");
		if (coinToLocationMap == null || coinToLocationMap.isEmpty()) {
			sb.append("  None\n");
		} else {
			for (Map.Entry<Coin, Integer> entry : coinToLocationMap.entrySet()) {
				sb.append("  ").append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
			}
		}
		
		sb.append("===========================================\n");
		
		return sb.toString();
	}
	
	private void configureSafeLaneLength(Scanner sc) {
		System.out.println(
				"\n==> Finally.. What length do you want for the final Safe Lane for each player?\nEnter between 0 and 10. [Default Ludo has 6]");
		
		int safeLength = sc.nextInt();
		if (safeLength < 0 || safeLength > 10) {
			System.out.println("==> oops!! Invalid Number... YOU DON'T GET ANY SAFE LANE NOW!!");
			safeLength = 0;
		}
		
		this.safeLaneLength = safeLength;
		
	}

	private void configureBoard(Scanner sc) {
		System.out.println("\n==> What size of Board do you want? [The default ludo has 52]");
		this.totalSize = sc.nextInt();
		System.out.println("\n==> Cool - Now let's configure the safe spots");
		safeLocations = new HashSet<Integer>();

		System.out.println("\n==> How many safe spots? [Default Ludo has 8: 0, 8, 13, 21, 26, 34, 39, 47]");
		int numberOfSafeSpots = sc.nextInt();

		if (numberOfSafeSpots > 0 && numberOfSafeSpots <= totalSize) {
			while (safeLocations.size() < numberOfSafeSpots) {
				System.out.print("\nSafe Spot #" + (safeLocations.size() + 1) + ": ");
				int spot = sc.nextInt();

				if (spot > totalSize) {
					System.out.println("\n==> Really ?? Beyond the board?? ");
				} else {
					safeLocations.add(spot);
				}
			}
		} else {
			System.out.println("==> oops!! Invalid Number... YOU DON'T GET ANY SAFE SPOTS NOW!!");
		}

	}

	private void configureJourneySize(Scanner sc) {
		boolean journeySizeEntered = false;

		while (!journeySizeEntered) {
			System.out.println("\n==> What is the journey size for each player? [The default ludo has 50]");
			this.playerJourneySize = sc.nextInt();

			if (playerJourneySize > totalSize) {
				System.out.println(
						"\nCome on !! How can the journey size be higher than the total board.. I mean.. COME ON!!");
			} else {
				journeySizeEntered = true;
			}
		}

	}
}
