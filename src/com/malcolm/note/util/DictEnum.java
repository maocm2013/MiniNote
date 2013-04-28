/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malcolm.note.util;

import com.alibaba.fastjson.JSON;
import java.util.Map;

/**
 *
 * @author user
 */
public class DictEnum {
    /**
     * 任务优先级
     */
    public static class NotePriority{
        /**
         * H-高
         */
        public static final String HIGH = "01";
        
        /**
         * M-中
         */
        public static final String MIDDLE = "02";
        
        /**
         * L-低
         */
        public static final String LOW = "03";
        
        /**
         * U-加急
         */
        public static final String URGENT = "00";
        
        public static final Map dataMap = JSON.parseObject("{\"01\":\"高\",\"02\":\"中\",\"03\":\"低\",\"00\":\"加急\"}");
    }
    
    public static class NoteState{
        /**
         * 01-未开始
         */
        public static final String INACTIVE = "01";
        /**
         * 02-处理中
         */
        public static final String PROCESSING = "02";
        /**
         * 03-已完成
         */
        public static final String FINISHED = "03";
        /**
         * 04-挂起
         */
        public static final String HUNGUP = "04";
        /**
         * 05-遗弃
         */
        public static final String DISCARD = "05";
        /**
         * 06-延迟
         */
        public static final String DELAY = "06";
        
        public static final Map dataMap = JSON.parseObject("{\"01\":\"未开始\",\"02\":\"处理中\",\"03\":\"已完成\",\"04\":\"挂起\",\"05\":\"遗弃\",\"06\":\"延迟\"}");
    }
}
