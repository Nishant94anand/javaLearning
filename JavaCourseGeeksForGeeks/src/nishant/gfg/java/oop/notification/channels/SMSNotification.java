package nishant.gfg.java.oop.notification.channels;

import nishant.gfg.java.oop.notification.base.Notification;

/**
 * Concrete implementation for SMS notifications.
 */
public class SMSNotification extends Notification {

	// SMS-specific field
	private long mobileNumber;

	public SMSNotification(long mobileNumber, String message) {
		super(message);
		this.mobileNumber = mobileNumber;
	}

	/**
	 * Overridden method defining SMS-specific logic
	 */
	@Override
	public void send() {
		System.out.println("\nSending SMS to mobile number: " + mobileNumber
				+ "\n==========================\n" + message);
	}
}