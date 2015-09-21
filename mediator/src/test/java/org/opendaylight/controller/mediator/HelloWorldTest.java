
package org.opendaylight.controller.mediator;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.opendaylight.controller.mediator.ForwardingReceivingDataPackets;

public class HelloWorldTest extends TestCase {

        @Test
        public void testHelloWorldCreation() {

                ForwardingReceivingDataPackets helloWorld = null;
                helloWorld = new ForwardingReceivingDataPackets();
                Assert.assertTrue(helloWorld != null);

        }

}
