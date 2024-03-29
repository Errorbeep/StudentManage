package priv.matrix.student.entity;

/**
 * 管理员实体类
 */
public class Admin {
    private long id;
    private String account;
    private String password;
    private String name;

    public Admin() {}
    
    public Admin(long id, String account, String password, String name)
    {
    	this.id = id;
    	this.account = account;
    	this.password = password;
    	this.name = name;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
