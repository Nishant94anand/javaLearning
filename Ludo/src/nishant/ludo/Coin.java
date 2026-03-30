package nishant.ludo;

import java.util.Objects;

public class Coin {
	private static final int HOME_POSITION = -1;

	private String color;
	private int id;
	private int position;
	private int startPosition;
	private int endPosition;
	private int safeLaneDistanceRemaining;
	private boolean isComplete;
	private Player player;

	public Coin(String color, int id, int startPosition, int endPosition, int safeLaneDistanceRemaining,
			Player player) {
		this.color = color;
		this.id = id;
		this.position = HOME_POSITION;
		this.startPosition = startPosition;
		this.endPosition = endPosition;
		this.safeLaneDistanceRemaining = safeLaneDistanceRemaining;
		isComplete = false;
		this.player = player;
	}

	String getColor() {
		return color;
	}

	void setColor(String color) {
		this.color = color;
	}

	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	int getPosition() {
		return position;
	}

	void setPosition(int position) {
		this.position = position;
	}

	public void takeOutFromHome() {
		System.out.println("\n\n==>Coin ID: " + id + " taken out of home to play!!");
		setPosition(startPosition);
	}

	public void capture() {
		setPosition(HOME_POSITION);
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void move(int score, boolean isSpecialNumber) {
		// Ideally this should already be verified in calling class. But still included for safety check.
		if (!isEligibleForMove(score, isSpecialNumber)) {
			return;
		}
		
		System.out.println("\n\n==>Moving coin " + id + "for score " + score);
		
		// If coin is inside home, take out.
		if (isInsideHome() && isSpecialNumber) {
			takeOutFromHome();
			return;
		}
		
		int absEndPosition = getEndPositionForMove();
		
		if (absEndPosition - position >= score) {
			position += score;
			position = player.getPositionOnBoardForPlayer(position);
		} else {
			score -= (absEndPosition - position);
			position = absEndPosition;
			safeLaneDistanceRemaining -= score;
			
			if (safeLaneDistanceRemaining < 0) {
				safeLaneDistanceRemaining = 0;
			}
			
			checkCompletion();
		}
	}

	public boolean isInsideHome() {
		return position == HOME_POSITION;
	}

	public boolean isEligibleForMove(int score, boolean isSpecialNumber) {
		// Complete coins not eligible for any move
		if (isComplete) {
			return false;
		}

		// Coins in home can be taken out only with special number
		if (isInsideHome()) {
			return isSpecialNumber;
		}

		// Is the score lower than total distance possible
		
		int distanceTravellable = getEndPositionForMove() - position + safeLaneDistanceRemaining;

		return score <= distanceTravellable;
	}
	

	private void checkCompletion() {
		if (safeLaneDistanceRemaining == 0) {
			isComplete = true;
			System.out.println("\n\n==>Congratulations !! Coin ID: " + id + " is now complete!!");
		}
	}
	
	private int getEndPositionForMove() {
		if (endPosition < position) {
			return endPosition + player.getTotalBoardSize();
		}
		
		return endPosition;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coin other = (Coin) obj;
		return Objects.equals(color, other.color) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "\n" + id + " =>" + "[color=" + color + ", id=" + id + ", position=" + position + ", startPosition="
				+ startPosition + ", endPosition=" + endPosition + ", safeLaneDistanceRemaining="
				+ safeLaneDistanceRemaining + ", isComplete=" + isComplete + ", player=" + this.player.getName() + " | " + this.player.getColor() + "]";
	}
}
