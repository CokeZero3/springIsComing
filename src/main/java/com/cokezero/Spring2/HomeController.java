package com.cokezero.Spring2;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	private DataSource dataSource;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		try {
				dataSource.getConnection();
				logger.info("DB Connection Success");
		} catch (SQLException e) {
			e.printStackTrace();
			logger.info("DB Connection failed");
		}
		return "home";
}

	@RequestMapping(value="/loginPage")
	public String loginPage() {
		return "loginPage";
		
	}
	
}
