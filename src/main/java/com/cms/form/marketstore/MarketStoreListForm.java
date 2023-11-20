package com.cms.form.marketstore;

import java.util.List;

import com.cms.entity.marketstore.MarketStoreBean;
import com.cms.form.BaseForm;

import lombok.Getter;
import lombok.Setter;

/**
 * 販売店 検索用リクエストデータ
 */
@Getter
@Setter
public class MarketStoreListForm extends BaseForm {



	private String storeName;

	private String address;
	
	/* 検索結果 */
	private List<MarketStoreBean> results;

}