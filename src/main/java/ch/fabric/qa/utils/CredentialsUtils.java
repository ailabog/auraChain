package ch.fabric.qa.utils;

import java.io.IOException;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

@Slf4j
public class CredentialsUtils {

	private static final Properties properties = loadProperties();

	private static Properties loadProperties() {
		String env = System.getProperty("environment");

		try {
			Properties prop = new Properties();
			prop.load(CredentialsUtils.class.getClassLoader().getResourceAsStream(env +".properties"));
			return prop;
		} catch (IOException e) {
			log.error("Error ocured while loading properties {}", e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public static String getProperty(String property) {
		return properties.getProperty(property);
	}

}
