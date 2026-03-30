package nishant.ludo;

public class Die {
	private int maxNumber;
	
	public Die(int max) {
		this.maxNumber = max;
	}
	
	public int roll() {
		int score = (int)(Math.random() * maxNumber) + 1;
		System.out.println("==> Number on die: " + score);
		return score;
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    sb.append("\n================== Die ==================\n");

	    sb.append("Max Number        : ").append(maxNumber).append("\n");

	    sb.append("=========================================\n");

	    return sb.toString();
	}

}
