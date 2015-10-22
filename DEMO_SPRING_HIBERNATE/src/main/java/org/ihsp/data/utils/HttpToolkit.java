package org.ihsp.data.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * HTTP工具箱
 * 
 * @author xia yonghui
 */
public final class HttpToolkit {
    private static Log log = LogFactory.getLog(HttpToolkit.class);
    private static final String USER_AGENT = "Mozilla/5.0";
    private static RequestConfig REQUEST_CONFIG = RequestConfig.custom().setConnectionRequestTimeout(20000).setConnectTimeout(2000).setSocketTimeout(2000).build();

    private static HttpClientBuilder clientBuilder = HttpClientBuilder.create();

    public static String doGet(String urlWithParams) {
        CloseableHttpClient httpclient = clientBuilder.build();

        HttpGet httpget = new HttpGet(urlWithParams);

        CloseableHttpResponse response = null;
        String resStr = null;
        HttpEntity entity = null;
        try {
            response = httpclient.execute(httpget);
            System.out.println("StatusCode -> " + response.getStatusLine().getStatusCode());
            entity = response.getEntity();
            resStr = EntityUtils.toString(entity, "utf-8");

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (entity != null) {
                try {
                    entity.getContent().close();
                } catch (UnsupportedOperationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            httpget.releaseConnection();
        }
        return resStr;
    }

    public static String doGet(String urlWithoutParams, Map<String, String> params) {
        CloseableHttpClient httpclient = clientBuilder.build();

        StringBuilder sb = new StringBuilder(urlWithoutParams);
        int i = 0;
        for (Entry<String, String> entry : params.entrySet()) {
            if (i == 0 && !urlWithoutParams.contains("?")) {
                sb.append("?");
            } else {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            String value = entry.getValue();
            try {
                sb.append(URLEncoder.encode(value, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                log.warn("encode http get params error, value is " + value, e);
                sb.append(URLEncoder.encode(value));
            }
            i++;
        }
        log.info("[HttpUtils Get] begin invoke:" + sb.toString());

        HttpGet httpget = new HttpGet(sb.toString());

        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String resStr = null;
        try {
            response = httpclient.execute(httpget);
            log.info("StatusCode -> " + response.getStatusLine().getStatusCode());
            entity = response.getEntity();
            resStr = EntityUtils.toString(entity, "utf-8");
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (entity != null) {
                try {
                    entity.getContent().close();
                } catch (UnsupportedOperationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            httpget.releaseConnection();
        }


        return resStr;
    }

    public static String doPost(String url, Map<String, String> paramsMap) {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost httppost = new HttpPost(url);

        /*
         * httppost.addHeader("User-Agent", USER_AGENT); httppost.addHeader("Accept-Language",
         * "en-US,en;q=0.5");
         */
        httppost.addHeader("Content-Type", "application/json");
        HttpEntity entity = null;
        String resStr = null;
        CloseableHttpResponse response = null;
        try {
            httppost.setEntity(new UrlEncodedFormEntity(toNameValuePairList(paramsMap)));
            response = httpclient.execute(httppost);
            entity = response.getEntity();
            resStr = EntityUtils.toString(entity, Consts.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (entity != null) {
                try {
                    entity.getContent().close();
                } catch (UnsupportedOperationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            httppost.releaseConnection();
        }

        return resStr;
    }

    public static String doPost(String url, String params) {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost httppost = new HttpPost(url);
        httppost.setHeader("Content-type", "application/json");

        StringEntity stringEntity = new StringEntity(params, ContentType.APPLICATION_JSON);
        httppost.setEntity(stringEntity);

        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String resStr = "";
        try {
            response = httpclient.execute(httppost);
            entity = response.getEntity();
            resStr = EntityUtils.toString(entity, Consts.UTF_8);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            resStr="false";
        } catch (IOException e) {
            e.printStackTrace();
            resStr="false";
        } finally {
            if (entity != null) {
                try {
                    entity.getContent().close();
                } catch (UnsupportedOperationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            httppost.releaseConnection();
        }

        return resStr;
    }

    private static List<NameValuePair> toNameValuePairList(Map<String, String> params) {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        for (String key : params.keySet()) {
            nameValuePairs.add(new BasicNameValuePair(key, params.get(key)));
        }
        return nameValuePairs;
    }
}
