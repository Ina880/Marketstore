package com.cms.service.marketstore;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.marketstore.MarketStoreBean;
import com.cms.form.marketstore.MarketStoreForm;
import com.cms.form.marketstore.MarketStoreListForm;
import com.cms.mapper.marketstore.MarketStoreMapper;
import com.exception.BusinessException;

/**
 * ユーザー情報 Service
 */
@Service
public class MarketStoreServiceImpl implements MarketStoreService {

	@Autowired//引用mapper
	MarketStoreMapper mapper;//定義mapper局部變量
	
	@Override
	public MarketStoreListForm select(MarketStoreListForm form) {
		
		MarketStoreBean input = new MarketStoreBean();
		if (StringUtils.isNotEmpty(form.getAddress()))  {
			input.setAddress(form.getAddress());
		}
		
		if (StringUtils.isNotEmpty(form.getStoreName()))  {
			input.setStoreName(form.getStoreName());
		}
		
		List<MarketStoreBean> results= mapper.select(input);
		
		if (results == null || results.size() == 0) {
			throw new BusinessException("検索結果はありません。");
		}
		//検索
		form.setResults(results);//html.form的results把list的數據放到data裡面
		return form;
	}

	@Override
	public void insert(MarketStoreForm form) {
		// ログイン情報を検索する
			MarketStoreBean bean = new MarketStoreBean();

				String maxId = mapper.selectMaxId();
				String maxStoreId =String.valueOf(Integer.valueOf(maxId) + 1);
				
				bean.setStoreId(maxStoreId); // 販売店ID
				bean.setStoreName(form.getStoreName());
				bean.setAddress(form.getAddress());
				bean.setPhone(form.getPhone());
				bean.setStartDay(form.getStartDay());
				bean.setFinishDay(form.getFinishDay());
				bean.setRegistDay(form.getRegistDay());
				bean.setUpdateDay(form.getUpdateDay());
				mapper.insert(bean);
				
	}
}

