package com.tim.common;

import com.tim.common.pojo.InitTestData;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Created by friendsyh on 2020/9/16.
 */
public class IOTest extends InitTestData {

    private static final Logger logger = LoggerFactory.getLogger(IOTest.class);

    @Before
    public void init() {
        initObject();
    }

    @Test
    public void writeMap2File(){
        String configFilePath = "D:/tmp/conf/predit.conf";
        try (FileWriter fileWritter = new FileWriter(configFilePath)) {
            File file =new File(configFilePath);
            if(!file.exists()){
                file.createNewFile();
            }
            for (String key : testMap.keySet()) {
                fileWritter.write(key + "=" + testMap.get(key) + "\n");
            }
        }catch(IOException e){
            logger.error("#### PredicateConfig initDataFromDB and Write2File exception.", e);
        }
    }
}
