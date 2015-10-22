package org.ihsp.data.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Md5 工具
 */
public class MD5Util {
	private static final Log log = LogFactory.getLog(MD5Util.class);
	private static final String DEFAULT_PASSWORD="no_passwd";
	private static MessageDigest md5 = null;

	/**
	 * 用于获取一个String的md5值
	 * 
	 * @param string
	 * @return
	 */
	public static String getMd5(String str) {
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] bs = md5.digest(str.getBytes());
		return new String(new Hex().encode(bs));
	}

	public static String getDefaultPasswd() {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] bs = md5.digest(DEFAULT_PASSWORD.getBytes());
        return new String(new Hex().encode(bs));
    }

	/**
	 * 用于获取一个File的md5值
	 * 
	 * @param File
	 * @return
	 */
	public static String getMd5(File file) {
		FileInputStream fis = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		log.info("MD5摘要长度：" + md5.getDigestLength());
		try {
			fis = new FileInputStream(file);
			byte[] buffer = new byte[2048];
			int length = -1;
			log.info("开始生成摘要");
			long s = System.currentTimeMillis();
			while ((length = fis.read(buffer)) != -1) {
				md5.update(buffer, 0, length);
			}
			log.info("摘要生成成功,总用时: " + (System.currentTimeMillis() - s) + "ms");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		byte[] bs = md5.digest();
		return new String(new Hex().encode(bs));
	}

	public static String getMd5(byte[] file) {
		final int STEP_LEN = 1024;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		log.info("MD5摘要长度：" + md5.getDigestLength());

		int start = 0;
		log.info("开始生成摘要");
		long s = System.currentTimeMillis();
		
		while (start + STEP_LEN < file.length) {
			md5.update(file, start, STEP_LEN);
			start += STEP_LEN;
		}
		md5.update(file, start, file.length - start);
		
		log.info("摘要生成成功,总用时: " + (System.currentTimeMillis() - s) + "ms");
		byte[] bs = md5.digest();
		return new String(new Hex().encode(bs));
	}
}