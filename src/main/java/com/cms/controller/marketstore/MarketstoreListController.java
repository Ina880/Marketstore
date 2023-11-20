package com.cms.controller.marketstore;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cms.controller.base.ControllerBase;
import com.cms.entity.employee.CmsEmployeeBean;
import com.cms.form.marketstore.MarketStoreListForm;
import com.cms.mapper.common.CommonMapper;
import com.cms.service.marketstore.MarketStoreService;
import com.exception.BusinessException;
import com.utils.ServiceUtils;

/**
 * ログイン コントローラー
 */
@Controller
@RequestMapping(value = "/marketstore/marketstorelist")//定義url跟controller 的action對應
public class MarketstoreListController extends ControllerBase {
private List<CmsEmployeeBean> lst;

	@Autowired
	MarketStoreService service;

	@Autowired
	ServiceUtils serviceUtils;
	
	@Autowired
	CommonMapper commonMapper;
 
	/**
	 * ユーザ画面初期化
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String init(Model model, HttpServletRequest request) {

		
			
			MarketStoreListForm form = new MarketStoreListForm();
			form.setAddress("東京タワー");
			form.setStoreName("桂の店");
			
			model.addAttribute("form", form);//保存form到model，存取前台跟後台的地方
			
		
		
		return "/marketstore/marketstorelist";
	}

	/**
	 * メニュー画面初期化
	 */
	@RequestMapping(params = "select", method = RequestMethod.POST)//form前台的傳過來
	public String select(@ModelAttribute("form") MarketStoreListForm form, Model model, HttpServletRequest request) {
		try {
			service.select(form);
			
		} catch (BusinessException be) {
			
			//業務エラーを画面に表示する
			form.setErrorMessage(be.getMessage());
			model.addAttribute("form", form);//model存取後台的值放到前台
		}
		return  "/marketstore/marketstorelist";
	}
	/**
	 * 新規ボタン
	 */
	@RequestMapping(params = "addStore", method = RequestMethod.POST)
	public String addStore(Model model) {

		
		return "redirect:/marketstore/marketstoreadd"; //redirect畫面遷移
	}
	 
}