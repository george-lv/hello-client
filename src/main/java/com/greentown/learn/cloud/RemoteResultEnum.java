package com.greentown.learn.cloud;

public enum RemoteResultEnum {
	SUCCESS(0, "成功"), 
	DB_ERROR(1, "数据库异常"), 
	IO_ERROR(2, "I/O异常"),
	PARAMS_ERROR(3, "参数错误"),
	INTERNAL_ERROR(4,"服务器内部错误"),
	NOT_LOGIN_ERROR(5, "用户未登录"),
	ILLEGAL_REQUEST_ERROR(6,"非法的请求"),
	
	REGISTER_PARAMS_ERROR(1000, "注册信息不完整"),
	MOBILE_PHONE_NO_ALREADY_EXISTS(1001, "手机号已被注册,请尝试登陆或找回密码"),
	MOBILE_PHONE_NO_NOT_EXISTS(1002, "手机号不存在"),
	MOBILE_PHONE_NO_OR_PASSWORD_NULL(1003, "手机号和密码不能为空"),
	MOBILE_PHONE_NO_OR_PASSWORD_ERROR(1004, "手机号或密码错误"),
	OLD_PASSWORD_ERROR(1005, "原密码错误"),
	PASSWORD_FORMAT_ERROR(1006, "密码格式错误"),
	MOBILE_PHONE_NO_IS_NULL(1007, "手机号不能为空"),
	MOBILE_PHONE_NO_FORMAT_ERROR(1008, "手机号格式错误"),
	SEND_SMS_CAPTCHA_FAILED(1009, "验证码发送失败，请稍后重试"),
	VERIFY_CODE_ERROR(1010, "验证码错误"),
	MOBILE_BIND_BY_OTHER_USER(1012,"该手机号已被其他用户绑定"),
    THIRD_ACCOUNT_BIND_BY_OTHER_USER(1013,"该第三方账号已被其他用户绑定"),  
    USER_IS_NOT_SUPER_USER(1014,"该用户不是超级用户"), 
    SUPER_USER_VERIFYCODE_ERROR(1015,"超级用户验证码错误"),
    SUPER_USER_VERIFYCODE_ERROR_MAX_TIMES(1016,"超级用户验证码错误超过5次，请重新下发验证码"),
    USER_NOT_PERMISSION(1017, "用户无此操作权限"),
	DUPLICATE_REQUEST(1018, "重复请求"),
	AUTH_CODE_EXPIRE(1019, "验证码失效"),
	INPUT_AUTH_CODE_WRONG(1020, "验证码输入错误"),
	BEYOND_MAXIMUM_TIMES(1021, "输入超过指定错误次数"),
	MSG_TEMPLETE_NOT_EXIST(1022, "短消息模版不存在");
	 
	private int resultCode; // 错误码
	private String message; // 错误信息

	RemoteResultEnum(int resultCode, String message) {
		this.resultCode = resultCode;
		this.message = message;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}