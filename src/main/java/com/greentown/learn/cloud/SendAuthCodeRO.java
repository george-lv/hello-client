
package com.greentown.learn.cloud;



/**
 * 发送校验吗
 * @author lvziqiang
 * @version $Id: SendAuthCodeRO.java, v0.1 2016年11月15日 下午2:51:30 hofon Exp $
 */
public class SendAuthCodeRO extends BaseRO {

    /** SID */
    private static final long serialVersionUID = -7659979213142767821L;

    private String            mobile;

    private String            bizNo;
    
    private String            templateNo;

    /** 验证码类型 S:一次性验证码,R:多次验证码 */
    private String            authType         = "R";

    /** 已验证次数 */
    private Long           verifiedCount    = 0l;

    /**  可验证次数 默认3次 */
    private Long           verifiableCount  = 3l;

    /** 验证码长度 默认4位 */
    private Integer           codeLength       = 4;

    /** 有效时间 默认3分钟 */
    private Integer           validPeriod      = 180;

    /** 扩展信息 */
    private String            ext;

    /**
     * Getter method for property <tt>mobile</tt>.
     * 
     * @return property value of mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Setter method for property <tt>mobile</tt>.
     * 
     * @param mobile value to be assigned to property mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Getter method for property <tt>bizNo</tt>.
     * 
     * @return property value of bizNo
     */
    public String getBizNo() {
        return bizNo;
    }

    /**
     * Setter method for property <tt>bizNo</tt>.
     * 
     * @param bizNo value to be assigned to property bizNo
     */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    /**
     * Getter method for property <tt>templateNo</tt>.
     * 
     * @return property value of templateNo
     */
    public String getTemplateNo() {
        return templateNo;
    }

    /**
     * Setter method for property <tt>templateNo</tt>.
     * 
     * @param templateNo value to be assigned to property templateNo
     */
    public void setTemplateNo(String templateNo) {
        this.templateNo = templateNo;
    }

    /**
     * Getter method for property <tt>authType</tt>.
     * 
     * @return property value of authType
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * Setter method for property <tt>authType</tt>.
     * 
     * @param authType value to be assigned to property authType
     */
    public void setAuthType(String authType) {
        this.authType = authType;
    }

   
    public Long getVerifiedCount() {
		return verifiedCount;
	}

	public void setVerifiedCount(Long verifiedCount) {
		this.verifiedCount = verifiedCount;
	}

	public Long getVerifiableCount() {
		return verifiableCount;
	}

	public void setVerifiableCount(Long verifiableCount) {
		this.verifiableCount = verifiableCount;
	}

	/**
     * Getter method for property <tt>codeLength</tt>.
     * 
     * @return property value of codeLength
     */
    public Integer getCodeLength() {
        return codeLength;
    }

    /**
     * Setter method for property <tt>codeLength</tt>.
     * 
     * @param codeLength value to be assigned to property codeLength
     */
    public void setCodeLength(Integer codeLength) {
        this.codeLength = codeLength;
    }

    /**
     * Getter method for property <tt>validPeriod</tt>.
     * 
     * @return property value of validPeriod
     */
    public Integer getValidPeriod() {
        return validPeriod;
    }

    /**
     * Setter method for property <tt>validPeriod</tt>.
     * 
     * @param validPeriod value to be assigned to property validPeriod
     */
    public void setValidPeriod(Integer validPeriod) {
        this.validPeriod = validPeriod;
    }

    /**
     * Getter method for property <tt>ext</tt>.
     * 
     * @return property value of ext
     */
    public String getExt() {
        return ext;
    }

    /**
     * Setter method for property <tt>ext</tt>.
     * 
     * @param ext value to be assigned to property ext
     */
    public void setExt(String ext) {
        this.ext = ext;
    }

}
