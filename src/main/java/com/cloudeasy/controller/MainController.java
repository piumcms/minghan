package com.cloudeasy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cloudeasy.bean.TreeNode;
import com.cloudeasy.model.Resource;
import com.cloudeasy.model.User;
import com.cloudeasy.service.MenuService;
import com.cloudeasy.service.login.GetUserService;
import com.cloudeasy.utils.SessionUtils;
import com.cloudeasy.utils.TreeUtil;
@Controller
@PropertySource("classpath:resources.properties")
public class MainController extends BaseController {

	/**
	 * serialId
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 日志记录器
	 */
	private final static Logger log = Logger.getLogger(MainController.class);
	
	@Autowired
	private Environment env;
	
	/**
	 * 获取当前登录用户
	 */
	@Autowired
	protected GetUserService getUserService;
	
	/**
	 * 获取资源
	 */
	@Autowired
	private MenuService menuService;

	/**
	 * @return env 
	 */
	
	public Environment getEnv() {
		return env;
	}

	/** 
	 * @param env 要设置的 env 
	 */
	public void setEnv(Environment env) {
		this.env = env;
	}

	/**
	 * 登录页面
	 * 
	 * @param url
	 * @return string
	 */
	@RequestMapping("/login.html")
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return "/login";
	}

	/**
	 * 登录
	 * @param username 邮箱登录账号
	 * @param password 密码
	 * @param verifyCode 验证码
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/logon.html")
	public void  toLogin(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 获取HttpSession中的验证码
		String verifyCode = (String) request.getSession().getAttribute(
				"validateCode");
		// 获取用户请求表单中输入的验证码
		String submitCode = WebUtils.getCleanParam(request, "validateCode");
		
		log.info("用户[" + username + "]登录时输入的验证码为[" + submitCode
				+ "],HttpSession中的验证码为[" + verifyCode + "]");
		SessionUtils.removeValidateCode(request);//清除验证码，确保验证码只能用一次
		if(StringUtils.isBlank(verifyCode)){
			sendFailureMessage(response,"","验证码不能为空.");
			return;
		}
		
		if (StringUtils.isEmpty(submitCode)
				|| !StringUtils.equalsIgnoreCase(verifyCode, submitCode)) {
			sendFailureMessage(response,"","验证码输入错误.");
			return;
		}
		
		if(StringUtils.isBlank(username)){
			sendFailureMessage(response,"","账号不能为空.");
			return;
		}
		if(StringUtils.isBlank(password)){
			sendFailureMessage(response,"","密码不能为空.");
			return;
		}
		
		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		token.setRememberMe(true);
		
		log.info("为了验证登录用户而封装的token为"
				+ ReflectionToStringBuilder.toString(token,
						ToStringStyle.MULTI_LINE_STYLE));
		
		Subject currentUser = SecurityUtils.getSubject();
		
		try {
			
			log.info("对用户[" + username + "]进行登录验证..验证开始");
			currentUser.login(token);
			log.info("对用户[" + username + "]进行登录验证..验证通过");
			
			log.info("current user store session");
			User user = getUserService.execute(username);
			SessionUtils.setUser(request, user);
		} catch (Exception uae) {
			uae.printStackTrace();
			log.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
			sendFailureMessage(response,"", "用户名或密码不正确");
			return;
		} 
		
		String msg = "用户登录日志:";
		
		//记录成功登录日志
		log.debug(msg+"["+username+"]"+"登录成功");
		sendSuccessMessage(response,"", "登录成功.");
	}
	
	@RequestMapping("/main.html")
	public String main(HttpServletRequest request) throws Exception {

		
		return "/main/main";
	}
	@RequestMapping("/top.html")
	public String top(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return "/main/top";
	}
	
	@RequestMapping("/left.html")
	public String toLeft(HttpServletRequest request, Model model)
			throws Exception {
		User user = super.getLoginUser(request);
		// 超级管理员
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", user.getUsername());
		map.put("flag", super.getUrlFlag(request));
		List<Resource> list = menuService.execute(map);
		model.addAttribute("menuList",TreeNode.getTreeNodes(list, null));
		model.addAttribute("user", user);
		return "/main/left";
	}
	
	@RequestMapping("/center.html")
	public String toCenter(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return "/main/center";
	}
	
	@RequestMapping("/right.html")
	public String toRight(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return "/main/right";
	}
	
	@RequestMapping("/down.html")
	public String toDown(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return "/main/down";
	}
	
	@RequestMapping("/logout.html")
	public String logout() {
		
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return "/login";
	}
	/**
	 * 构建树形数据
	 * @return
	 */
	private List<TreeNode> treeMenu(List<Resource> rootMenus,List<Resource> childMenus){
		TreeUtil util = new TreeUtil(rootMenus,childMenus);
		return util.getTreeNode();
	}
	
	public String encodePassphrase(String rawPassphrase, String salt) {
	
		return new Sha512Hash(rawPassphrase, getCombinedSalt(salt), getIterations()).toBase64();
	}
	public static String getSalt() {
		return new SecureRandomNumberGenerator().nextBytes().toBase64();
	}

	public String getApplicationSalt() {
		return env.getProperty("shiro.applicationSalt");
	}

	public String getCombinedSalt(String salt) {
		return  salt;
	}

	public Integer getIterations() {
		return Integer.parseInt(env.getProperty("shiro.hashIterations"));
	}
	
	public static void main(String[] args) {
		String salt = new SecureRandomNumberGenerator().nextBytes().toBase64();
		System.out.println(salt);
		
		 String s = new Sha512Hash("123456", salt, 1024).toBase64();
		 
		 System.out.println(s);
	}
}
