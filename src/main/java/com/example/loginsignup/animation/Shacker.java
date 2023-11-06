package com.example.loginsignup.animation;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;

public class Shacker {
    private TranslateTransition translateTransition;
    
    public Shacker(Node node){
        translateTransition = new TranslateTransition(javafx.util.Duration.millis(100), node );
        translateTransition.setFromX(0f);
        translateTransition.setByX(20f);
        translateTransition.setCycleCount(4);
        translateTransition.setAutoReverse(true);
       // return translateTransition;
    }
    public void shake(){
            translateTransition.playFromStart();
    }

}
