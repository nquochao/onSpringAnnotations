package onspring.oliviaproject.helloworld;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Bonjour {
	public static final Logger logger = LoggerFactory.getLogger(Bonjour.class);
@PostConstruct
public void init() {
logger.info("Bonjour de Olivia");	
}
}
