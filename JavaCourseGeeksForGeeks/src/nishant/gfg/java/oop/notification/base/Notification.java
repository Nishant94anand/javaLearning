package nishant.gfg.java.oop.notification.base;

/**
 * Abstract base class representing a generic Notification.
 *
 * Key Concepts:
 * - Abstraction → defines contract for all notification types
 * - Protected field → accessible to subclasses even across packages
 */
public abstract class Notification {

	// Message content shared across all notification types
	protected String message;

	/**
	 * Constructor to initialize common message
	 */
	public Notification(String message) {
		this.message = message;
	}

	/**
	 * Abstract method → must be implemented by all subclasses
	 */
	public abstract void send();
}