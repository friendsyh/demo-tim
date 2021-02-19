package com.tim.common.designPatter.Command;

/**
 * @description:
 * @author Administrator
 * @create 2017-10-08 9:49
 */
public class TestMain {

    public static void main(String[] args) {
        Command lightOnCommand = new LightOnCommand(new Light());

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(lightOnCommand);
        remoteControl.lightOn();
    }

}