package org.ihsp.data.common;

import java.util.Calendar;
import java.util.Date;

import org.ihsp.data.common.MyObjectId;
import org.ihsp.data.common.ObjectId;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class UnitConvertTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    //@Test
    public void testObjectId() {
        ObjectId objId = new ObjectId();
        System.out.println("--------------------------");
        System.out.println(objId.toHexString());
        System.out.println(objId.toString());
        System.out.println(objId.toByteArray().length + ":" + objId.toByteArray());
        System.out.println(new Date().getTime());
        System.out.println(new Date(1970, 1, 1).getTime());
        long id = 9000000000000000000l;

        System.out.println(1 << 5);
    }

    //@Test
    public void testBatchMyObjectId() {

        int counter = 100000;
        while (counter-- > 0) {
            long id = MyObjectId.generateId(0);
            // id=38594307688497159l;
            System.out.println("---------------------------");
            System.out.println(id);
            System.out.println("time:" + MyObjectId.getTime(id).getTime() + ", server:" + MyObjectId.getServer(id) + ", inc:" + MyObjectId.getInc(id));
        }
    }

    //@Test
    public void testMyObjectId() {

        long id = MyObjectId.generateId(0);
        id = 3023107918548435944l;
        System.out.println("---------------------------");
        System.out.println("time:" + new Date().getTime());
        System.out.println("time:" + MyObjectId.getTime(id).getTime() + ", server:" + MyObjectId.getServer(id) + ", inc:" + MyObjectId.getInc(id));
        System.out.println(MyObjectId.generateId(1441540316053l, 0, 144));
        System.out.println(MyObjectId.generateId(1441540316053l, 0, 145));

    }

    //@Test
    public void test() {
        Calendar initCal = Calendar.getInstance();
        initCal.set(2015, 01, 01);
        Calendar cal = Calendar.getInstance();
        long time = cal.getTimeInMillis() - initCal.getTimeInMillis();
        
        System.out.println("time:" + time);
        initCal.set(2105, 01, 01);
        System.out.println("2105:" + initCal.getTimeInMillis());
        Double t = Math.pow(2, 42);
        System.out.println(t.longValue());
        
    }

}
