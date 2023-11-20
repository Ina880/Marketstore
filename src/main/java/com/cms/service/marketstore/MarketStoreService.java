package com.cms.service.marketstore;

import com.cms.form.marketstore.MarketStoreForm;
import com.cms.form.marketstore.MarketStoreListForm;


public interface MarketStoreService {

	/**
	 * 一覧画面
	 */	
	//一覧画面検索
	public MarketStoreListForm select(MarketStoreListForm form);
	
	/**
	 * 新規画面
	 */
	//新規画面【データ保存】
	public  void insert(MarketStoreForm form);
}
//void 甚麼都不回傳的狀態
