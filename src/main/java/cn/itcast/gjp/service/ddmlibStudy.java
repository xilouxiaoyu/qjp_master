package cn.itcast.gjp.service;

import com.android.ddmlib.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author apple
 * @date 2019/11/27 下午3:23
 */
public class ddmlibStudy {
    public static void main(String[] args) {
        IDevice device;
        AndroidDebugBridge.init(false);
        AndroidDebugBridge bridge = AndroidDebugBridge.createBridge(
                "/Users/apple/IdeaProjects/Android-sdk-macosx/platform-tools/adb", false);
        waitForDevice(bridge);
        IDevice devices[] = bridge.getDevices();
        device = devices[0];
        System.out.println(device);
        takeScreenshot(device);
        System.out.println(device.isOnline());
        com.android.sdklib.AndroidVersion version = device.getVersion();
        System.out.println(version.toString());

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

    private static void takeScreenshot(IDevice device) {
        try {
            RawImage rawScreen = device.getScreenshot();
            if (rawScreen != null) {
                int width = rawScreen.width;
                int height = rawScreen.height;
                BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                int index = 0;
                int indexInc = rawScreen.bpp >> 3;
                for (int y = 0; y < rawScreen.height; y++) {
                    for (int x = 0; x < rawScreen.width; x++, index += indexInc) {
                        int value = rawScreen.getARGB(index);
                        image.setRGB(x, y, value);
                    }
                }
                ImageIO.write(image, "PNG", new File("/Users/apple/IdeaProjects/test1.png"));
            }
        } catch (TimeoutException | AdbCommandRejectedException | IOException e) {
            e.printStackTrace();
        }
    }
}
