package csi.vidaplus.rcm.datavalidation.model;

public class MessageInfo {

	private String recevierId;
	private String recevierUserId;

	private String notificationType;
	private String notificationMessageType;

	public String getRecevierId() {
		return recevierId;
	}

	public void setRecevierId(String recevierId) {
		this.recevierId = recevierId;
	}

	public String getRecevierUserId() {
		return recevierUserId;
	}

	public void setRecevierUserId(String recevierUserId) {
		this.recevierUserId = recevierUserId;
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
