package cn.itcast.gjp.service;

import com.android.ddmlib.*;

import java.io.IOException;

/**
 * @author apple
 * @date 2019/12/2 下午5:48
 */
public class androidUtil {

    public static void getCpuInfo(IDevice iDevice) throws TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException, IOException {
        executeShellCommand(iDevice,"cat /proc/cpuinfo");
    }

    public static void executeShellCommand(IDevice iDevice,String cmd) throws TimeoutException, AdbCommandRejectedException, ShellCommandUnresponsiveException, IOException {
        CollectingOutputReceiver collectingOutputReceiver = new CollectingOutputReceiver();
        iDevice.executeShellCommand(cmd,collectingOutputReceiver);
    }

    public static void main(String[] args) throws Exception{
        Process exec = Runtime.getRuntime().exec("cd / ; ll");
        System.out.println(exec);
    }
}
