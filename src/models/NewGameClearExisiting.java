package models;

import Start.Main;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * Created by augustus on 3/7/16.
 * This class creates a new JVM and
 * restarts the application again.
 * Found on:
 * http://stackoverflow.com/questions/4159802/how-can-i-restart-a-java-application
 */
public class NewGameClearExisiting {
    public static void startNewGame(){
        StringBuilder cmd = new StringBuilder();
        cmd.append(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java ");
        for (String jvmArg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            cmd.append(jvmArg + " ");
        }
        cmd.append("-cp ").append(ManagementFactory.getRuntimeMXBean().getClassPath()).append(" ");
        cmd.append(Main.class.getName()).append(" ");
        try {
            Runtime.getRuntime().exec(cmd.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
