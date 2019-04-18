package com.example.helloSpringBoot.util;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 存放到session的微信用户信息
 *
 * @author lifq
 *
 *         2018年10月17日 下午4:14:33
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WxUserInfoContext implements Serializable {

    private static final long serialVersionUID = -1060216618475607933L;

	private Integer id;
	
	private String openid;
	private String unionid;
	private String nickname;
	private String phone;//没有区号的手机号
	private String phonecode;//区号
	private String gender;
	private String language;
	private String country;
	private String province;
	private String city;
	private String avatarurl;
	private String sessionkey;


}
