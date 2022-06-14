package com.miu.MainApplication.Logging;

import org.springframework.stereotype.Component;


public class Logger implements ILogger{

    public void log(String logstring) {
        java.util.logging.Logger.getLogger("Blog_Logger").info(logstring);
    }

}