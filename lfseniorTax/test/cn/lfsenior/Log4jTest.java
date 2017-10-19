package cn.lfsenior;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class Log4jTest {

	@Test
	public void test() {
		Log log = LogFactory.getLog(getClass());
		log.debug("debug 级别信息");
		log.info("info 级别信息");
		log.warn("warn 级别信息");
		log.error("error 级别信息");
		log.fatal("fatal 级别信息");
	}

}
