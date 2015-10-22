package org.ihsp.data.cache.common;
import java.io.ByteArrayInputStream;   
import java.io.ByteArrayOutputStream;   
import java.io.ObjectInputStream;   
import java.io.ObjectOutputStream;   
import java.io.Serializable;   
  
public class User implements Serializable {   
    private static final long serialVersionUID = 1L;
    private String username;   
    private transient String password;   
    public User(String username,String password){   
        this.username = username;   
        this.password = password;   
    }   
   public static void main(String[] args) throws Exception{   
       User user = new User("Intlgj","123456");   
       System.out.println("Before Serializable"+user.username+"..."+user.password);   
       ByteArrayOutputStream buf = new ByteArrayOutputStream();   
       ObjectOutputStream out = new ObjectOutputStream(buf);   
       out.writeObject(user);
       out.flush();
       out.close();
       System.out.println(buf);
       ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));   
      user = (User)in.readObject();   
      System.out.println("After Serializable:"+user.username+"...."+user.password);   
   }   
}     
