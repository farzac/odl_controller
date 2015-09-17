
package org.opendaylight.controller.mediator.internal;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.opendaylight.controller.mediator.internal.HelloWorld;

public class HelloWorldTest extends TestCase {

        @Test
        public void testHelloWorldCreation() {

                HelloWorld helloWorld = null;
                helloWorld = new HelloWorld();
                Assert.assertTrue(helloWorld != null);

        }

}
