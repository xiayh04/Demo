package org.ihsp.data.utils;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ihsp.data.utils.HttpToolkit;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class HttpTookitTest {
    private static Log log = LogFactory.getLog(HttpTookitTest.class);
    private static Map<String, String> deviceDataMap = new HashMap<String, String>();
    private String deviceDataString = "[{\"infor\" : \"213123\",\"mac\" : \"1000001\",\"descr\" : \"\",\"applicationId\":\"402880e54cfad73f014cfad777390001\"}]";
    private String geostatusUrl = "http://115.29.232.47:8080/TraWeb/rest/gateway/geostatus";
    
    @BeforeClass
    public static void init() {
        // for device data
        deviceDataMap.put("infor", "213123");
        deviceDataMap.put("mac", "1000001");
        deviceDataMap.put("descr", "");
        deviceDataMap.put("applicationId", "402880e54cfad73f014cfad777390001");
    }

    @Test
    public void testDoGetGetDeviceDatas() {
        String url = "http://114.215.131.159/imp/api/getDeviceDatas.do?page=1&start=0&limit=100&applicationId=402880e54cfad73f014cfad777390001&macs=1000001&startTime=1431199555000";
        try {
            String res = HttpToolkit.doGet(url);
            log.info("response text: " + res);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Ignore
    @Test
    public void testDoPostSaveDeviceDatas() {
        String url = "http://114.215.131.159/imp/api/saveDeviceDatas.do?applicationId=402880e54cfad73f014cfad777390001";

        try {
            String res = HttpToolkit.doPost(url, deviceDataString);
            log.info(res);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Ignore
    @Test
    public void testDoPost() {
        try {
            long time = new Date().getTime();

            String params = "{\"cmd\":\"geostatus\", \"macadd\":\"FFFFFFEEEEE1\", \"datapacket\":[{ \"device_add\": \"0001\",\"device_status\": \"01\",\"time\":\"" + time + "\"}]}";
            log.info("post:" + params);
            String res = HttpToolkit.doPost(geostatusUrl, params);
            log.info(res);
            Assert.assertEquals("{\"cmd\":\"geostatus\",\"res\":\"true\"}", res);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
