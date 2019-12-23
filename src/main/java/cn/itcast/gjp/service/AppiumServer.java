package cn.itcast.gjp.service;

import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

import java.io.IOException;

/**
 * @author apple
 * @date 2019/12/23 下午2:58
 */
@Slf4j
public class AppiumServer {

    public AppiumServer() {
        KillTask();

    }

    public void KillTask() {
        String Command = "ps -ef | grep appuim | awk '{print \"kill -9 \" $2}'|sh";

        runCommand(Command);
        log.info("appuim 服务关闭");
    }

    public void runServer(int port, String udid) {

        int bpport = port + 1;
        int chromeport = port + 4792;
        //多设备server端需要手动指定每台设备的udid,安卓无线连接下就是设备的ip:port..
        //String Command = "appium.cmd -p " + port + " -bp " + bpport + " --session-override --chromedriver-port " + chromeport + " -U "+ udid + " >c://" + port + ".txt";
        String Command = " appium -a"+port+"-p"+bpport+"--session-override &";
        // mac 启动命令 appium appium -a 127.0.0.1 -p  4723 --session-override &

        runCommand(Command);
        log.info("appuim 启动成功");
    }

    private void runCommand(String command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AppiumServer AS = new AppiumServer();
        AS.runServer(4725, "192.168.1.17:3333");

    }
}

