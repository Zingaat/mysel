package example.demo.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class ChooseFlightStep extends AbstractStep {

	public void execute(final WebDriver driver, final int option) {
		driver.findElement(By.xpath(val("app.search.result.choose-flight-btn.xpath") + "[" + option + "]")).click();
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> driver.findElement(By.xpath(val("app.purchase.purchase-btn.xpath"))).isDisplayed());
	}

}
