package com.gzy.OCR;

import java.io.File;

import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * OCR识别工具类,调用tess4j实现OCR识别
 * 注意：
 * 1.tess4j核心包和lib下所有jar包均需要引入
 * 2.拷贝tessdata文件夹于当前用户目录
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
