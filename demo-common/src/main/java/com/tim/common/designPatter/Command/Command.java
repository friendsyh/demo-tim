package com.tim.common.designPatter.Command;

/**
 * 命令对象
 * Created by Administrator on 2017/10/6.
 */
public interface Command {
    /**
     * 执行命令
     */
    void excute();

    /**
     * 撤销命令
     */
    void undo();
}
