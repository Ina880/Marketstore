package com.cms.form.marketstore;
import javax.validation.constraints.NotEmpty;

import com.cms.form.BaseForm;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 販売店情報 検索用リクエストデータ
 */
@Getter
@Setter
@Data
public class MarketStoreForm extends BaseForm {

	/* 検索結果 */
	
	private String storeId;
	
	@NotEmpty
	private String storeName;
	
	@NotEmpty
	private String address;
	
	
	@NotEmpty
	private String phone;
	
	@NotEmpty
	private  String startDay;
	
	@NotEmpty
	private  String finishDay;
	
	@NotEmpty
	private  String registDay;
	
	@NotEmpty
	private  String updateDay;
	 
	
	
}