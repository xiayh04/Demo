package org.ihsp.data.common;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"classpath:/appCtx_main.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(value = "transactionManager")
public class UnitTestBase {

    public final int applicationId = -1;//application for test
    public final String applicationName = "华为路边停车";
    public final String applicationIds = "-1";
    public final String mac = "FFFFFFFFFFFF";
    public final String macs = "FFFFFFFFFFFF";
    public final String newmac = "000000000000";
    public final String version = "1.1_1";
    public final int page = 1;
    
    public final int start = 0;
    public final int limit = 3;
    public final boolean executed = false;
    public final Long startTime = 1335093826000L;
    public final Long endTime = 1535093826000L;
    public final String commandId = "1";
    public final String softwareId = "f257031f4df1de84014dfcf57ccd077c";
    public final String softwareIds = "f257031f4df1de84014dfcf57ccd077c,f257031f4df1de84014dfcf9c9c4077d,f257031f4e00b207014e05164d080075,f257031f4e2b1191014e2fca5ccb3215";
    public final String deviceSoftwareId = "f257031f4dec65d4014dec6a7824001e";
    public final String deviceSoftwareIds = "f257031f4dec65d4014dec6a7824001e,f257031f4dec65d4014dec6a83cc001f,f257031f4dec65d4014dec6a83d30020";

    public final String dsgIds = "4028808c4e9614ef014e961fcf420004";
    public final String dsgId = "4028808c4e9614ef014e961fcf420004";
    public final String groupName = "group0000";
    public final String appDSGId = "4028808c4e99ce0f014e99decce40001";
    public final String appDSGIds = "4028808c4e99ce0f014e99decce40001";
    public final String deviceDatasIds = "f257031f4d572936014d88cc1f33000d,f257031f4d8a5492014d8f339ea80057,f257031f4d8a5492014d8f51e7250082";

    public final String userId = "4028808c4eaf2d6d014eaf3148260002";
    public final String userIds = "4028808c4eaf2d6d014eaf3148260002";
    public final String userName = "xiayh04";
    
    public final String roleId = "4028808c4eb395f7014eb43e645d0026";
    public final String roleIds = "4028808c4eb395f7014eb43e645d0026";
    public final String roleName = "ALL_ADMIN";
    
    public final String userRoleId = "2";
    public final String userRoleIds = "2";
    
    public final String permissionId = "4028808c4eb395f7014eb39e7f040006";
    public final String permissionIds = "4028808c4eb395f7014eb39e7f040006";
    public final String permissionName = "DEVICE:*";
            
}
