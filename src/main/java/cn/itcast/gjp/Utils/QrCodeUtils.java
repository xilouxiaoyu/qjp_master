package cn.itcast.gjp.Utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QrCodeUtils {
    private static final String QR_CODE_IMAGE_PATH = "/Users/ximuxiao/Desktop/"+System.currentTimeMillis()+"MyQRCode.png";

    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException, WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }
     public static void FileToString(String filePath){
         File file = new File(filePath);
         try {
             FileOutputStream fos = new FileOutputStream(file);
             
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }

     }
    public static void main(String[] args) {
        try {
            File file = new File("/Users/ximuxiao/Desktop/ximuxiao.txt");
            generateQRCodeImage("This is my first QR Code", 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

    }


}
