package com.java.tessThread;

import java.util.HashSet;
import java.util.Set;

/**
 * 静态代理模式
 * 代理模式的用法
 * 1.首先先要有一个共同接口，然后有一个方法
 * 2.要有一个被代理对象，被代理对象实现共同的接口
 * 3.要有一个代理对象，要实现共同接口，要传入被代理对象，调用对应的接口
 *
 * 4. Thread 用了静态代理
 * ==============
 * 静态代理的优点
 * 1.代理对象可以做很多代理对象做不了的事情。
 * 2.被代理对象专注做自己的事情。
 *
 */

// 用户管理接口
interface UserManager {
    void addUser(String username);
}

// 真实用户管理实现
class RealUserManager implements UserManager {
    @Override
    public void addUser(String username) {
        // 实际添加用户的操作
        System.out.println("User added: " + username);
    }
}


// 安全代理
class SecurityProxy implements UserManager {
    private UserManager realUserManager;
    private Set<String> allowedUsers;

    public SecurityProxy() {
        this.realUserManager = new RealUserManager();
        this.allowedUsers = new HashSet<>();
        // 添加允许访问的用户
        allowedUsers.add("admin");
    }

    @Override
    public void addUser(String username) {
        // 检查用户是否有权限
        if (allowedUsers.contains(username)) {
            realUserManager.addUser(username);
        } else {
            System.out.println("Permission denied. User '" + username + "' cannot add users.");
        }
    }
}


