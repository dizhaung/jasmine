package core.com.util;

import core.com.base.TestBase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * log back
 * <p>
 * Created by wangjianan on 17-3-6.
 */
public class LogbackTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void printInfo() {
        logger.info("info debug card begin;");
        logger.info("info debug card end;");
    }

}
