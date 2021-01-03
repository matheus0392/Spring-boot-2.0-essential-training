package com.frankmoley.boot.essentials;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Endpoint(id = "system-details")
public class SystemEvalEndpoint {

	@ReadOperation
	public SystemDetails getSystemDetails() {
		SystemDetails details = new SystemDetails();
		details.systemTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return details;
	}

	@Data
	public class SystemDetails {
		private String systemTime;

		public String getSystemTime() {
			return systemTime;
		}

		public void setSystemTime(String systemTime) {
			this.systemTime = systemTime;
		}

	}
}
