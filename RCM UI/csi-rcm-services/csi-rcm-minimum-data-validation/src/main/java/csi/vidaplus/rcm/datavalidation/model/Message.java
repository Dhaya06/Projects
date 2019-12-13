package csi.vidaplus.rcm.datavalidation.model;

public class Message {

	private MessageId id;
	private String message;
	private String title;
	private String notificationType;
	private String notificationMessageType;
	

	public MessageId getId() {
		return id;
	}

	public void setId(MessageId id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getNotificationMessageType() {
		return notificationMessageType;
	}

	public void setNotificationMessageType(String notificationMessageType) {
		this.notificationMessageType = notificationMessageType;
	}

}
