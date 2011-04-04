package com.kirkley.bowling.ui;

import org.apache.log4j.xml.DOMConfigurator;

import com.kirkley.bowling.components.GameFactory;

/**
 * Reads in a standard game of 10 pin bowling and outputs the score to 
 * standard out.
 * @author mkirkley
 */
public class ConsoleUI {
    public static void main(String[] args) {
        configureLogging();
        //As described in the requirements, no validation needs to be performed.
        System.out.println(GameFactory.getGame(args[0]).getScore());
    }
    
    private static void configureLogging() {

        DOMConfigurator.configure(ConsoleUI.class.getClassLoader().getResource("log4j.xml"));
        
    }
}
