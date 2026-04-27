package nishant.gfg.java.oop.notification.channels;

import nishant.gfg.java.oop.notification.base.Notification;

/**
 * Concrete implementation for Push notifications.
 */
public class PushNotification extends Notification {

	// Device-specific identifier
	private long deviceId;

	public PushNotification(long deviceId, String message) {
		super(message);
		this.deviceId = deviceId;
	}

	/**
	 * Overridden method defining push notification behavior
	 */
	@Override
	public void send() {
		System.out.println(
				"\nSending Push Notification to Device ID: " + deviceId
						+ "\n==========================\n" + message);
	}
}