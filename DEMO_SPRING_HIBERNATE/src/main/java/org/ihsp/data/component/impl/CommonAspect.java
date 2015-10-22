package org.ihsp.data.component.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.ihsp.data.utils.DataSourceSwitcher;
import org.ihsp.data.utils.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*@Aspect
@Component("commonAspect")*/
public class CommonAspect {
    private static final Logger log = Logger.getLogger(CommonAspect.class);
    @Autowired
    DynamicDataSource dynamicDS;
    
    @PostConstruct
    public void init() {
    }



   /* @Before("execution(* com.yhxia.ssh.service..*Service.*(..))")
    public void beforeServiceCalled(JoinPoint joinPoint) {
        System.out.println("切入: " + joinPoint.getClass().getName() + " 类中 " + joinPoint.getSignature().getName() + " 方法");  
        String methodName= joinPoint.getSignature().getName();
        //根据用户来选择哪个集群(Data Shard,datasource group)
        //根据方法来选在是读数据库，还是写数据库(主从分离)
       //DataSourceSwitcher.switchDataSource(methodName);
    }*/

    // public List<ChangeCellVO> recalcPunit(String soeid, int cycleId, int
    // punitId, int workBookId, int scenarioId)
    public void logAfterRecalc(JoinPoint joinPoint) {
    }

    @PreDestroy
    public void stop() {
    }

}
