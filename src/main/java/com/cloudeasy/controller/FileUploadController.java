package com.cloudeasy.controller;


import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.cloudeasy.exception.LlSystemException;
import com.cloudeasy.result.Mess;
import com.cloudeasy.result.Result;
import com.cloudeasy.result.ResultImpl;
import com.cloudeasy.utils.Constants;
import com.cloudeasy.utils.StackTraceUtil;


/**
 * 
* @Title: FileUploadController 
* @Description: 文件上传 
* @author SEA   
* @date Jun 8, 2013 8:21:53 AM 
* @version V1.0
 */
@Controller
@RequestMapping("/file")
public class FileUploadController extends BaseController {

    /** 
    * @Fields serialVersionUID : 序列ID 
    */ 
    
    private static final long serialVersionUID = -7196374659492891808L;

    private final static String XLS_ARRAYS1 = "xls,xlsx,doc,docs,txt,ppt";
    
    private final static String PIC_ARRAYS1 = "jpg,jpeg,gif,png";
    
    private final static String UPLOAD_XLS = "xls"; 
    
    private final static String UPLOAD_PIC = "pic";
    
    /**
     * 文件上传
     * @param path 
     * @param file
     * @param request
     * @param response
     * @throws Exception 
     * @throws IOException
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void handleFormUpload(@RequestParam("path") String path, 
                    @RequestParam("file") Part file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Result result = new ResultImpl();
        Gson gson = new Gson();
        try {
            response.setContentType("text/html;charset=utf-8");
            do {
                log.info("upload start");
                // 判断当前文件是否为空
                if (file.getSize() == 0) {
                    Mess mess =  new Mess();
                    mess.setMessage(messageSource.getMessage(Constants.UPLOAD_MESSAGE_001, null, null));
                    result.setMessList(mess);
                    result.setStatus("1");
                    break;
                }
                
                // 上传路径验证
                if (StringUtils.isBlank(path)) {
                    Mess mess =  new Mess();
                    mess.setMessage(messageSource.getMessage(Constants.UPLOAD_FILE_PATH_EMPTY, null, null));
                    result.setMessList(mess);
                    result.setStatus("1");
                    break;
                }
                // 对扩展名验证
                String fileName = this.getFilenName(file, path);
                if (StringUtils.isBlank(fileName)) {
                    Mess mess =  new Mess();
                    mess.setMessage(messageSource.getMessage(Constants.UPLOAD_FILE_ILLEGAL, null, null));
                    result.setMessList(mess);
                    result.setStatus("1");
                    break;
                }
                if(!this.filterExtendsName(path, fileName)) {
                    Mess mess =  new Mess();
                    mess.setMessage(messageSource.getMessage(Constants.UPLOAD_FILE_ILLEGAL, null, null));
                    result.setMessList(mess);
                    result.setStatus("1");
                    break;
                }
                
                String filePath = request.getSession().getServletContext().getRealPath("/upload");
                
                filePath = filePath + "/"  + path+ "/" + this.getFilenName(file, path);
                file.write(filePath);
                Mess mess = new Mess();
                mess.setMessage(fileName.substring(fileName.indexOf("+") + 1));
                result.setMessList(mess);
                log.info("upload end");
               
            }while (false);
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            log.error(StackTraceUtil.getStackTrace(e));
            Mess mess =  new Mess();
            mess.setMessage(messageSource.getMessage(Constants.UPLOAD_FILE_UPLOAD_EX, null, null));
            result.setMessList(mess);
            result.setStatus("1");
        }
        
        log.info("convert to json...");
        log.info(gson.toJson(result));
        try {
            response.getWriter().print(gson.toJson(result));
        } catch (IOException e) {
           log.error(StackTraceUtil.getStackTrace(e));
           throw new LlSystemException(Constants.SYSTEM_EX);
        }
        
    }
    
    /**
     * 获取文件名。
    * @param file 上传文件
    * @return 文件名
     */
    private String getFilenName(Part file, String path) {
        log.info("get file name start...");
        String content = file.getHeader("content-disposition");
        String[] array = content.split(";");
        String fileName = array[2];
        fileName = fileName.substring(StringUtils.lastIndexOf(fileName, "\\") + 1, fileName.length() - 1);
        if (StringUtils.indexOf(fileName, "=") != -1) {
            fileName = fileName.substring(fileName.indexOf("=") + 2);
        }
        
       
        if (StringUtils.isBlank(fileName)) {
            log.info("current file name :" + fileName);
            log.info("get file name end!");
            return null;
        }
        if (StringUtils.equalsIgnoreCase(UPLOAD_PIC, path)) {
            fileName = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss") + fileName.substring(fileName.lastIndexOf("."));
        } else {
            fileName = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss") + "_" + fileName;
        }
        
        log.info("current file name :" + fileName);
        log.info("get file name end!");
        return fileName;
    }
    
    /**
     * 扩展名过滤。
     * @param path 上传路径
     * @param fileName 文件名
     * @return
     */
    private boolean filterExtendsName(String path, String fileName) {
        String extendsName = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (StringUtils.equalsIgnoreCase(UPLOAD_XLS, path)) {
            if (StringUtils.containsIgnoreCase(XLS_ARRAYS1, extendsName)) {
                return true;
            }
        } else if (StringUtils.equalsIgnoreCase(UPLOAD_PIC, path)) {
            if (StringUtils.containsIgnoreCase(PIC_ARRAYS1, extendsName)) {
                return true;
            }
        }
        return false;
    }
    
    @RequestMapping(value="/uploadPage")  
    public String toUpload() {
        return "/user/upload";
    }
}
