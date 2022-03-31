package com.tl.kettle.implement;

import com.tl.kettle.report.KettleResult;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

import java.util.Iterator;
import java.util.Map;

/**
 * @program: collection-parent
 * @description: kettle执行类
 * @author: dong.tl
 * @create: 2019-12-20 15:03
 **/
public class KettleImplement {

    /**
     * 执行ktr文件
     *
     * @param fname  ktr文件地址
     * @param params 传入参数
     * @return
     */
    public static KettleResult runKtr(String fname, Map<String, String> params) throws KettleException {
        KettleResult kettleResult = new KettleResult();
        KettleEnvironment.init();
        TransMeta tm = new TransMeta(fname);
        Trans trans = new Trans(tm);
        if (params != null) {
            Iterator<Map.Entry<String, String>> entries = params.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = entries.next();
                trans.setParameterValue(entry.getKey(), entry.getValue());
            }
        }
        trans.execute(null);
        trans.waitUntilFinished();

        kettleResult.setTrans(trans);
        return kettleResult;
    }


    /**
     * 执行kjb文件
     *
     * @param fname
     * @param params
     * @return
     */
    public static KettleResult runKjb(String fname, Map<String, String> params) throws KettleException {
        KettleResult kettleResult = new KettleResult();
        KettleEnvironment.init();
        JobMeta jm = new JobMeta(fname, null);
        Job job = new Job(null, jm);
        if (params != null) {
            Iterator<Map.Entry<String, String>> entries = params.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = entries.next();
                job.setVariable(entry.getKey(), entry.getValue());
            }
        }
        job.start();
        job.waitUntilFinished();
        kettleResult.setJob(job);
        return kettleResult;
    }
}
