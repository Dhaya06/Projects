package csi.vidaplus.rcm.datavalidation.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import csi.vidaplus.rcm.datavalidation.model.Message;

@Component
public class NotificationServiceFallback implements NotificationService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Message sendNotification(Message message) {
		logger.error("Faild NotificationService, calling NotificationServiceFallback.sendNotification",message);
		return null;
	}

}
