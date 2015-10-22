package org.ihsp.data.common;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.ihsp.data.common.MD5Util;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MD5UtilTest {
    private final Log log = LogFactory.getLog(MD5UtilTest.class);
    String str = "testtest12wq12";
    String salt = "FLY12WQ!@wq";
    int count = 2;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testGetMd5String() {
        log.info("--------------------------------");
        log.info("MD5Util.getMd5(str):" + MD5Util.getMd5(str));
        log.info("Md5Hash(str).toHex():" + new Md5Hash(str).toHex());
        log.info("--------------------------------");
        log.info("Md5Hash(str).toBase64():" + new Md5Hash(str).toBase64());
        log.info("--------------------------------");
        log.info("Sha512Hash(str, salt, count).toBase64():" + new Sha512Hash(str, salt, count).toBase64());
        log.info("Sha512Hash(str, salt, count).toHex():" + new Sha512Hash(str, salt, count).toHex());
        log.info("Sha512Hash(str, salt, count).toString():" + new Sha512Hash(str, salt, count).toString());
        Assert.assertEquals(MD5Util.getMd5(str), new Md5Hash(str).toHex());
    }

    @Test
    public void testGetDefaultPasswd() {
        //fail("Not yet implemented");
    }

    @Test
    public void testGetMd5File() {
        //fail("Not yet implemented");
    }

    @Test
    public void testGetMd5ByteArray() {
        //fail("Not yet implemented");
    }

}
