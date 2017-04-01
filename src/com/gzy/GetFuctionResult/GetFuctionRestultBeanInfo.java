package com.gzy.GetFuctionResult;

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testbeans.gui.FileEditor;

/**
定义UI展示，继承BeanInfoSupport
 */
public class GetFuctionRestultBeanInfo extends BeanInfoSupport {
	//定义UID
    private static final long serialVersionUID = 240L;
    //关联fuction属性
	private static final String FuctionName = "fuction"; //$NON-NLS-1$
	//必须提供无参构造方法
	public GetFuctionRestultBeanInfo() {
		//关联 GetFuctionRestult
		super(GetFuctionRestult.class);
// 		创建属性，FuctionName指的是fuction输入框前的描述字符
		createPropertyGroup("MyFuction", //$NON-NLS-1$
				new String[] { FuctionName });
		//设置FuctionName属性
		PropertyDescriptor p = property(FuctionName);
		p.setValue(NOT_UNDEFINED, true);
		p.setValue(DEFAULT, "请输入函数");
	}

}
