package com.gzy.OCR;

import java.io.File;

import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * * @author author:gaozeya2@bluemoon.com.cn
 * 
 * @date date：2017年3月30日 下午2:47:59
 * @version 1.0 * @parameter * @since * @return
 */
public class OCRUtil {
	public OCRUtil() {
	}

	@Test
	public void test() {
		File imageFile = new File("C:/Users/gzy/Desktop/tess4j/image.png");
		System.out.println(getOCRResult(imageFile));
	}

	public static String getOCRResult(File file) {

		ITesseract instance = new Tesseract(); // JNA Interface Mapping
		String result = null;

		try {
			result = instance.doOCR(file);
		} catch (TesseractException e) {
			System.out.println(e.getMessage());
		}finally {
			file.delete();
		}

		return result;

	}
}
