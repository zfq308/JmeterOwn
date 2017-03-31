package com.gzy.functions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

/**
 * * @author author:gaozeya2@bluemoon.com.cn
 * 
 * @date date��2017��3��27�� ����11:34:13
 * @version 1.0 * @parameter * @since * @return
 */
public class MD5Encipher extends AbstractFunction {
	//��ȡ��־��
	private static final Logger log = LoggingManager.getLoggerForClass();
	private static final List<String> desc = new LinkedList<String>();
	private static final String KEY = "__md5_32"; //$NON-NLS-1$
	private static final int MAX_PARA_COUNT = 1;
	private static final int MIN_PARA_COUNT = 1;
	static {
		desc.add("������Ҫ����32md5���ܵ��ַ���!");
	}
	private String str = "";
	private Object[] values;

	public MD5Encipher() {

	}

	@Override
	public String execute(SampleResult arg0, Sampler arg1) throws InvalidVariableException {
		// ����ִ���߼�
		str = ((CompoundVariable) values[0]).execute();//ȡ������
		log.info("����Ĳ���Ϊ��" + str);
		str = encryption(str);
		log.info("���ܺ�Ϊ��" + str);
		return str;
	}

	@Override
	public String getReferenceKey() {
		// ���غ�������
		return KEY;
	}

	@Override
	public void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
		// ���ò���
		checkParameterCount(parameters, MIN_PARA_COUNT, MAX_PARA_COUNT);
		values = parameters.toArray();

	}

	@Override
	public List<String> getArgumentDesc() {
		//���ز�������

		return desc;
	}
//32λСдmd5�����㷨
	public String encryption(String plain) {
		String re_md5 = new String();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plain.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

			re_md5 = buf.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return re_md5;
	}
}
