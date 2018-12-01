package cn.jiuyoung.bootdemo.Service;

/**
 * UserService
 */
public interface UserService {

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    /**
     * 通过name删除一个用户
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总数
     * @return Integer 用户总数
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();
}