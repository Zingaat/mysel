package example.demo.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class ExecuteSearchStep extends AbstractStep {

	public void execute(final WebDriver driver, final String departureCity, final String destinationCity) {
		driver.findElement(By.xpath(val("app.search.departures-select.xpath"))).sendKeys(departureCity);
		driver.findElement(By.xpath(val("app.search.destinations-select.xpath"))).sendKeys(destinationCity);
		driver.findElement(By.xpath(val("app.search.find-flight-btn.xpath"))).click();
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> driver.findElement(By.xpath(val("app.search.result.xpath"))).isDisplayed());
	}

}
