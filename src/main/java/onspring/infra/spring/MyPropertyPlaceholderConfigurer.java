package onspring.infra.spring;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import io.OnSpringAnnotationsLauncher;

/**
 * A extension that handles encryption for database password
 * 
 *
 */
public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	Properties properties;
	private static final String DB_PW_PARAMETER_NAME = "database.password";
	
	private Base32 decoder = new Base32();
	
	
	@Override
	protected String resolveSystemProperty(String key) {
		if (DB_PW_PARAMETER_NAME.equals(key))
			return decode(System.getProperty(key));
			
		return super.resolveSystemProperty(key);
	}
	
	@Override
	protected String resolvePlaceholder(String placeholder, Properties props) {
		if (DB_PW_PARAMETER_NAME.equals(placeholder))
			return decode(props.getProperty(DB_PW_PARAMETER_NAME));
		
		return super.resolvePlaceholder(placeholder, props);
	}

	private String decode(String dbPassword) {
		if (!StringUtils.isEmpty(dbPassword) ) {
			String decoded = new String(decoder.decode(dbPassword));
			return StringUtils.isEmpty(decoded) ? dbPassword : decoded;
		}
		return dbPassword;
	}
	

	public Properties getProperties(){
		// TODO Auto-generated method stub
		
		if(properties==null)
			try {
				properties= super.mergeProperties();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return properties;
	}
	
}