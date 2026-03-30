package nishant.gfg.java.oop.notification.service;

import nishant.gfg.java.oop.notification.base.Notification;

/**
 * Service layer responsible for sending notifications.
 *
 * Demonstrates:
 * - Loose coupling
 * - Polymorphism via base class reference
 */
public class NotificationService {

	/**
	 * Accepts any Notification type and sends it
	 */
	public void sendNotification(Notification notification) {

		System.out.println("\n\n====> Sending Notification");

		// Polymorphic call → runtime decides implementation
		notification.send();

		System.out.println("====> Notification Sent!!");
	}
}