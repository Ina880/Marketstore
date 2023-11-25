package com.cms.service.marketstore;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
				
				//未有資料時，給予初始值"0"
				if (maxId == null){
					maxId = "0";
				}
				
				
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

	@Override
	public MarketStoreForm editInit(MarketStoreForm form) {
		
		MarketStoreBean sqlBean = new MarketStoreBean();
         sqlBean.setStoreId(form.getStoreId());
		
		List<MarketStoreBean> searchResults = mapper.select(sqlBean);
		if (!CollectionUtils.isEmpty(searchResults)) {
			MarketStoreBean result = searchResults.get(0);

			
			form.setStoreId(result.getStoreId());
			
			form.setStoreName(result.getStoreName());
			
			form.setAddress(result.getAddress());
	
			form.setPhone(result.getPhone());
			
			form.setStartDay(result.getStartDay());
			
			form.setFinishDay(result.getFinishDay());
			
			form.setRegistDay(result.getRegistDay());
			
			form.setUpdateDay(result.getUpdateDay());
			
		}
		return null;
	}

	@Override
	public void update(MarketStoreForm form) {
		// 画面から社員IDを取得する
				String id = form.getStoreId();
				// ログイン情報を検索する
				MarketStoreBean bean = new MarketStoreBean();
				bean.setStoreId(id);

				List<MarketStoreBean>results = mapper.select(bean);
				MarketStoreBean updateBean = results.get(0);
                
				updateBean.setStoreId(form.getStoreId());
                updateBean.setStoreName(form.getStoreName());
				updateBean.setAddress(form.getAddress());
		        updateBean.setPhone(form.getPhone());
				updateBean.setStartDay(form.getStartDay());
                updateBean.setFinishDay(form.getFinishDay());
                updateBean.setRegistDay(form.getRegistDay());
				updateBean.setUpdateDay(form.getUpdateDay());
				
				mapper.update(updateBean);
		
	}
	
	@Override
	public void delete(String storeId) {
		//社員ID
			MarketStoreBean deleteBean = new MarketStoreBean();
			deleteBean.setStoreId(storeId);
			mapper.delete(deleteBean);
		}
	/**
	 * ユーザー情報を削除する
	 * 
	 * @param form フォーム
	 * @return 検索結果
	 */
	public void deleteAll(String storeIds ) {
		
		String[] delIds = storeIds.split(",");
		mapper.deleteAll(delIds);

	}
}

