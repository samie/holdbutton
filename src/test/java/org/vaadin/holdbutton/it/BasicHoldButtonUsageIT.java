package org.vaadin.holdbutton.it;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.NotificationElement;
import org.junit.Test;
import static org.junit.Assert.*;

import org.vaadin.holdbutton.BasicHoldButtonUsageUI;

/**
 * A simple example that uses TestBench to do a browser level test for a
 * BasicHoldButtonUsageIT. For more complex tests, consider using page object
 * pattern.
 */
public class BasicHoldButtonUsageIT extends AbstractTestBenchTestCase {

    public BasicHoldButtonUsageIT() {
        super(BasicHoldButtonUsageUI.class);
    }
    
    @Test
    public void testJavaScriptComponentWithBrowser() throws InterruptedException {
               
        // Click the only button on in UI
        $(ButtonElement.class).first().click();

        // Small delay
        Thread.sleep(500);

        // Click second time
        $(ButtonElement.class).first().click();

        if (!"Click me".equals($(ButtonElement.class).first().getCaption())) {
            fail("Click should have been cancelled.");
        }

        // Wait until the delay expires
        Thread.sleep(3000);
        
        // Click again
        $(ButtonElement.class).first().click();
        if (!$(NotificationElement.class).exists()) {
            fail("Click didn't work correctly.");
        }
    }
}
