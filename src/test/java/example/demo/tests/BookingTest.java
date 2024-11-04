package example.demo.tests;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import example.demo.steps.ChooseFlightStep;
import example.demo.steps.ExecuteSearchStep;
import example.demo.steps.OpenSearchPageStep;
import example.demo.steps.PurchaseFlightStep;
import example.demo.steps.ValidateSearchDestinationsStep;

/**
 * This class outlines test cases for booking a flight. This may use other
 * common steps for other test cases like search.
 * 
 * @author monalidash
 *
 */
public class BookingTest extends BaseTest {

	@Autowired
	private OpenSearchPageStep openSearchPageStep;
	@Autowired
	private ExecuteSearchStep executeSearchStep;
	@Autowired
	private ChooseFlightStep chooseFlightStep;
	@Autowired
	private PurchaseFlightStep purchaseFlightStep;
	@Autowired
	private ValidateSearchDestinationsStep validateSearchDestinationsStep;

	// this test can be run for multiple supported browsers using the driverName
	// parameter.
	@Parameters({ "driverName" })
	@Test(groups = { "booking" })
	public void bookFlight(final String driverName) {
		final WebDriver webDriver = webDriver(driverName);
		openSearchPageStep.execute(webDriver);
		executeSearchStep.execute(webDriver, "Portland", "Dublin");
		chooseFlightStep.execute(webDriver, 1);
		final String confirmationId = purchaseFlightStep.execute(webDriver);

		Assert.assertNotNull(confirmationId);
	}

	@Parameters({ "driverName" })
	@Test(groups = { "booking" })
	public void validateDestinations(final String driverName) {
		final WebDriver webDriver = webDriver(driverName);
		openSearchPageStep.execute(webDriver);
		validateSearchDestinationsStep.execute(webDriver);
	}
}
