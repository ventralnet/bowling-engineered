package com.kirkley.bowling.ui;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.kirkley.bowling.components.GameFactory;

public class ConsoleUI {
    public static void main(String[] args) {
        configureLogging();
        Logger log = Logger.getLogger(ConsoleUI.class);
        log.debug("hello");
        System.out.println(GameFactory.getGame(args[0]).getScore());
    }
    
    private static void configureLogging() {

        DOMConfigurator.configure(ConsoleUI.class.getClassLoader().getResource("log4j.xml"));
        
    }
}
