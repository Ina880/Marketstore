package com.cms.controller.marketstore;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cms.common.UrlConst;
import com.cms.controller.base.ControllerBase;
import com.cms.form.marketstore.MarketStoreForm;
import com.cms.service.marketstore.MarketStoreService;

/**
 * ログイン コントローラー
 */
@Controller
@RequestMapping(value = "/marketstore/marketstoreadd")
public class MarketStoreAddController extends ControllerBase {
	
	@Autowired
	MarketStoreService service;
	/**
	 * 販売店登録画面を初期化する
	 */
	@RequestMapping(method = RequestMethod.GET)
	private String init(Model model) {
		// init初期化
		
		MarketStoreForm initForm = new MarketStoreForm();
		
		
		model.addAttribute("form", initForm);

		return "/marketstore/marketstoreadd";
	}

	

/**
 * 保存ボタンを押下する
 */
@RequestMapping(params = "insert", method = RequestMethod.POST)
public String insert(@ModelAttribute("form") @Valid MarketStoreForm form, BindingResult result, Model model) {
	                                          //Valid:在form裡，上方有@都要check; Binding 跟form 綁定
   
	if (result.hasErrors()) {
		model.addAttribute("form", form);
		return null;
	}

	try {
		service.insert(form);
	} catch (Exception e) {

		model.addAttribute("errorMessage", "システムエラーが発生しました。管理員へご連絡ください。");
//		model.addAttribute("form", form);
		return null;
	}

	return UrlConst.redirect_cmsemployeelist;
}


/**
 * 「戻る」ボタンを押下する
 */
@RequestMapping(params = "gotoMarketStoreList", method = RequestMethod.POST)
public String gotoMarketStoreList (Model model) {

	
	return "redirect:/marketstore/marketstorelist"; //redirect畫面遷移
}
 

}