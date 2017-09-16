package com.jodel.appium.framework;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class appiumServerController extends appiumDriverController {

    public static AppiumDriverLocalService service;

    public static void startAppiumServer(){
        stopAlreadyRunningAppium();


        // Get Appium executable path
        File appiumExecutable = getAppiumExecutable();

        // Init AppiumServiceBuilder
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                //.withLogFile(logFile)
                //.usingAnyFreePort()
                .usingPort(Integer.parseInt("4723"))
                .withAppiumJS(appiumExecutable);

        // Start Appium server
        service = AppiumDriverLocalService.buildService(serviceBuilder);
        service.start();

        // Verify Appium server started
        if (service == null || !service.isRunning()) {
            String error = "Appium server not running!";
        } else {
            //TBD
        }
    }


    public static void stopAppiumServer(){
        if (service != null) {
            try {
                service.stop();
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            //TBD
        }
    }

    private static File getAppiumExecutable(){
        // Find Appium path.
        String appiumPath;
        appiumPath = runProcess(true, 30, "which appium").trim();

        // Check if exists
        File appiumExecutable = new File(appiumPath);
        if (!appiumExecutable.exists()) {
            String error = "Appium does not exist at: " + appiumPath;
            System.out.println(error);

        } else {
            System.out.println("Appium Executable: " + appiumPath);
        }

        // Return Appium executable file.
        return appiumExecutable;
    }


    public static final String[] OS_LINUX_RUNTIME = {"/bin/bash", "-l", "-c"};

    public static String[] concat(String[] first, String[] second) {
        String[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static String runProcess(boolean waitFor, int timeOut, String... command) {
        String[] allCommand = null;

        String finalCommand = "";
        for (String s : command) {
            finalCommand = finalCommand + s;
        }

        try {
            allCommand = concat(OS_LINUX_RUNTIME, command);
            ProcessBuilder pb = new ProcessBuilder(allCommand);
            Process p = pb.start();

            if (waitFor) {
                StringBuffer output = new StringBuffer();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(p.getInputStream()));

                String line = "";
                while ((line = reader.readLine()) != null) {
                    output.append(line + "\n");
                }

                p.waitFor(timeOut, TimeUnit.SECONDS);


                return output.toString();
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void stopAlreadyRunningAppium(){
        try{
            String output = null;
            String PID  = null;
            Process process = null;
            BufferedReader stdInput = null;

            //Stop appium
            process = Runtime.getRuntime().exec("pgrep -f  appium");

            stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while ((output = stdInput.readLine()) != null) {
                System.out.println("Appium Server Found   " + output);
                PID = output;
                Runtime.getRuntime().exec("kill -9 " + PID );
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
