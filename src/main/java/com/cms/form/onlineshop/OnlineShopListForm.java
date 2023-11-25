package com.cms.form.onlineshop;

import com.cms.form.BaseForm;

import lombok.Getter;
import lombok.Setter;

/**
 * 網路店 検索用リクエストデータ
 */
@Getter
@Setter
public class OnlineShopListForm extends BaseForm {



	private String shopName;

	private String address;
	
//	//全削除の販売店ID（複数件）
//	private String deleteStoreIds;
//	
//	/* 検索結果 */
//	private List <OnlineStoreBean>results;

}