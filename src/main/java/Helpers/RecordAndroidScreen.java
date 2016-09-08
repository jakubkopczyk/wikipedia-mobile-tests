package Helpers;

import io.appium.java_client.AppiumDriver;

import java.io.IOException;

public class RecordAndroidScreen {
    /**
     * Recording screen helper for Android version > 4.4
     */
    private AppiumDriver driver;
    public static Process result;
    public static String command;
    public static String fileName;
    public RecordAndroidScreen(AppiumDriver driver){this.driver = driver;}

    public static void startRecording(String fileName) throws IOException {
        RecordAndroidScreen.fileName = fileName;
        command = "adb shell screenrecord --bit-rate 6000000 /sdcard/"+fileName+".mp4";
        result = Runtime.getRuntime().exec(command);
        System.out.println("Start recording Android screen.");

    }
    public static void stopRecording() throws IOException {
        result.destroy();
        command = "adb pull /sdcard/"+fileName+".mp4 /Videos";
        result = Runtime.getRuntime().exec(command);
        command = "adb shell rm /sdcard/"+fileName+".mp4";
        result = Runtime.getRuntime().exec(command);
        System.out.println("Finished recording Android screen.");
    }
}
