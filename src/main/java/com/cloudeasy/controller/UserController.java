/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.controller;

import java.io.OutputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cloudeasy.dao.AreaMapper;
import com.cloudeasy.dao.CityMapper;
import com.cloudeasy.dao.ProvinceMapper;
import com.cloudeasy.dao.UserMapper;
import com.cloudeasy.dto.user.ListRoleReqDTO;
import com.cloudeasy.dto.user.ListRoleResDTO;
import com.cloudeasy.dto.user.ListUserReqDTO;
import com.cloudeasy.dto.user.ListUserResDTO;
import com.cloudeasy.model.Area;
import com.cloudeasy.model.AreaList;
import com.cloudeasy.model.City;
import com.cloudeasy.model.CityList;
import com.cloudeasy.model.Province;
import com.cloudeasy.model.ProvinceList;
import com.cloudeasy.model.User;
import com.cloudeasy.model.UserRole;
import com.cloudeasy.result.Result;
import com.cloudeasy.service.UserService;
import com.cloudeasy.service.login.GetUserService;
import com.cloudeasy.service.user.DeleteUserService;
import com.cloudeasy.service.user.GetUserByPkeyService;
import com.cloudeasy.service.user.IsUserByEmailService;
import com.cloudeasy.service.user.IsUserByMobileService;
import com.cloudeasy.service.user.IsUserByNameService;
import com.cloudeasy.service.user.SaveRoleUserService;
import com.cloudeasy.service.user.SaveUserService;
import com.cloudeasy.service.user.SelectAllRoleService;
import com.cloudeasy.utils.DateUtil;
import com.cloudeasy.utils.SessionUtils;

/** 
 * @Title: UserController 
 * @Description: TODO
 * @author ll
 * @date 2013-11-19 下午4:07:57 
 * @version V1.0   
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	
	private static final long serialVersionUID = 1358795402845847960L;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DeleteUserService deleteUserService;
	
	@RequestMapping("/list")
	public String showAllUser(ListUserReqDTO dto, HttpServletRequest request, Model model) throws Exception {
		Result result = userService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		return "/user/list";
	}
	
	@RequestMapping("/upPwd.html")
	public String showUpdatePwd(HttpServletRequest request, Model model) throws Exception {
		return "/user/upPwd";
	}
	
	@Autowired
	private SaveUserService saveUserService;
	/**
	 * 修改密码
	 * @param brand
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/updatePwd.html")
	public void saveBrand(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String oldpwd=request.getParameter("oldpwd");
		String pwd=request.getParameter("pwd");
		User user=super.getLoginUser(request);
		try {
			
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),
				oldpwd);
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.login(token);
		    String salt=getSalt();
	        user.setPassword(encodePassphrase(pwd,salt));
	        user.setSalt(salt);
	    	Result  result = saveUserService.execute(user);
			 if (result.getStatus().equals("0")) {
			 	super.sendSuccessMessage(response,"","保存成功");
			 } else {
				super.sendFailureMessage(response,"","保存失败");
			 }
		
		}catch (Exception uae) {
			super.sendFailureMessage(response,"","原始密码错误!");
		} 
	}
	
	@Autowired
	private SelectAllRoleService selectAllRoleService;
	    
	
	/**
	 * 显示添加管理员
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addAdmin.html")
    public String addAdmin(HttpServletRequest request, Model model) throws Exception {
        Result result=selectAllRoleService.execute(new ListRoleReqDTO());
        ListRoleResDTO resDto=(ListRoleResDTO)result.getBaseDTO();
        model.addAttribute("roleList", resDto.getList());
        model.addAttribute("bflag", "1");
        return "/user/addAdminUser";
    }
	
	@Autowired
	private GetUserByPkeyService getUserByPkeyService;
	
	/**
	 * 显示编辑管理员
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editAdmin.html/{id}")
    public String editAdmin(@PathVariable Integer id, HttpServletRequest request, Model model) throws Exception {
        Result result=selectAllRoleService.execute(new ListRoleReqDTO());
        ListRoleResDTO resDto=(ListRoleResDTO)result.getBaseDTO();
        model.addAttribute("roleList", resDto.getList());
        model.addAttribute("bflag", "2");
        User user=new User();
        user.setId(id);
        result=getUserByPkeyService.execute(user);
        user=(User)result.getObj();
        model.addAttribute("user",user);
        return "/user/addAdminUser";
    }
	
	/**
	 * 显示登陆人信息
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showLoginUser.html/{id}")
    public String showLoginUser(@PathVariable Integer id, HttpServletRequest request, Model model) throws Exception {
        Result result=selectAllRoleService.execute(new ListRoleReqDTO());
        ListRoleResDTO resDto=(ListRoleResDTO)result.getBaseDTO();
        model.addAttribute("roleList", resDto.getList());
        model.addAttribute("bflag", "2");
        User user=new User();
        user.setId(id);
        result=getUserByPkeyService.execute(user);
        user=(User)result.getObj();
        model.addAttribute("user",user);
        return "/user/showLoginUser";
    }
	
	/**
	 * 删除管理员
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteAdmin.html/{id}")
    public String deleteAdmin(@PathVariable Integer id, HttpServletRequest request, Model model) throws Exception {
        User user=new User();
        user.setId(id);
        Result result=getUserByPkeyService.execute(user);
        user=(User)result.getObj();
        model.addAttribute("user",user);
        deleteUserService.execute(user);
        ListUserReqDTO dto=new ListUserReqDTO();
        result = userService.execute(dto);
		model.addAttribute("dto", result.getBaseDTO());
		return "/user/list";
    }
	
	
	@Autowired
    private IsUserByNameService isUserByNameService;
    
    @Autowired
    private IsUserByEmailService isUserByEmailService;
    
    @Autowired
    private IsUserByMobileService isUserbyMobileService;
    
    
    @Autowired
    private SaveRoleUserService saveRoleUserService;
    
    /**
     * 保存管理员
     * @param user
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/saveUser.html")
    public void saveAdmin(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        user.setType(0);//超级管理员
        Result result=isUserByNameService.execute(user);
        Integer count=(Integer)result.getObj();
        if(user.getId()==null){
         if(count>0){
            super.sendFailureMessage(response,""," 用户名称已被使用！");
            return;
         }
         result=isUserByEmailService.execute(user);
         count=(Integer)result.getObj();
         if(count>0){
            super.sendFailureMessage(response,""," 邮箱已被使用！");
            return;
         }
         result=isUserbyMobileService.execute(user);
         count=(Integer)result.getObj();
         if(count>0){
            super.sendFailureMessage(response,""," 手机号码已被使用！");
            return;
         }
        }
         UserRole userRole=new UserRole();
         if (user.getId() == null) {
        	 String salt=getSalt();
             
             user.setPassword(encodePassphrase(user.getPassword(),salt));
             user.setSalt(salt); 
         } else{
        	 if (StringUtils.isNotBlank(user.getPassword())) {
        		 String salt=getSalt();
                 
                 user.setPassword(encodePassphrase(user.getPassword(),salt));
                 user.setSalt(salt); 
        	 }
         }
        
        user.setRoleId(user.getRoleId());
        user.setIsDelete(0);
        user.setIsFreeze("0");
        result = saveUserService.execute(user);
        userRole.setUserId(user.getId());
        userRole.setRoleId(user.getRoleId());
        result = saveRoleUserService.execute(userRole);
         if (result.getStatus().equals("0")){//插入成功
             super.sendSuccessMessage(response,"","保存成功");
             return;
         } else {
            super.sendFailureMessage(response,"","保存失败");
            return;
         }
    }
    
    /**
     * 保存管理员
     * @param user
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/register")
    public void register(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        // 获取HttpSession中的验证码
        String verifyCode = (String) request.getSession().getAttribute(
                "validateCode");
        // 获取用户请求表单中输入的验证码
        String submitCode = WebUtils.getCleanParam(request, "validateCode");
        
        SessionUtils.removeValidateCode(request);//清除验证码，确保验证码只能用一次
        if(StringUtils.isBlank(user.getValidateCode())){
            sendFailureMessage(response,"","验证码不能为空.");
            return;
        }
        
        if (StringUtils.isEmpty(user.getValidateCode())
                || !StringUtils.equalsIgnoreCase(verifyCode, user.getValidateCode())) {
            sendFailureMessage(response,"","验证码输入错误.");
            return;
        }
        
        user.setType(1);//普通用户
        user.setPassword("123456");
        Result result=isUserByNameService.execute(user);
        Integer count=(Integer)result.getObj();
        if(user.getId()==null){
         if(count>0){
            super.sendFailureMessage(response,""," 用户名称已被使用！");
            return;
         }
         result=isUserByEmailService.execute(user);
         count=(Integer)result.getObj();
         if(count>0){
            super.sendFailureMessage(response,""," 邮箱已被使用！");
            return;
         }
         result=isUserbyMobileService.execute(user);
         count=(Integer)result.getObj();
         if(count>0){
            super.sendFailureMessage(response,""," 手机号码已被使用！");
            return;
         }
        }
         UserRole userRole=new UserRole();
         if (user.getId() == null) {
             String salt=getSalt();
             
             user.setPassword(encodePassphrase(user.getPassword(),salt));
             user.setSalt(salt); 
         } else{
             if (StringUtils.isNotBlank(user.getPassword())) {
                 String salt=getSalt();
                 
                 user.setPassword(encodePassphrase(user.getPassword(),salt));
                 user.setSalt(salt); 
             }
         }
        
        user.setRoleId(user.getRoleId());
        user.setIsDelete(0);
        user.setIsFreeze("0");
        result = saveUserService.execute(user);
        userRole.setUserId(user.getId());
        userRole.setRoleId(user.getRoleId());
        result = saveRoleUserService.execute(userRole);
         if (result.getStatus().equals("0")){//插入成功
             super.sendSuccessMessage(response,"","保存成功");
             return;
         } else {
            super.sendFailureMessage(response,"","保存失败");
            return;
         }
    }
    
    @Autowired
	private ProvinceMapper  provinceMapper;
    
    @Autowired
   	private CityMapper  	cityMapper;
    
    @Autowired
   	private AreaMapper  	areaMapper;
    
    /**
     * 
     */
    @RequestMapping("/service/area")
    @ResponseBody
    public ModelAndView district(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String provinceid = request.getParameter("provinceid");
    	String cityid = request.getParameter("cityid");
    	ModelAndView mav = new ModelAndView("jaxb2MarshallingView");
    	
    	if (StringUtils.isBlank(provinceid) && StringUtils.isBlank(cityid)){
    		ProvinceList lists = new ProvinceList();
    		List<Province> provinces = provinceMapper.queryByList(null);
    		lists.setProvince(provinces);
    		mav.addObject(lists);
        	return mav;
    	}
    	else if (StringUtils.isNotBlank(provinceid))
    	{
    		City city = new City();
    		city.setFather(provinceid);
    		
    		CityList lists = new CityList();
    		List<City> cities = cityMapper.queryByList(city);
    		lists.setCity(cities);
    		mav.addObject(lists);
        	return mav;
    	}
    	else if (StringUtils.isNotBlank(cityid))
    	{
    		Area area = new Area();
    		area.setFather(cityid);
    		
    		AreaList lists = new AreaList();
    		List<Area> cities = areaMapper.queryByList(area);
    		lists.setArea(cities);
    		mav.addObject(lists);
        	return mav;
    	}
    	
    	return mav;
    	
    }
    
    /**
     * 保存客户资料
     * 姓名：username
手机：mobile
所在地：sheng（暂时坐在FLASH内，不用另外接口）
地址：address
孩子年龄：c_age
邮箱：email
     * @param user
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/service/game")
    @ResponseBody
    public ModelAndView flashRequest( 
    		HttpServletRequest request, HttpServletResponse response) throws Exception {
    	User user = new User();
    	user.setUsername(request.getParameter("username"));
    	user.setMobilePhone(request.getParameter("mobile"));
    	user.setProvince(request.getParameter("province"));
    	user.setAddress(request.getParameter("address"));
    	user.setAge(request.getParameter("age")==null?null:Integer.valueOf(request.getParameter("age").toString()));
    	user.setEmail(request.getParameter("email"));
    	ModelAndView mav = new ModelAndView("jaxb2MarshallingView");
    	String ip = getIpAddr(request);
    	user.setTheIp(ip);
    	String msg = validateUser(user);
    	com.cloudeasy.model.Result res = new com.cloudeasy.model.Result();
    	if(StringUtils.isNotBlank(msg)){
    		res.setFlag("0");
    		res.setMessage(msg);
    	}else{
    		user.setIsDelete(0);
    		Result result = saveUserService.execute(user);
    		Integer userId = user.getId();
    		
    		ListUserReqDTO dto=new ListUserReqDTO(); 
    		dto.setMonthStart(DateUtil.getMonthFirstDay());
    		dto.setMonthEnd(DateUtil.getMonthLastDay());
    		int num = userMapper.hasMoreTenWin(dto);
    		//验证是否这个月已有十人中奖？
    		if(num<10&&canWin(user)){
    			long random = Math.round(Math.random()*(999999998)+1);
        		if(random % 3 == 0){
        			User u = new User();
        			u.setId(userId);
        			u.setWin("1");
        			//中奖添加标志
            		int win = userMapper.updateByPrimaryKeySelective(u);
            		res.setFlag("2");
        		}else{
        			res.setFlag("1");
        		}
    		}
    		else
    		{
    			res.setFlag("1");
    		}
    	}
    	mav.addObject(res);
    	return mav;
    }
    

	@Autowired
	private UserMapper  userMapper;
    
    private String validateUser(User user) throws Exception{
    	
    	if(null!=user){
    		
    		if(StringUtils.isBlank(user.getUsername())){
    			return "姓名不能为空";
    		}else if(user.getUsername().length()>=20){
    			return "姓名不能超过20个字符";
    		}
    		
    		if(StringUtils.isBlank(user.getMobilePhone())){
    			return "手机号码不能为空";
    		}else if(user.getMobilePhone().length()!=11){
    			return "您填写的手机号不合法";
    		}
    		
    		if(StringUtils.isBlank(user.getProvince())){
    			return "所在地不能为空";
    		}else if(user.getProvince().length()>=30){
    			return "您输入的所在地不能超过30个字符";
    		}
    		
    		if(StringUtils.isBlank(user.getAddress())){
    			return "地址不能为空";
    		}else if(user.getAddress().length()>=60){
    			return "您输入的地址不能超过60个字符";
    		}
    		
    		if(null==user.getAge()){
    			return "孩子年龄不能为空";
    		}
    		
    		if(StringUtils.isBlank(user.getEmail())){
    			return "邮箱不能为空";
    		}else if(!getEmail(user.getEmail())){
    			return "您输入的邮箱不合法";
    		}
    		
    		Result result=isUserByNameService.execute(user);
            Integer count=(Integer)result.getObj();
            if(user.getId()==null){
	             if(count>0){
	                return "姓名已被使用!";
	             }
	             result=isUserByEmailService.execute(user);
	             count=(Integer)result.getObj();
	             if(count>0){
	                return "邮箱已被使用!";
	             }
	             result=isUserbyMobileService.execute(user);
	             count=(Integer)result.getObj();
	             if(count>0){
	                return "手机号码已被使用!";
	             }
	             ListUserReqDTO dto=new ListUserReqDTO();
	 			 dto.setIp(user.getTheIp());
	 	  		dto.setMonthStart(DateUtil.getMonthFirstDay());
	    		dto.setMonthEnd(DateUtil.getMonthLastDay());
	             count = userMapper.isUserIp(dto);
	             if(count>0){
	                 return "IP地址已被使用!";
	             }
            }
    	}
        return "";
    }
    
    /**
     * 判断客户是否符合抽奖
     * @return boolean
     * */
    private static final String GUANGDONG 	= "440000";
    private static final String ZHEJIANG	= "330000";
    private static final String JIANGSU 	= "320000";
    private static final String HUNAN 		= "430000";
    private static final String HEBEI 		= "130000";
    private static final String SANDONG 	= "370000";
    
    private static boolean canWin(User user){
    	/*广东、浙江、江苏、湖南、河北、山东共6个省份，
    	孩子年龄：3-12岁*/
    	if(null!=user.getProvince()&&null!=user.getAge()){
    		String province = user.getProvince();
    		/*广东省</province><provinceID>440000*/
    		/*江苏省</province><provinceID>320000*/
    		/*浙江省</province><provinceID>330000*/
    		/*湖南省</province><provinceID>430000
    		河北省</province><provinceID>130000
    		山东省</province><provinceID>370000*/
    		if((province.equals(GUANGDONG)||province.equals(ZHEJIANG)||province.equals(JIANGSU)
    				||province.equals(HUNAN)||province.equals(HEBEI)
    				||province.equals(SANDONG))
    				&&(user.getAge()>=3&&user.getAge()<=12)){
    			return true;
    		}
    	}
    	return false;
    }
    
    private static boolean getEmail(String line){
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(line);
        return m.find();
    }
    
    public String getIpAddr(HttpServletRequest request) { 
        String ip = request.getHeader("x-forwarded-for"); 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("Proxy-Client-IP"); 
        } 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("WL-Proxy-Client-IP"); 
        } 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    	  ip = request.getRemoteAddr(); 
        }
        return ip; 
    }
	  
	 @Autowired
      private Environment env;
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

	    @RequestMapping("/bbjuserlist")
		public String showBbjAllUser(ListUserReqDTO dto,HttpServletRequest request, Model model) throws Exception{
			Result result = userService.execute(dto);
			model.addAttribute("dto",result.getBaseDTO());
			return "/user/bbjuserlist";
		}
	    
	    @RequestMapping("/userExport")
		public String listExclePro(ListUserReqDTO dto,HttpServletRequest request,HttpServletResponse response, Model model) throws Exception{
			Result result = userService.executeExcel(dto);
			ListUserResDTO userdto = (ListUserResDTO)result.getBaseDTO();

			HSSFWorkbook wb = userService.listExcel(userdto.getList(),response);
			String excelName = "userAllExport.xls";  
			response.setContentType("application/x-msdownload");  
			response.setHeader("Content-Disposition", "attachment; filename="+excelName );
			OutputStream fout = response.getOutputStream();
			response.flushBuffer();
			wb.write(fout);
			fout.close();
			return null;
		}
	    
		@RequestMapping(value="/agreement.html")
		public ModelAndView aggrement(HttpServletRequest request,Model model) throws Exception {
			ModelAndView mv = new ModelAndView("user/agreement");
			return mv;
		}
		
		@RequestMapping(value="/register.html")
		public ModelAndView register(HttpServletRequest request,Model model) throws Exception {
			ModelAndView mv = new ModelAndView("user/register");
			return mv;
		}
		
	    
	    /**
	     * 保存管理员
	     * @param user
	     * @param request
	     * @param response
	     * @throws Exception
	     */
	    @RequestMapping("/doRegister.html")
	    public void registerAction(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
	        Result result=isUserByNameService.execute(user);
	        Integer count=(Integer)result.getObj();
	        if(user.getId()==null){
	         if(count>0){
	            super.sendFailureMessage(response,""," 用户名称已被使用！");
	            return;
	         }
	         result=isUserByEmailService.execute(user);
	         count=(Integer)result.getObj();
	         if(count>0){
	            super.sendFailureMessage(response,""," 邮箱已被使用！");
	            return;
	         }
	         result=isUserbyMobileService.execute(user);
	         count=(Integer)result.getObj();
	         if(count>0){
	            super.sendFailureMessage(response,""," 手机号码已被使用！");
	            return;
	         }
	        }
	         UserRole userRole=new UserRole();
	         if (user.getId() == null) {
	             String salt=getSalt();
	             
	             user.setPassword(encodePassphrase(user.getPassword(),salt));
	             user.setSalt(salt); 
	         } else{
	             if (StringUtils.isNotBlank(user.getPassword())) {
	                 String salt=getSalt();
	                 
	                 user.setPassword(encodePassphrase(user.getPassword(),salt));
	                 user.setSalt(salt); 
	             }
	         }
	        
	        user.setRoleId(user.getRoleId());
	        user.setIsDelete(0);
	        user.setIsFreeze("0");
	        result = saveUserService.execute(user);
	        userRole.setUserId(user.getId());
	        userRole.setRoleId(user.getRoleId());
	        result = saveRoleUserService.execute(userRole);
	         if (result.getStatus().equals("0")){//插入成功
	             super.sendSuccessMessage(response,"","保存成功");
	             return;
	         } else {
	            super.sendFailureMessage(response,"","保存失败");
	            return;
	         }
	    }
	    
	    
	    /**
	     * 获取当前登录用户
	     */
	    @Autowired
	    protected GetUserService getUserService;

	    /**
	     * 登录
	     * @param username 邮箱登录账号
	     * @param password 密码
	     * @param verifyCode 验证码
	     * @param request
	     * @param response
	     * @throws Exception
	     */
	    @RequestMapping("/tologin.html")
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
	    
	    @RequestMapping("/logout.html")
	    public String logout(HttpServletRequest request,HttpServletResponse response) {
	        // 获取当前的Subject
	        Subject currentUser = SecurityUtils.getSubject();
	        currentUser.logout();
	        SessionUtils.removeUser(request);
	        return "redirect:/";
	    }
		
		@RequestMapping(value="/serviceAgencyRegister.html")
		public ModelAndView serviceAgencyRegister(HttpServletRequest request,Model model) throws Exception {
			ModelAndView mv = new ModelAndView("user/serviceAgencyRegister");
			return mv;
		}
		
		@RequestMapping(value="/findpassword.html")
		public ModelAndView findPassword(HttpServletRequest request,Model model) throws Exception {
			ModelAndView mv = new ModelAndView("user/findpassword");
			return mv;
		}
		
		@RequestMapping(value="/service.html")
		public ModelAndView service(HttpServletRequest request,Model model) throws Exception {
			ModelAndView mv = new ModelAndView("user/service");
			return mv;
		}
		
		@RequestMapping(value="/onlineMessage.html")
		public ModelAndView onlineMessage(HttpServletRequest request,Model model) throws Exception {
			ModelAndView mv = new ModelAndView("user/onlineMessage");
			return mv;
		}
}