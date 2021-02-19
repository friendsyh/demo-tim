package com.tim.common.designPatter.Command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author Administrator
 * @create 2017-10-06 12:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LightOnCommand implements Command {

    private Light light;

    @Override
    public void excute() {
        light.on();
    }

    @Override
    public void undo() {

    }
}