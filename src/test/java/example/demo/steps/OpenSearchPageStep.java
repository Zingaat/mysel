package example.demo.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class OpenSearchPageStep extends AbstractStep {

	public void execute(final WebDriver driver) {
		driver.get(val("app.root-uri"));
		// Wait till the button is displayed
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> driver.findElement(By.xpath(val("app.search.find-flight-btn.xpath"))).isDisplayed());
	}

}
