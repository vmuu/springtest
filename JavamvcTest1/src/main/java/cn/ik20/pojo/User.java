package cn.ik20.pojo;

public class User {

    // 用户 id
    private int uid;

    // 用户姓名
    private String uname;

    // 用户年龄
    private int uage;

    // 无参构造函数
    public User() {
    }

    // 有参构造函数
    public User(int uid, String uname, int uage) {
        this.uid = uid;
        this.uname = uname;
        this.uage = uage;
    }

    // 重写 toString 方法
    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uage=" + uage +
                '}';
    }


    // 获取用户 id
    public int getUid() {
        return uid;
    }

    // 设置用户 id
    public void setUid(int uid) {
        this.uid = uid;
    }

    // 获取用户姓名
    public String getUname() {
        return uname;
    }

    // 设置用户姓名
    public void setUname(String uname) {
        this.uname = uname;
    }

    // 获取用户年龄
    public int getUage() {
        return uage;
    }

    // 设置用户年龄
    public void setUage(int uage) {
        this.uage = uage;
    }

}