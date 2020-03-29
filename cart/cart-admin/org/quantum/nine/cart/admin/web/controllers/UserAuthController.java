package org.quantum.nine.jcart.admin.web.controllers;
/*
 * @author mmdukb
 * 
 */

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.quantum.nine.jcart.JCartException;
import org.quantum.nine.jcart.admin.web.utils.WebUtils;
import org.quantum.nine.jcart.common.services.EmailService;
import org.quantum.nine.jcart.admin.web.utils.MessageCodes.*;
import org.quantum.nine.jcart.security.*;

@Controller
public class UserAuthController extends JAbstractAdminController {
	
	private static final String viewPrefix = "public/";
	
	@Autowired
	protected SecurityService securityService ;
	@Autowired
	protected EmailService emailService;

	@Autowired 
	protected PasswordEncoder passwordEncoder;
	
	@Autowired
	protected TemplateEngine templateEngine;	
	
	
	@Override
	protected String getHeaderTitle()
	{
		return "User";
	}
	
	
	@RequestMapping(value="/forgotPwd", method=RequestMethod.GET)
	public String forgotPwd()
	{
		return viewPrefix+"forgotPwd";
	}
	
	// handle forget password process
	
	@RequestMapping(value="/forgotPwd", method=RequestMethod.POST)
	public String handleForgotPwd(HttpServletRequest request, RedirectAttributes redirectAttributes)
	{
		String email = request.getParameter("email");
		try
		{
			//generates a token (UUID.randomUUID().toString()) and store it in USERS.PASSWORD_RESET_TOKEN column.
			String token = securityService.resetPassword(email);		
			String resetPwdURL = WebUtils.getURLWithContextPath(request)+"/resetPwd?email="+email+"&token="+token;
			this.sendForgotPasswordEmail(email, resetPwdURL);			
			redirectAttributes.addFlashAttribute("msg", getMessage(INFO_PASSWORD_RESET_LINK_SENT));
		} catch (JCartException e)
		{
			logger.error(e);
			redirectAttributes.addFlashAttribute("msg", e.getMessage());
		}
		return "redirect:/forgotPwd";
	}
	
	
	@RequestMapping(value="/resetPwd", method=RequestMethod.GET)
	public String resetPwd(HttpServletRequest request, 
	                       Model model, 
	                       RedirectAttributes redirectAttributes)
	{
		String email = request.getParameter("email");
		String token = request.getParameter("token");
		
		boolean valid = securityService.verifyPasswordResetToken(email, token);
		if(valid){
			model.addAttribute("email", email);
			model.addAttribute("token", token);			
			return "public/resetPwd";	
		} else {
			redirectAttributes.addFlashAttribute("msg", 
			    getMessage(ERROR_INVALID_PASSWORD_RESET_REQUEST));
			return "redirect:/login";
		}
		
		
		// handle reset password process
		
		@RequestMapping(value="/resetPwd", method=RequestMethod.POST)
		public String handleResetPwd(HttpServletRequest request, 
		                             RedirectAttributes redirectAttributes)
		{
			try
			{
				String email = request.getParameter("email");
				String token = request.getParameter("token");
				String password = request.getParameter("password");
				String confPassword = request.getParameter("confPassword");
				if(!password.equals(confPassword))
				{
					model.addAttribute("email", email);
					model.addAttribute("token", token);	
					model.addAttribute("msg", getMessage(ERROR_PASSWORD_CONF_PASSWORD_MISMATCH));
					return "public/resetPwd";
				}
				String encodedPwd = passwordEncoder.encode(password);
				securityService.updatePassword(email, token, encodedPwd);
				
				redirectAttributes.addFlashAttribute("msg", 
				    getMessage(INFO_PASSWORD_UPDATED_SUCCESS));
			} catch (JCartException e)
			{
				logger.error(e);
				redirectAttributes.addFlashAttribute("msg", 
				    getMessage(ERROR_INVALID_PASSWORD_RESET_REQUEST));
			}
			return "redirect:/login";
		}
	
		// send forgot password email process

	protected void sendForgotPasswordEmail(String email, String resetPwdURL)
	{
		try {
			
			// Prepare the evaluation context
	        final Context ctx = new Context();
	        ctx.setVariable("resetPwdURL", resetPwdURL);

	        // Create the HTML body using Thymeleaf
	        final String htmlContent = this.templateEngine.process("forgot-password-email", ctx);
	        
			emailService.sendEmail(email, getMessage(LABEL_PASSWORD_RESET_EMAIL_SUBJECT), htmlContent);
		} catch (JCartException e) {
			logger.error(e);
		}
	}
}
