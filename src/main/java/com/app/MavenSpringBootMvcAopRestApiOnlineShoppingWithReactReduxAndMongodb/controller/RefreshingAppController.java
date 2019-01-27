package com.app.MavenSpringBootMvcAopRestApiOnlineShoppingWithReactReduxAndMongodb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RefreshingAppController {
				
	@RequestMapping({
		"/",
		"/home",
		"/saveprod",
		"/getmenshoes",
		"/getmenshirts",
		"/getmentshirts",
		"/getmenjeans",
		"/getmenbelts",
		"/getmenwatches",
		"/getwomensarees",
		"/getwomenbags",
		"/getwomenjewellery",
		"/getwomensandals",
		"/getwomensalwar",
		"/getwomenwatches",
		"/updateprod",
		"/contactme"
	})
	public String showHomePageAfterRefreshingAppThroughBrowser() {
		return "forward:/index.html";
	}
}
