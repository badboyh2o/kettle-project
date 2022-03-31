package com.tl.kettle.client;

import com.tl.kettle.implement.KettleImplement;
import com.tl.kettle.report.KettleResult;
import org.pentaho.di.core.exception.KettleException;

/**
 * @author xuhongqiang
 * @date 2022年03月31日 8:45
 */
public class Client {

    public static void main(String[] args) throws KettleException {

        KettleResult r = KettleImplement.runKjb("C:\\Users\\badboyh20\\Desktop\\feelviewplus_etl\\etl\\CheckSameTime.kjb", null);

    }
}
