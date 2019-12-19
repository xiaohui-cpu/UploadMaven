package com.termend.controller.shop;



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.InputMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.termend.common.PIPIUtils;
import com.termend.common.Result;
import com.termend.common.ShopInfo;
import com.termend.common.property.PropertyUtils;



@Controller
@RequestMapping("/shop")
public class ShopInfoController {
    
	/**
	 * 得到商家信息 信息是一个properties文件
	 * 
	 * @return
	 */
	@RequestMapping("/getInfo")
	@ResponseBody
	public Result getInfo(){
		String path = "D:/workPlace/termEndWorkPlace/termend-manager-web/src/main/resources/resource/info.properties";
        
		String name = PropertyUtils.getPro(path, "SHOP_NAME");
		String address = PropertyUtils.getPro(path, "SHOP_ADDRESS");
		String time = PropertyUtils.getPro(path, "SHOP_TIME");
		String phone = PropertyUtils.getPro(path, "SHOP_PHONE");
		ShopInfo info = new ShopInfo(name, address, time, phone);
		return Result.ok(info);
	}

	/**
	 * 更新商家信息
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping("/updateInfo")
	@ResponseBody
	public Result updateInfo(ShopInfo info) {
		Properties p = new Properties();
		String path = "D:/workPlace/termEndWorkPlace/termend-manager-web/src/main/resources/resource/info.properties";
		
		p.setProperty("SHOP_NAME",info.getName());
		p.setProperty("SHOP_ADDRESS",info.getAddress());
		p.setProperty("SHOP_TIME",info.getTime());
		p.setProperty("SHOP_PHONE",info.getPhone());
		FileOutputStream oFile = null;
        try {
            oFile = new FileOutputStream(path);
            //将Properties中的属性列表（键和元素对）写入输出流
            p.store(oFile,"");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		return Result.ok();
	}

}
