package com.gzy.OCR;

import java.io.File;

import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * OCRʶ�𹤾���,����tess4jʵ��OCRʶ��
 * ע�⣺
 * 1.tess4j���İ���lib������jar������Ҫ����
 * 2.����tessdata�ļ����ڵ�ǰ�û�Ŀ¼
 */
public class OCRUtil {
	public OCRUtil() {
	}

	@Test
	public void test() {
		File imageFile = new File("C:/Users/gzy/Desktop/tess4j/image.jpeg");
		System.out.println(getOCRResult(imageFile));
	}

	public static String getOCRResult(File file) {

		ITesseract instance = new Tesseract();  
		String result = null;

		try {
			result = instance.doOCR(file);
		} catch (TesseractException e) {
			System.out.println(e.getMessage());
		} finally {
			file.delete();
		}

		return result;

	}
}
