package org.ihsp.data.utils;

import org.ihsp.data.cache.common.ApplicationRequestEnum;

public class ApplicationRequests {
    private static ApplicationRequests requests = new ApplicationRequests();
    public static final String CAR_APPLICATION_ID="402880e54cfad73f014cfad777390001";
    public static ApplicationRequests getInstance() {
        return requests;
    }

    public String doGeostatus(String params) {
        // long time = new Date().getTime();
        // String paramsStr =
        // "{\"cmd\":\"geostatus\", \"macadd\":\"FFFFFFEEEEE1\", \"datapacket\":[{ \"device_add\": \"0001\",\"device_status\": \"01\",\"time\":\""
        // + time + "\"}]}";
        String res = HttpToolkit.doPost(ApplicationRequestEnum.CAR_GEOSTATUS.getValue(), params);
        return res;
    }
    
    public String doVoicecard(String params) {
        // long time = new Date().getTime();
        // String paramsStr =
        // "{   \"cmd\": \"voicecardnum\",  \"macadd\": \"FFFFFFEEEEE1\",   \"datapacket\": [{      \"device_add\": \"0001\",       \"voicecardnum\": \"0088\",         \"time\": \"151686694000\"  }] }";
        String res = HttpToolkit.doPost(ApplicationRequestEnum.CAR_VOICECARD_NUM.getValue(), params);
        return res;
    }
}
