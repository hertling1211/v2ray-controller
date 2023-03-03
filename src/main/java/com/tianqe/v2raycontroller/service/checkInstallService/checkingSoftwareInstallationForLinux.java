package com.tianqe.v2raycontroller.service.checkInstallService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 检查软件是否已将安装完毕
 * @author hertling
 * @version 1.0
 * @since 2023年3月3日
 */
public class checkingSoftwareInstallationForLinux {
    public static boolean checkNginxInstallation() {
        try {
            Process process = Runtime.getRuntime().exec("which nginx");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            // handle exception
            return false;
        }
    }

    public static boolean checkV2rayInstallation() {
        try {
            Process process = Runtime.getRuntime().exec("which v2ray");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            // handle exception
            return false;
        }
    }
}
