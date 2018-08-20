package com.sadasen.tally.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.LoggerFactory;

import com.sadasen.util.StringUtil;

import ch.qos.logback.classic.Logger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @date 2018年8月18日
 * @author lei.ys
 * @addr home
 * @desc
 */
public class OkHttpUtil {
	
	private static final Logger LOG = (Logger) LoggerFactory.getLogger(OkHttpUtil.class);
	
	private static final String DEFAULT_CHARSET = "UTF-8";
	
	private OkHttpUtil() {
	}
	
	public static void asynPost(String url, String body) {
		asynPost(url, body, DEFAULT_CHARSET);
	}
	
	public static void asynPost(String url, String body, String charset) {
		LOG.debug("okhttp request url : {}, body : {}, charset : {}", url, body, charset);
		if(StringUtil.isEmpty(url)) {
			LOG.error("okhttp request url is empty, url : {}", url);
			return;
		}
		OkHttpClient client = new OkHttpClient.Builder()
				.connectTimeout(10, TimeUnit.SECONDS)
				.writeTimeout(10, TimeUnit.SECONDS)
				.readTimeout(20, TimeUnit.SECONDS)
				.build();
		RequestBody requestBody = FormBody.create(MediaType.parse("application/json;charset="+charset), body);
		final Request request = new Request.Builder()
				.url(url)
				.post(requestBody)
				.build();
		Call call = client.newCall(request);
		call.enqueue(new Callback() {
			
			@Override
			public void onResponse(Call c, Response resp) throws IOException {
				int code = resp.code();
				String res = resp.body().toString();
				if(2==code/100) {
					LOG.info("okhttp request success, resCode : {}", code);
					LOG.debug("resBody : {}", res);
				} else {
					LOG.error("okhttp request some error, url : {}, body : {}, charset : {}, resCode : {}, resBody : {}", url, body, charset, code, res);
				}
			}
			
			@Override
			public void onFailure(Call c, IOException resp) {
				LOG.error("okhttp request failure, url : {}, body : {}, charset : {}", url, body, charset);
			}
		});
	}
	
	public static void post(String url, String body, Callback callBack) {
		post(url, body, DEFAULT_CHARSET, callBack);
	}
	
	public static void post(String url, String body, String charset, Callback callBack) {
		LOG.debug("okhttp request url : {}, body : {}, charset : {}", url, body, charset);
		if(StringUtil.isEmpty(url)) {
			LOG.error("okhttp request url is empty, url : {}", url);
			return;
		}
		OkHttpClient client = new OkHttpClient.Builder()
				.connectTimeout(10, TimeUnit.SECONDS)
				.writeTimeout(10, TimeUnit.SECONDS)
				.readTimeout(20, TimeUnit.SECONDS)
				.build();
		RequestBody requestBody = FormBody.create(MediaType.parse("application/json;charset="+charset), body);
		final Request request = new Request.Builder()
				.url(url)
				.post(requestBody)
				.build();
		Call call = client.newCall(request);
		call.enqueue(callBack);
	}
	
	public static String post(String url, String body, String charset) {
		LOG.debug("okhttp request url : {}, body : {}, charset : {}", url, body, charset);
		if(StringUtil.isEmpty(url)) {
			LOG.error("okhttp request url is empty, url : {}", url);
			return null;
		}
		OkHttpClient client = new OkHttpClient.Builder()
				.connectTimeout(10, TimeUnit.SECONDS)
				.writeTimeout(10, TimeUnit.SECONDS)
				.readTimeout(20, TimeUnit.SECONDS)
				.build();
		RequestBody requestBody = FormBody.create(MediaType.parse("application/json;charset="+charset), body);
		final Request request = new Request.Builder()
				.url(url)
				.post(requestBody)
				.build();
		Call call = client.newCall(request);
		Response resp = null;
		try {
			resp = call.execute();
			int code = resp.code();
			String res = resp.body().toString();
			if(2==resp.code()/100) {
				LOG.info("okhttp request success, resCode : {}", code);
				LOG.debug("resBody : {}", res);
			} else {
				LOG.error("okhttp request some error, url : {}, body : {}, charset : {}, resCode : {}, resBody : {}", url, body, charset, code, res);
			}
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			LOG.error("okhttp request error");
			return null;
		}
	}

}
