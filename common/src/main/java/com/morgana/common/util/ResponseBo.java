package com.morgana.common.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @ClassName ResponseBo
 * @Description TODO
 * @Author gm
 * @Date 2019/2/19 16:07
 * @Version 1.0
 **/
@ApiModel(value = "响应")
public class ResponseBo<T> implements Serializable{
	
	private static final long serialVersionUID = 7213095123438097838L;

	@ApiModelProperty(value = "响应码", required = true)
	private int code;

	@ApiModelProperty(value = "消息", required = true)
	private String message;

	@ApiModelProperty(value = "数据", required = true)
	private T data;

	public int getCode() {
		return code;
	}

	public ResponseBo<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ResponseBo<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getData() {
		return data;
	}

	public ResponseBo<T> setData(T data) {
		this.data = data;
		return this;
	}

	public static <T> ResponseBo<T> getInstance(T object){
		return new ResponseBo<T>().setData(object);
	}

	public static <T> ResponseBo<T> ok(T object){
		return new ResponseBo<T>().setData(object).setCode(200);
	}

}
