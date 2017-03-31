package com.gzy.OCR;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.jmeter.processor.PostProcessor;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testelement.AbstractScopedTestElement;
import org.apache.jmeter.threads.JMeterContext;
import org.apache.jmeter.threads.JMeterVariables;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

/**
 * * @author author:gaozeya2@bluemoon.com.cn
 * 
 * @date date��2017��3��30�� ����3:37:51
 * @version 1.0 * @parameter * @since * @return
 */
public class VcodeExtractor extends AbstractScopedTestElement implements PostProcessor, TestBean {
	private File myFile;
	private int vcodeLen;
	private String vcodeType;
	private String imageType;
	private int Type = 0;
	private static final long serialVersionUID = 241L;
	private static final Logger log = LoggingManager.getLoggerForClass();
	private String vcode = "error";

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public int getVcodeLen() {
		return vcodeLen;
	}

	public void setVcodeLen(int vcodeLen) {
		this.vcodeLen = vcodeLen;
	}

	public String getVcodeType() {
		return vcodeType;
	}

	public void setVcodeType(String vcodeType) {
		this.vcodeType = vcodeType;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	@SuppressWarnings("finally")
	@Override
	public void process() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		JMeterContext context = getThreadContext();
		SampleResult previousResult = context.getPreviousResult();
		if (previousResult == null) {
			return;
		}
		// log.debug("+++++++VcodeExtractor processing result");

		switch (vcodeType) {
		case "������":
			Type = 1;
			break;
		case "����ĸ":
			Type = 2;
			break;
		default:
			Type = 0;
			break;
		}

		String status = previousResult.getResponseCode();
		int id = context.getThreadNum();
		String imageName = id + "." + imageType;
		if (status.equals("200")) {
			byte[] buffer = previousResult.getResponseData();
			FileOutputStream out = null;
			File file = null;
			try {
				file = new File(imageName);
				out = new FileOutputStream(file);
				out.write(buffer);
				out.flush();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (out != null) {
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						log.info("��ӡ�û�·��--->>��ʼ");
						log.info(System.getProperty("user.dir"));
						log.info("��ӡ�û�·��--->>����");
						log.info("ʶ����֤��--->>��ʼ");
						vcode = OCRUtil.getOCRResult(file);
						log.info("ԭʼ��֤��--->>��ʼ");
						log.info(vcode);
						log.info("ԭʼ��֤��--->>��ʼ");

						vcode = VcodeUtils.vcode(vcode, Type, vcodeLen);

						log.info("������֤��--->>��ʼ");
						log.info(vcode);
						log.info("������֤��--->>��ʼ");

						JMeterVariables var = context.getVariables();
						var.put("vcode", vcode);
						var.put("vuser", String.valueOf(id));

						log.info("ʶ����֤��--->>����");
						return;
					}

				}

			}
		} else {
			if (myFile != null && myFile.exists() && myFile.canRead()) {
				log.info("��ӡ�û�·��--->>��ʼ");
				log.info(System.getProperty("user.dir"));
				log.info("��ӡ�û�·��--->>����");
				log.info("ʶ����֤��--->>��ʼ");
				vcode = OCRUtil.getOCRResult(myFile);
				log.info("ԭʼ��֤��--->>��ʼ");
				log.info(vcode);
				log.info("ԭʼ��֤��--->>����");
				vcode = VcodeUtils.vcode(vcode, Type, vcodeLen);
				log.info("������֤��--->>��ʼ");
				log.info(vcode);
				log.info("������֤��--->>����");
				JMeterVariables var = context.getVariables();
				var.put("vcode", vcode);
				var.put("vuser", String.valueOf(id));
				log.info("ʶ����֤��--->>����");
				return;
			}

			JMeterVariables var = context.getVariables();
			var.put("vcode", vcode);
			var.put("vuser", String.valueOf(id));
			log.error("ͼƬ�����ڻ��߻�ȡͼƬ��Ӧ��ʧ�ܣ�");
		}

	}

}
