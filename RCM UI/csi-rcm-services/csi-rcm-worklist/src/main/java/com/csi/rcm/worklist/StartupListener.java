package com.csi.rcm.worklist;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ApplicationStartingEvent> {

//	@Value("${spring.datasource.url}")
	private String url;

//	@Value("${spring.rabbitmq.host}")
	private String host;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public void onApplicationEvent(final ApplicationStartingEvent event) {
		System.out.println(url);
		System.out.println(host);
	}
}
