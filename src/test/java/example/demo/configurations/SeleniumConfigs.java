package example.demo.configurations;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configure selenium properties here.
 * 
 * @author monalidash
 *
 */
@Configuration
@ComponentScan("example.demo")
public class SeleniumConfigs {

	/**
	 * This bean is autowired in the BaseTest and may be used by all the tests
	 * 
	 * @return
	 */
	@Bean
	public ChromeDriver chromeDriver() {
		final ChromeOptions options = new ChromeOptions();
		// configure necessary chrome options here
		return new ChromeDriver(options);
	}

	@Bean
	public Properties props() throws IOException {
		if (System.getProperty("propertiesPath") == null) {
			throw new UnsupportedOperationException("propertiesPath missing");
		}
		Properties properties = new Properties();
		InputStreamReader in = null;
		try {
			in = new InputStreamReader(new FileInputStream(System.getProperty("propertiesPath")), "UTF-8");
			properties.load(in);
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException ex) {
				}
			}
		}
		return properties;
	}
}
