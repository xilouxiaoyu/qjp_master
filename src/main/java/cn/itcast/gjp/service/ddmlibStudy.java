package cn.itcast.gjp.service;

import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.IDevice;

/**
 * @author apple
 * @date 2019/11/27 下午3:23
 */
public class ddmlibStudy {
    public static void main(String[] args) {
        IDevice device;
        AndroidDebugBridge.init(false);
        AndroidDebugBridge bridge = AndroidDebugBridge.createBridge(
                "/Users/xuyisheng/Library/Android/sdk/platform-tools/adb", false);
        waitForDevice(bridge);
        IDevice devices[] = bridge.getDevices();
        device = devices[0];
    }

    private static void waitForDevice(AndroidDebugBridge bridge) {
        int count = 0;
        while (!bridge.hasInitialDeviceList()) {
            try {
                Thread.sleep(100);
                count++;
            } catch (InterruptedException ignored) {
            }
            if (count > 300) {
                System.err.print("Time out");
                break;
            }
        }
    }
}
