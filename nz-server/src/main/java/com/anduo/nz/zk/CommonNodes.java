// Copyright (C) 2015 anduo
// All rights reserved
package com.anduo.nz.zk;

import java.util.concurrent.atomic.AtomicLong;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑, 永无BUG!
 * 　　　　┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 * Summary: TODO 描述信息
 * Author : anduo@qq.com
 * Version: 1.0
 * Date   : 15/7/2
 * time   : 01:09
 */
public class CommonNodes {
    public static String allocateNo() {
        AtomicLong count = new AtomicLong(0L);
        if (count.get() == 9223372036854775807L) {
            count.set(0L);
        }
        return String.valueOf(count.addAndGet(1L));
    }

    public static int findIndexById(String id, BasicDBList items) {
        int result = -1;
        if (null != items) {
            for (int i = 0; i < items.size(); i++) {
                BasicDBObject oItem = (BasicDBObject) items.get(i);
                if (oItem.getString("id").equalsIgnoreCase(id)) {
                    result = i;
                }
            }
        }
        return result;
    }

    public static int findIndexByIp(String ip, BasicDBList items) {
        int result = -1;
        for (int i = 0; i < items.size(); i++) {
            BasicDBObject oItem = (BasicDBObject) items.get(i);
            if (oItem.getString("ip").equalsIgnoreCase(ip)) {
                result = i;
            }
        }
        return result;
    }
}
