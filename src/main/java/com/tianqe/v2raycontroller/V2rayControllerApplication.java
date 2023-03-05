package com.tianqe.v2raycontroller;

import com.tianqe.v2raycontroller.service.checkInstallService.checkingSoftwareInstallationForLinux;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class V2rayControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run(V2rayControllerApplication.class, args);
        // 启动检查是否安装有v2ray以及nginx
        checkingSoftwareInstallationForLinux.checkNginxInstallation();

    }

}
