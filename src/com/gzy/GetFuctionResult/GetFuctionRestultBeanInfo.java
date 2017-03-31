package com.gzy.GetFuctionResult;

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testbeans.gui.FileEditor;

/**
 * * @author author:gaozeya2@bluemoon.com.cn
 * 
 * @date date：2017年3月29日 下午2:49:26
 * @version 1.0 * @parameter * @since * @return
 */
public class GetFuctionRestultBeanInfo extends BeanInfoSupport {
    private static final long serialVersionUID = 240L;
	private static final String FuctionName = "fuction"; //$NON-NLS-1$

	public GetFuctionRestultBeanInfo() {
		super(GetFuctionRestult.class);
		createPropertyGroup("MyFuction", //$NON-NLS-1$
				new String[] { FuctionName });
		PropertyDescriptor p = property(FuctionName);
		p.setValue(NOT_UNDEFINED, true);
		p.setValue(DEFAULT, "请输入函数");
	}

}
