package com.gzy.GetFuctionResult;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

/***
 * 逻辑实现类，继承AbstractSampler
 * */
public class GetFuctionRestult extends AbstractSampler implements TestBean {
	//定义UID
	private static final long serialVersionUID = 240L;
	//属性，必须有public的get，set方法
	private String fuction;
	//获取log对象
	private static final Logger log = LoggingManager.getLoggerForClass();

	public String getFuction() {
		return fuction;
	}

	public void setFuction(String fuction) {
		this.fuction = fuction;
	}

	@Override
	public SampleResult sample(Entry arg0) {
		//逻辑实现		
		SampleResult res = new SampleResult();
		res.setSampleLabel(getName());
		res.sampleStart();
		log.info("获取函数返回值--->>开始");
		log.info(fuction);
		res.setSamplerData(fuction);
		res.setResponseData(fuction, null);
		log.info("获取函数返回值--->>结束");
		res.sampleEnd();
		res.setSuccessful(true);
		return res;
	}

}
