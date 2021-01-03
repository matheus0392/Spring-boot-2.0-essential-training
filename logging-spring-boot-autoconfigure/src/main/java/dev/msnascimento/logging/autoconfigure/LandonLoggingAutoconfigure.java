package dev.msnascimento.logging.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.frankmoley.landon.aop.LoggableAspect;

@Configuration
@ConditionalOnClass(LoggableAspect.class)
@EnableConfigurationProperties(LandonLoggingProperties.class)
public class LandonLoggingAutoconfigure {

	@Autowired
	private LandonLoggingProperties properties;
	
	@Bean
	public LoggableAspect loggableAspect() {
		return new LoggableAspect(properties.getLoggerName());
	}
}
