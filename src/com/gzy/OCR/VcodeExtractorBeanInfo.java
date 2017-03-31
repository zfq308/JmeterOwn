package com.gzy.OCR;

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testbeans.gui.TableEditor;

/**
 * * @author author:gaozeya2@bluemoon.com.cn
 * 
 * @date date：2017年3月30日 下午3:38:11
 * @version 1.0 * @parameter * @since * @return
 */
public class VcodeExtractorBeanInfo extends BeanInfoSupport {

	private PropertyDescriptor getprop(String name) {
		final PropertyDescriptor property = property(name);
		property.setValue(NOT_UNDEFINED, Boolean.FALSE); // Ensure it is not
															// flagged as
															// 'unconfigured'
		return property;
	}

	private PropertyDescriptor getprop(String name, Object deflt) {
		PropertyDescriptor p = property(name);
		p.setValue(DEFAULT, deflt);
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		return p;
	}

	public VcodeExtractorBeanInfo() {
		super(VcodeExtractor.class);
		// TODO Auto-generated constructor stub
		getprop("myFile");
		// int[] i = { 4, 5 };
		getprop("vcodeLen", Integer.valueOf(4));
		PropertyDescriptor p = property("vcodeLen");
		p.setShortDescription("输入验证码长度，可輸入項： 任意正整数");

		getprop("vcodeType", "数字+字母");
		p = property("vcodeType");
		p.setShortDescription("输入验证码格式，可输入项：纯数字、纯字母、数字+字母");

		getprop("imageType", "jpg");
		p = property("imageType");
		p.setShortDescription("输入验证码图片类型，可输入项：jpg、jpeg、png");
	}

}
