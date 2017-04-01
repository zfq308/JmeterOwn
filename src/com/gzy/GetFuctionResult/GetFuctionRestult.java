package com.gzy.GetFuctionResult;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

/***
 * �߼�ʵ���࣬�̳�AbstractSampler
 * */
public class GetFuctionRestult extends AbstractSampler implements TestBean {
	//����UID
	private static final long serialVersionUID = 240L;
	//���ԣ�������public��get��set����
	private String fuction;
	//��ȡlog����
	private static final Logger log = LoggingManager.getLoggerForClass();

	public String getFuction() {
		return fuction;
	}

	public void setFuction(String fuction) {
		this.fuction = fuction;
	}

	@Override
	public SampleResult sample(Entry arg0) {
		//�߼�ʵ��		
		SampleResult res = new SampleResult();
		res.setSampleLabel(getName());
		res.sampleStart();
		log.info("��ȡ��������ֵ--->>��ʼ");
		log.info(fuction);
		res.setSamplerData(fuction);
		res.setResponseData(fuction, null);
		log.info("��ȡ��������ֵ--->>����");
		res.sampleEnd();
		res.setSuccessful(true);
		return res;
	}

}
