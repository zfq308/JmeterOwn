package com.gzy.GetFuctionResult;

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testbeans.gui.FileEditor;

/**
����UIչʾ���̳�BeanInfoSupport
 */
public class GetFuctionRestultBeanInfo extends BeanInfoSupport {
	//����UID
    private static final long serialVersionUID = 240L;
    //����fuction����
	private static final String FuctionName = "fuction"; //$NON-NLS-1$
	//�����ṩ�޲ι��췽��
	public GetFuctionRestultBeanInfo() {
		//���� GetFuctionRestult
		super(GetFuctionRestult.class);
// 		�������ԣ�FuctionNameָ����fuction�����ǰ�������ַ�
		createPropertyGroup("MyFuction", //$NON-NLS-1$
				new String[] { FuctionName });
		//����FuctionName����
		PropertyDescriptor p = property(FuctionName);
		p.setValue(NOT_UNDEFINED, true);
		p.setValue(DEFAULT, "�����뺯��");
	}

}
