package com.tianqe.v2raycontroller.service.checkInstallService;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 判断系统为windows系统还是Linux系统
 * 判断系统内是否安装有v2ray以及nginx
 * @author hertling
 * @version 1.0
 * @since 2023年3月3日
 */
@Service
public class checkingSoftwareInstallationForLinux {

    public static void checkNginxInstallation() {
        Process process = null;
        // 默认为Linux系统
        boolean judgment = true;
        try {
            // 判断为windows还是Linux
            String osName = System.getProperty("os.name").toLowerCase();
            if (osName.contains("win")) {
                // 如果是windows系统则提示系统不兼容，并停止运行
                System.out.println("系统暂时不兼容windows系统，请改为linux系统运行");
                System.exit(0);


                // 当前系统为 Windows，输入cmd命令，在path指定的路径总查找相关可执行文件，如果path中未指定则会提示未找到 技术原因暂不开启windows配置
//                ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "where nginx");
//                process = pb.start();
//                // 改为false,标识为windows，下载windows版nginx
//                judgment = false;
            } else {
                // 当前系统为 Linux 或其他系统
                process = Runtime.getRuntime().exec("which nginx");
            }
            process = Runtime.getRuntime().exec("which nginx");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean v2rayInstalled = false;
            while ((line = reader.readLine()) != null) {
                // 文件存在表示已经安装好
                if (!line.isEmpty()) {
                    v2rayInstalled = true;
                    break;
                }
            }
            if (v2rayInstalled) {
                System.out.println("软件已经安装");
            }else {
                System.out.println("软件未安装");
            }
        } catch (IOException e) {
            // handle exception
            e.printStackTrace();
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
