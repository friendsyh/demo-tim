package com.tim.common.designPatter.Command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author Administrator
 * @create 2017-10-08 9:46
 */
@Data
public class RemoteControl {
    private Command command;

    public void lightOn() {
        command.excute();
    }
}