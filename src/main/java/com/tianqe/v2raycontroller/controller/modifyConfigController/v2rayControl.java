package com.tianqe.v2raycontroller.controller.modifyConfigController;

import com.tianqe.v2raycontroller.service.modifyConfigService.modifyTheConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/proxy")
public class v2rayControl {
    @Autowired
    modifyTheConfig modifyConfig;

    /**
     * 上传配置，修改配置内容
     */
    @Value("${server.port}")
    private String appPort;
    @GetMapping(value = "/modifyConfig")
    public ModelAndView postConfig(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminRoot");
        modelAndView.addObject("message", modifyConfig.getProxyConfig());
        modelAndView.addObject("appPort",appPort);
        return modelAndView;
    }

}
