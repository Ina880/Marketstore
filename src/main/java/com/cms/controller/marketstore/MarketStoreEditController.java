package com.cms.controller.marketstore;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cms.controller.base.ControllerBase;
import com.cms.form.cmsemployee.CmsEmployeeForm;
import com.cms.form.marketstore.MarketStoreForm;
import com.cms.mapper.common.CommonMapper;
import com.cms.service.marketstore.MarketStoreService;

/**
 * ログイン コントローラー
 */
@Controller
@RequestMapping(value = "/marketstore/marketstoreedit")
public class MarketStoreEditController extends ControllerBase {

	@Autowired
	MarketStoreService service;

	@Autowired
	CommonMapper commonMapper;

	/**
	 * ユーザ画面初期化
	 */
	@RequestMapping(method = RequestMethod.GET)
	private String init(Model model, @ModelAttribute("selectedStoreId") String selectedStoreId) {

		MarketStoreForm form = new MarketStoreForm();
		form.setStoreId(selectedStoreId);

		service.editInit(form);
		
		model.addAttribute("form", form);
		
		//return null;//下記の書き方と同じです。（編集画面へ遷移できます。）
		return "/marketstore/marketstoreedit";
	
	}

	/**
	 * 保存ボタンを押下する
	 */
	@RequestMapping(params = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute("form") @Valid MarketStoreForm form, BindingResult result, Model model) {

	
		
		if (result.hasErrors()) {
			model.addAttribute("form", form);
			return null;
		}

		service.update(form);

		return "redirect:/marketstore/marketstorelist";
	}

	/**
	 * 「戻る」ボタンを押下する
	 */
	@RequestMapping(params = "gotoMarketStorelist", method = RequestMethod.POST)
	public String gotoMarketStorelist(@ModelAttribute("form") CmsEmployeeForm form, BindingResult result,
			Model model) {

		return "redirect:/marketstore/marketstorelist";
	}

}