package junit.test.action;

import javax.annotation.Resource;


import com.opensymphony.xwork2.ActionSupport;

import junit.test.service.ITestService;

public class TestAction extends ActionSupport {
	@Resource
	private ITestService testService;
	
	@Override
	public String execute() throws Exception {
		testService.say();
		return SUCCESS;
	}
}
