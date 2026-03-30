package nishant.gfg.java.oop.notification.channels;

import nishant.gfg.java.oop.notification.base.Notification;

/**
 * Concrete implementation for Email notifications.
 *
 * Demonstrates:
 * - Constructor chaining (super)
 * - Method overriding
 */
public class EmailNotification extends Notification {

	// Email-specific field
	private String emailId;

	/**
	 * Constructor initializes email-specific and common data
	 */
	public EmailNotification(String emailId, String message) {
		super(message); // initialize base class field
		this.emailId = emailId;
	}

	/**
	 * Overridden method defining email-specific sending logic
	 */
	@Override
	public void send() {
		System.out.println("\nSending EMail to ID: " + emailId
				+ "\n==========================\n" + message);
	}
}