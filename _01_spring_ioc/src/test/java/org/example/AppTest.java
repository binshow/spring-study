package org.example;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {


    private Logger logger  = LoggerFactory.getLogger(AppTest.class);

    public void test(){
        logger.trace("ss");

    }
}
