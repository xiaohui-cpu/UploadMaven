package com.termend.controller.image;



import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.termend.common.PIPIUtils;
import com.termend.common.json.JsonUtils;
import com.termend.controller.exception.ImageException;
import com.termend.controller.utils.FastDFSClient;



/**
 * 图片上传
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/pic")
public class PictureController {

	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String fileUpload(MultipartFile uploadFile) {
		Map result = new HashMap<>();
		try {
			//去文件名扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			//创建一个FastDFS的客户端
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/fdfs_client.conf");
			//执行上传处理
			String path = fastDFSClient.uploadFile(uploadFile.getBytes(),extName);
			//拼接返回的url和ip地址，拼装完整的url
			String url = IMAGE_SERVER_URL+path;
			//返回map
			result.put("error",0);
			result.put("url",url);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ImageException("图片上传失败");
		}
		return JsonUtils.objectToJson(result);
	}
}