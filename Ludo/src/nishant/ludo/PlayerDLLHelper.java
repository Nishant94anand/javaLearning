package nishant.ludo;

import java.util.List;

public class PlayerDLLHelper {
	public static PlayerDLLNode createDLL(List<Player> players) {
		PlayerDLLNode root = null;
		PlayerDLLNode last = null;
		
		for (int i = 0; i < players.size(); ++i) {
			Player player = players.get(i);
			PlayerDLLNode node = new PlayerDLLNode(player);
			
			if (root == null) {
				root = node;
				last = node;
			} else {
				node.prev = last;
				last.next = node;
				last = node;
			}
		}
		
		last.next = root;
		root.prev = last;
		
		return root;
	}
	
	public static boolean isSinglePlayerLeft(PlayerDLLNode node) {
		return node.prev == node && node.next == node;
	}
	
	public static boolean removeFromDLL(PlayerDLLNode node) {	
		if (isSinglePlayerLeft(node)) {
			return false;
		}
		
		PlayerDLLNode prev = node.prev;
		PlayerDLLNode next = node.next;
		
		prev.next = next;
		next.prev = prev;
		
		return true;
	}

}
