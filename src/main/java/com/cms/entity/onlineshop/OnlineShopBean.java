package com.cms.entity.onlineshop;



import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "online_shop")
public class OnlineShopBean {
    @Id
	@Column(name = "shopId")
	private String shopId;
	
	@Column(name = "shopName")
	private String shopName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "startDay")
	private String startDay;
	
	@Column(name = "finishDay")
	private String finishDay;
		
	@Column(name = "registDay")
	private String registDay;
	
	@Column(name = "updateDay")
	private String updateDay;
}
