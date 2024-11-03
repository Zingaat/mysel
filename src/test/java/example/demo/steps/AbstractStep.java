package example.demo.steps;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractStep {
	
	@Autowired
	private Properties props;

	protected String val(final String key) {
		return props.getProperty(key);
	}
}
