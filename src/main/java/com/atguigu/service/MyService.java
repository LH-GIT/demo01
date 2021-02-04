package com.atguigu.service;

import com.atguigu.bean.User;
import org.junit.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*************************************************
                时间: 2020-12-30
                作者: 刘  辉
                描述: 
  ************************************************/
@Component
public class MyService implements UserDetailsService {

    private static Map<String, User> maps=new HashMap<String, User>();

    static {
        //123456
        User zhangsan = new User("zhangsan", "$2a$10$h/xbZ7nzjNCm9eVQ1N2zVeBJ41JZ8ygDkDYyvTsfEADUJrR/QRrZu", 12, true);
        maps.put(zhangsan.getUsername(),zhangsan);
      //abc
        User lisi = new User("lisi", "$2a$10$c0piGBd6Htlf7nlFxyRkzuw5hhYYYL2.HlPA13hT5c7fiowubFn5C", 12, true);
        maps.put(lisi.getUsername(),lisi);
        //abc
        User wangwu = new User("wangwu", "$2a$10$c0piGBd6Htlf7nlFxyRkzuw5hhYYYL2.HlPA13hT5c7fiowubFn5C", 12, true);
        maps.put(wangwu.getUsername(),wangwu);
    }
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = maps.get(name);
        if(user == null){
            return null;
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

        if(name.equals("zhangsan")){
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else if(name.equals("lisi")){
            authorities.add(new SimpleGrantedAuthority("add"));
        }
        else if(name.equals("wangwu")){
            authorities.add(new SimpleGrantedAuthority("ROLE_ABC"));
        }



        return  new org.springframework.security.core.userdetails.User(name,user.getPassword(),authorities);
    }

    @Test
    public void testMD5(){
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        String encode1 = encoder.encode("abc");
        System.out.println(encode);
        System.out.println(encode1);
    }
}
