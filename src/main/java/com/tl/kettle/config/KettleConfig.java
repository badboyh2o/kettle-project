package com.tl.kettle.config;

import org.pentaho.di.core.Const;
import org.pentaho.di.core.plugins.PluginFolder;
import org.pentaho.di.core.plugins.StepPluginType;

/**
 * @program: collection-parent
 * @description: kettle配置加载
 * @author: dong.tl
 * @create: 2019-12-20 10:53
 **/
public class KettleConfig {
    private static class KettleConfigInstance {
        private static final KettleConfig instance = new KettleConfig();
    }

    private KettleConfig() {
    }

    public static KettleConfig getInstance() {
        return KettleConfigInstance.instance;
    }

    /**
     * 添加插件地址
     * @param pluginFolder
     */
    public KettleConfig addPluginFolder(String pluginFolder){
        //加载kettle插件包
        StepPluginType.getInstance().getPluginFolders().add(new PluginFolder(pluginFolder, false, true));
        return this;
    }

    /**
     * 设置JNDI文件地址
     * @param simpleJndi
     */
    public KettleConfig setJndi(String simpleJndi){
        Const.JNDI_DIRECTORY =simpleJndi;
        return this;
    }
}
