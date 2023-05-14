package test.automation.hooks;

import io.cucumber.java.After;
import test.automation.driver.DriverPool;

import java.util.Optional;

public class BaseDriverHooks {
    public DriverPool driverPool = new DriverPool();
    @After
    public void afterTest() {
        quitWebdrivers(driverPool);
    }

    public void quitWebdrivers(DriverPool drivers) {

        Optional.ofNullable(drivers.getAndroidDriver())
                .ifPresent(
                        driver -> {
                            driver.quit();
                            drivers.setAndroidDriver(null);
                        });
    }
}
