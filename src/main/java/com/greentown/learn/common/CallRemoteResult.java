package com.greentown.learn.common;

import java.io.Serializable;

/**
 * 远程接口调用返回的统一包装类
 *
 * @author lvziqiang
 * @since $Revision:1.0.0, $Date: 2016年1月9日 上午11:22:15 $
 */
public class CallRemoteResult<T> implements Serializable {
    private static final long serialVersionUID = -6162700658277353549L;
    private RemoteResultEnum  resultEnum       = RemoteResultEnum.SUCCESS;
    private T                 returnObject;

    public CallRemoteResult() {
    }

    public CallRemoteResult(RemoteResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }

    public CallRemoteResult(T returnObject) {
        this.returnObject = returnObject;
    }

    public CallRemoteResult(RemoteResultEnum resultEnum, T returnObject) {
        this.resultEnum = resultEnum;
        this.returnObject = returnObject;
    }

    public RemoteResultEnum getResultEnum() {
        return resultEnum;
    }

    public CallRemoteResult<T> setResultEnum(RemoteResultEnum resultEnum) {
        this.resultEnum = resultEnum;
        return this;
    }

    public T getReturnObject() {
        return returnObject;
    }

    public CallRemoteResult<T> setReturnObject(T returnObject) {
        this.returnObject = returnObject;
        return this;
    }

    public boolean isSuccessful() {
        return this.getResultEnum() != null
               && this.getResultEnum().getResultCode() == RemoteResultEnum.SUCCESS.getResultCode();
    }

	public boolean isFailed() {
		return !isSuccessful();
	}
}