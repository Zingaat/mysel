package example.demo.tests;

import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import example.demo.configurations.SeleniumConfigs;

@Test
@ContextConfiguration(classes = SeleniumConfigs.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

	@Autowired
	protected ApplicationContext ctxt;

	/**
	 * Returns a supported webDriver.
	 * 
	 * @param webDriver
	 * @return
	 */
	protected WebDriver webDriver(final String webDriver) {
		try {
			// find from supported drivers configured in SeleniumConfig
			return ctxt.getBean(webDriver, WebDriver.class);
		} catch (NoSuchBeanDefinitionException e) {
			// if a wrong driver is requested
			throw new UnsupportedOperationException("Unsupported webdriver " + webDriver);
		}
	}

	@AfterSuite
	public void teardown() {
		// close all the webDriver if open
		for (final Entry<String, WebDriver> entry : ctxt.getBeansOfType(WebDriver.class).entrySet())
			entry.getValue().quit();
	}

}
