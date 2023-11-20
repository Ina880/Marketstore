package com.cms.mapper.marketstore;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cms.entity.marketstore.MarketStoreBean;

/**
 * 販売店情報 Mapper
 */
@Mapper
public interface MarketStoreMapper {
	
	
	/**
	 * 販売店情報検索
	 * 
	 * @param user 検索用リクエストデータ
	 * @return ユーザー情報
	 */
	List<MarketStoreBean> select(MarketStoreBean bean);
	
	/**
	 * 最大販売店IDの取得
	 * 
	 * @return 最大最大販売店
	 */
	String selectMaxId();
	
	/**
	 * 販売店情報登録
	 * 
	 * @param bean 検索用リクエストデータ
	 * @return 登録件数
	 */
	int insert( MarketStoreBean bean);
	
}