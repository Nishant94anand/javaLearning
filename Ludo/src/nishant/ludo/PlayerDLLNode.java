package nishant.ludo;

import java.util.Objects;

public class PlayerDLLNode {
	PlayerDLLNode prev;
	Player player;
	PlayerDLLNode next;
	
	public PlayerDLLNode(Player player) {
		this.player = player;
	}

	@Override
	public int hashCode() {
		return Objects.hash(player);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerDLLNode other = (PlayerDLLNode) obj;
		return Objects.equals(player, other.player);
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    sb.append("\n===== Player Circular DLL =====\n");

	    PlayerDLLNode current = this;
	    PlayerDLLNode start = this;

	    do {
	        sb.append("[")
	          .append(current.player.getName())
	          .append(" | ")
	          .append(current.player.getColor())
	          .append("] -> ");

	        current = current.next;

	    } while (current != start);

	    sb.append("(back to start)");
	    sb.append("\n================================\n");

	    return sb.toString();
	}
}
