package csi.vidaplus.rcm.datavalidation.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import csi.vidaplus.rcm.datavalidation.model.Message;

@FeignClient(value="notification-service",url="http://172.15.10.52:9004/notification",fallback=NotificationServiceFallback.class)
public interface NotificationService {

	@RequestMapping(value="push",method=RequestMethod.POST,consumes= {"application/json"})
	public Message sendNotification(Message message);
	
}
