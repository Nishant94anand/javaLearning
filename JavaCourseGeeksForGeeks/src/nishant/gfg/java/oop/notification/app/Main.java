package nishant.gfg.java.oop.notification.app;

// Importing base abstraction and concrete implementations
import nishant.gfg.java.oop.notification.base.Notification;
import nishant.gfg.java.oop.notification.channels.EmailNotification;
import nishant.gfg.java.oop.notification.channels.PushNotification;
import nishant.gfg.java.oop.notification.channels.SMSNotification;
import nishant.gfg.java.oop.notification.service.NotificationService;

/**
 * Entry point of the application.
 *
 * Demonstrates:
 * - Polymorphism (same reference, different implementations)
 * - Constructor usage for different notification types
 * - Service-based invocation
 */
public class Main {

	public static void main(String[] args) {

		// Creating different types of notifications using constructors
		// Note: Reference type is same (Notification) → polymorphism
		Notification emailNotification = new EmailNotification(
				"nishant94anand@gmail.com",
				"Email Notification to be sent: Hello Nishant");

		Notification smsNotification = new SMSNotification(
				9835011111l,
				"SMS Notification to be sent: Hello Nishant");

		Notification pushNotification = new PushNotification(
				9835011111l,
				"Push Notification to be sent: Hello Nishant");

		// Service responsible for sending notifications
		NotificationService service = new NotificationService();

		// Polymorphic calls → actual method resolved at runtime
		service.sendNotification(emailNotification);
		service.sendNotification(smsNotification);
		service.sendNotification(pushNotification);
	}
}