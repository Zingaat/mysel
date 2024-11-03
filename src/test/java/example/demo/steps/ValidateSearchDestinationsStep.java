package example.demo.steps;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@Component
public class ValidateSearchDestinationsStep extends AbstractStep {

	public void execute(final WebDriver driver) {
		List<WebElement> departures = new Select(
				driver.findElement(By.xpath(val("app.search.destinations-select.xpath")))).getOptions();

		List<String> departureAssertList = Arrays.asList(val("app.search.destinations").split("\\s*,\\s*"));
		int i = 0;
		for (final WebElement elem : departures)
			Assert.assertEquals(elem.getText(), departureAssertList.get(i++));

	}

}
