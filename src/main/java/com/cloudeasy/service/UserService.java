/**  
* Copyright(c)2013 Wuxi Lanlin Co.,Ltd. 
* All right reserved. 
*/ 

package com.cloudeasy.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudeasy.dao.UserMapper;
import com.cloudeasy.dto.user.ListUserReqDTO;
import com.cloudeasy.dto.user.ListUserResDTO;
import com.cloudeasy.model.User;
import com.cloudeasy.result.Result;

/** 
 * @Title: UserService 
 * @Description: TODO
 * @author ll
 * @date 2013-11-19 下午4:23:49 
 * @version V1.0   
 */
@Service("userService")
public class UserService extends BaseService<Result, ListUserReqDTO> {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Result execute(ListUserReqDTO arg) throws Exception {
		
		Integer rowCount = userMapper.queryByCount(arg);
		arg.getPager().setRowCount(rowCount);
		
		List<User> list = userMapper.queryByList(arg);
		
		ListUserResDTO resDTO = new ListUserResDTO();
		resDTO.setPager(arg.getPager());
		resDTO.setList(list);
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}
	
	public Result executeExcel(ListUserReqDTO arg) throws Exception {
		
		List<User> list = userMapper.queryAllUser();
		
		ListUserResDTO resDTO = new ListUserResDTO();
		resDTO.setPager(null);
		resDTO.setList(list);
		Result result = getResult();
		result.setBaseDTO(resDTO);
		return result;
	}
	
public static HSSFWorkbook listExcel(List<User> list,HttpServletResponse response) throws Exception{
		
		//创建一个webbook 对应一个excle文件
		HSSFWorkbook wb = new HSSFWorkbook();
		//在webbook中添加一个sheet，对应excle中的一个sheet
		HSSFSheet sheet = wb.createSheet();
		//设置表格宽度
		sheet.setDefaultColumnWidth(30);

		//在sheet中添加表头
		HSSFRow row = sheet.createRow(0);
		//创建单元格并设置值表头设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		//创建一个居中格式
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		HSSFCell cell = null;
		cell = row.createCell(0);
		cell.setCellValue("用户名");
		cell.setCellStyle(style);
		
		cell = row.createCell(1);
		cell.setCellValue("手机");
		cell.setCellStyle(style);
		
		cell = row.createCell(2);
		cell.setCellValue("邮箱");
		cell.setCellStyle(style);
		
		cell = row.createCell(3);
		cell.setCellValue("省份");
		cell.setCellStyle(style);
		
		cell = row.createCell(4);
		cell.setCellValue("详细地址");
		cell.setCellStyle(style);;
		
		cell = row.createCell(5);
		cell.setCellValue("活动提交时间");
		cell.setCellStyle(style);
		
		
		for (int i = 0; i < list.size(); i++)
		{
			row = sheet.createRow((int) i + 1);
			User user  =  (User) list.get(i);

			row.createCell((short) 0).setCellValue(user.getUsername());
			row.createCell((short) 1).setCellValue(user.getMobilePhone());
			row.createCell((short) 2).setCellValue(user.getEmail());
			row.createCell((short) 3).setCellValue(user.getProvince());
			row.createCell((short) 4).setCellValue(user.getAddress());
			row.createCell((short) 5).setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getCreateTime()));
		}
		return wb;
	}
	
}
