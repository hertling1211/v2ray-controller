package com.tianqe.v2raycontroller.service.modifyConfigService;

import com.alibaba.fastjson2.JSONObject;
import com.tianqe.v2raycontroller.msg.resultMsg.resultMsg;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 修改配置类
 * @author 凌心
 * @version 1.0
 * @since 2023年3月1日
 */
@Service
public class modifyTheConfig {
    // v2ray的配置文件地址
    private static final String v2rayConfigUrl = "C:\\Users\\ASUS\\Desktop\\CoreGui\\v2ray-windows-64\\config.json";

    /**
     * 获取v2ray的配置文件
     * @return
     */
    public resultMsg getProxyConfig(){
        resultMsg result = new resultMsg();
        try{
            // 获取配置文件
            File v2rayConfigFile = new File(v2rayConfigUrl);
            // 解析file文件
            InputStream v2rayStream = new FileInputStream(v2rayConfigFile);
            byte[] bytes = new byte[(int) v2rayConfigFile.length()];
            v2rayStream.read(bytes);
            String configString = new String(bytes, "UTF-8");
            v2rayStream.close();

            // 解析配置文件为 JSON 对象
            JSONObject config = JSONObject.parseObject(configString);
            result = resultMsg.ok("success", config);
        }catch(Exception e){
            e.printStackTrace();
            result = resultMsg.error("服务器出现异常");
        }
        return result;
    }
}
