package com.pawan.dreambuy.config.configs;

import org.slf4j.LoggerFactory;

public class Config {
  private   LoggerFactory loggerFactory;

    public void printInfo(LoggerFactory loggerFactory, String message){
        this.loggerFactory = loggerFactory;
        System.out.println(message);
    }
}
