// Copyright (C) 2015 anduo
// All rights reserved
package com.anduo.nz.zk;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
 * time   : 01:07
 */
public class ClientDict {
    public static    ClientDict     self           = null;
    protected static Logger         logger         = LogManager.getLogger(ClientDict.class);
    protected        ZKConnect      ZKConnect      = null;
    public           ClientListener clientListener = null;

    static {
        self = new ClientDict();
    }

    public ClientDict() {
        init();
    }

    public boolean init() {
        logger.info("ClientDict init zookeeper...");
        this.ZKConnect = new ZKConnect();
        if ((this.ZKConnect == null) || (!this.ZKConnect.start())) {
            return false;
        }
        this.clientListener = new ClientListener(CommonConstants.ZK_ROOT_PATH + "/client", this.ZKConnect);
        this.ZKConnect.addClientListener(this.clientListener);
        this.clientListener.reload();
        return true;
    }

    public CuratorFramework getZK() {
        return this.ZKConnect.instance;
    }

    public BasicDBObject hashClient(String jobClass, String hashKey) {
        return this.clientListener.clientNodes.hashClient(jobClass, hashKey);
    }

    /**
     * hashClient4S
     * @param jobClass
     * @param hashKey
     * @return
     */
    public Map hashClient4S(String jobClass, String hashKey) {
        return this.clientListener.clientNodes.hashClient4S(jobClass, hashKey);
    }

    public BasicDBObject hashClientByFixedClientIps(String jobClass,String[] fixedClientIps) {
        return this.clientListener.clientNodes.hashClientByFixedClientIps(jobClass, fixedClientIps);
    }

    /**
     * hashClientByFixedClientIps升级版本(4S==For Super)
     * @param jobClass
     * @param fixedClientIps
     * @return
     */
    public Map hashClient4SByFixedClientIps(String jobClass,String[] fixedClientIps) {
        return this.clientListener.clientNodes.hashClient4SByFixedClientIps(jobClass, fixedClientIps);
    }

    public BasicDBObject hashClientBySystemCapacity(String jobClass) {
        return this.clientListener.clientNodes.hashClientBySystemCapacity(jobClass);
    }

    /**
     * hashClientBySystemCapacity升级版本(4S==For Super)
     * @param jobClass
     * @return
     */
    public Map hashClient4SBySystemCapacity(String jobClass) {
        return this.clientListener.clientNodes.hashClient4SBySystemCapacity(jobClass);
    }

}
