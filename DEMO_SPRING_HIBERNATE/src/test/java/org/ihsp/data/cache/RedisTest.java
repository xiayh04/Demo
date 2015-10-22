package org.ihsp.data.cache;

import org.junit.AfterClass;
//import redis.clients.jedis.Jedis;

public class RedisTest {
    private final int total = 10000000;// 千万

    /*@Test
    public void saveMapTest() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Map<Integer,People> map = new HashMap<Integer,People>();
        for (int i = 0; i <= total; i++) {
            People p = new People();
            p.setId(i);
            p.setName("name_" + i);
            map.put(i, p);
        }
        byte[] sp = SerializeUtil.serialize((HashMap<Integer,People>)map);
        jedis.set("peoples".getBytes(), sp);
        jedis.disconnect();
    }
    @Test
    public void saveObjTest() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        for (int i = 0; i <= total; i++) {
            People p = new People();
            p.setId(i);
            p.setName("name_" + i);
            byte[] sp = SerializeUtil.serialize(p);
            jedis.set((i + "").getBytes(), sp);
        }
        jedis.disconnect();
    }
    @Test
    public void getTest() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        int count = 0;
        for (int i = 0; i <= total; i++) {
            People p = (People) SerializeUtil.unserialize(jedis.get((i + "")
                    .getBytes()));
            if (p != null)
                count++;
        }
        System.out.println("object count:" + count);
        jedis.disconnect();
    }*/
    @AfterClass
    public void teardown(){
    	
    }
}
