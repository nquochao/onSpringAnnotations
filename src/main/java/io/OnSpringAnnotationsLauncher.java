package io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;


public class OnSpringAnnotationsLauncher {

	public static final Logger logger = LoggerFactory.getLogger(OnSpringAnnotationsLauncher.class);

	public static void main(String[] args) throws IOException {
		AppContext.setAppName("onspringAnnotations");
		ApplicationContext context = AppContext.getApplicationContext();
		AppContext.getProperties();
	}




}
