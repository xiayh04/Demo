package org.ihsp.data.common;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ControlPermissionConstant {
    private static Map<String, String> allPerm = new HashMap<String, String>();
    private static Map<String, String> allRole = new HashMap<String, String>();

    /*
     * user related permission
     */
    public static final String USER_CREATE = "USER:CREATE";
    public static final String USER_UPDATE = "USER:UPDATE";
    public static final String USER_VIEW = "USER:VIEW";
    public static final String USER_DELETE = "USER:DELETE";

    /*
     * role related permission
     */
    public static final String ROLE_CREATE = "ROLE:CREATE";
    public static final String ROLE_UPDATE = "ROLE:UPDATE";
    public static final String ROLE_VIEW = "ROLE:VIEW";
    public static final String ROLE_DELETE = "ROLE:DELETE";

    /*
     * permission related permission
     */
    public static final String PERM_CREATE = "PERM:CREATE";
    public static final String PERM_UPDATE = "PERM:UPDATE";
    public static final String PERM_VIEW = "PERM:VIEW";
    public static final String PERM_DELETE = "PERM:DELETE";

    /*
     * software related permission
     */
    public static final String SOFTWARE_CREATE = "SOFTWARE:CREATE";
    public static final String SOFTWARE_UPDATE = "SOFTWARE:UPDATE";
    public static final String SOFTWARE_VIEW = "SOFTWARE:VIEW";
    public static final String SOFTWARE_DELETE = "SOFTWARE:DELETE";

    /*
     * datasource related permission
     */
    public static final String DATASOURCE_CREATE = "DATASOURCE:CREATE";
    public static final String DATASOURCE_UPDATE = "DATASOURCE:UPDATE";
    public static final String DATASOURCE_VIEW = "DATASOURCE:VIEW";
    public static final String DATASOURCE_DELETE = "DATASOURCE:DELETE";

    /*
     * device related permission
     */
    public static final String DEVICE_CREATE = "DEVICE:CREATE";
    public static final String DEVICE_UPDATE = "DEVICE:UPDATE";
    public static final String DEVICE_VIEW = "DEVICE:VIEW";
    public static final String DEVICE_DELETE = "DEVICE:DELETE";

    /*
     * project related permission
     */
    public static final String PROJECT_CREATE = "PROJECT:CREATE";
    public static final String PROJECT_UPDATE = "PROJECT:UPDATE";
    public static final String PROJECT_VIEW = "PROJECT:VIEW";
    public static final String PROJECT_DELETE = "PROJECT:DELETE";

    /*
     * data related permission
     */
    public static final String DATA_CREATE = "DATA:CREATE";
    public static final String DATA_UPDATE = "DATA:UPDATE";
    public static final String DATA_VIEW = "DATA:VIEW";
    public static final String DATA_DELETE = "DATA:DELETE";
    
    
    public static Map<String, String> getAllPerm() {
        allPerm.put("DATA_CREATE", DATA_CREATE);
        allPerm.put("DATA_UPDATE", DATA_UPDATE);
        allPerm.put("DATA_VIEW", DATA_VIEW);
        allPerm.put("DATA_DELETE", DATA_DELETE);
        
        allPerm.put("PROJECT_CREATE", PROJECT_CREATE);
        allPerm.put("PROJECT_UPDATE", PROJECT_UPDATE);
        allPerm.put("PROJECT_VIEW", PROJECT_VIEW);
        allPerm.put("PROJECT_DELETE", PROJECT_DELETE);

        allPerm.put("DEVICE_CREATE", DEVICE_CREATE);
        allPerm.put("DEVICE_UPDATE", DEVICE_UPDATE);
        allPerm.put("DEVICE_VIEW", DEVICE_VIEW);
        allPerm.put("DEVICE_DELETE", DEVICE_DELETE);

        allPerm.put("DATASOURCE_CREATE", DATASOURCE_CREATE);
        allPerm.put("DATASOURCE_UPDATE", DATASOURCE_UPDATE);
        allPerm.put("DATASOURCE_VIEW", DATASOURCE_VIEW);
        allPerm.put("DATASOURCE_DELETE", DATASOURCE_DELETE);

        allPerm.put("SOFTWARE_CREATE", SOFTWARE_CREATE);
        allPerm.put("SOFTWARE_UPDATE", SOFTWARE_UPDATE);
        allPerm.put("SOFTWARE_VIEW", SOFTWARE_VIEW);
        allPerm.put("SOFTWARE_DELETE", SOFTWARE_DELETE);

        allPerm.put("PERM_CREATE", PERM_CREATE);
        allPerm.put("PERM_UPDATE", PERM_UPDATE);
        allPerm.put("PERM_VIEW", PERM_VIEW);
        allPerm.put("PERM_DELETE", PERM_DELETE);

        allPerm.put("ROLE_CREATE", ROLE_CREATE);
        allPerm.put("ROLE_UPDATE", ROLE_UPDATE);
        allPerm.put("ROLE_VIEW", ROLE_VIEW);
        allPerm.put("ROLE_DELETE", ROLE_DELETE);
        /*
         * user related permission
         */
        allPerm.put("USER_CREATE", USER_CREATE);
        allPerm.put("USER_UPDATE", USER_UPDATE);
        allPerm.put("USER_VIEW", USER_VIEW);
        allPerm.put("USER_DELETE", USER_DELETE);

        return allPerm;
    }

}
