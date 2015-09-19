
package org.farzac.opendaylight.mediator;

import junit.framework.TestCase;

import org.farzac.opendaylight.mediator.ForwardingReceivingDataPackets;
import org.junit.Assert;
import org.junit.Test;

public class MediatorTest extends TestCase {

	@Test
	public void testHelloWorldCreation() {
		ForwardingReceivingDataPackets mediator = null;
		mediator = new ForwardingReceivingDataPackets();
		Assert.assertTrue(mediator != null);

	}

}
