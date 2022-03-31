package com.tl.kettle.report;


import org.pentaho.di.core.Result;
import org.pentaho.di.job.Job;
import org.pentaho.di.trans.Trans;

import java.util.Date;

/**
 * @program: collection-parent
 * @description: kettle执行结果
 * @author: dong.tl
 * @create: 2019-12-07 15:15
 **/
public class KettleResult {
    //执行状态
    private String status;
    //kettle执行日志id
    private String logChannelId;
    //执行错误数
    private int errors;
    //开始时间
    private Date startDate;
    //结束时间
    private Date endDate;
    //结果集合
    private Result result;

    /**
     * 传入Job设置属性
     *
     * @param job
     */
    public void setJob(Job job) {
        this.status = job.getStatus();
        this.logChannelId = job.getLogChannelId();
        this.errors = job.getErrors();
        this.result = job.getResult().lightClone();
        this.startDate = job.getStartDate();
        this.endDate = job.getEndDate();
    }

    /**
     * 传入Trans设置属性
     *
     * @param trans
     */
    public void setTrans(Trans trans) {
        this.status = trans.getStatus();
        this.logChannelId = trans.getLogChannelId();
        this.errors = trans.getErrors();
        this.result = trans.getResult().lightClone();
        this.startDate = trans.getStartDate();
        this.endDate = trans.getEndDate();
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLogChannelId() {
        return logChannelId;
    }

    public void setLogChannelId(String logChannelId) {
        this.logChannelId = logChannelId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
