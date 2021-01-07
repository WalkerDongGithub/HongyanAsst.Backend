package hongyan.backend.dao;


import hongyan.backend.pojo.Bicycle;

import java.util.List;

/**
 * 时间：2021/01/07
 * 作者：Walker
 * 简介：
 *            持久层接口采用 MyBatis框架。
 *            用于对数据库进行访问，通过操作Bicycle实例，借助SQL语句实现对后台数据的控制。
 *
 *            目前处于测试阶段，仅限于对数据库访问做一些基础的尝试，确保网络畅通。
 * todo:整合Mybatis框架实现基本的CRUD。
 *
 */
public interface BicycleMapper {

    /**
     * for test.
     * @return 所有的自行车实例。
     */
    List<Bicycle> getAllBicycle();

    /**
     * for test.
     * 查询确定的某一自行车实例。
     * @param key 键值
     * @return 特定键值的自行车实例。否则返回null.
     * Warning! Return value is nullable!
     */
    Bicycle selectBicycleByKey(String key);

    /**
     * for test.
     * 使用过滤器查询。
     * 查询price价格以下的自行车数据。
     * @param price 封顶价格。
     * @return price价格一下的自行车实例。
     */
    List<Bicycle> selectBicycleByFilter(int price);

    /**
     * for test.
     * 删除特定键值的自行车数据
     * @param key 键值
     * @return 删除成功返回true，否则返回false
     */
    boolean removeBicycleByName(String key);


    /**
     * for test.
     * @param bicycle 自行车实例
     * @return 插入成功返回true，否则返回false
     */
    boolean insertBicycle(Bicycle bicycle);


    /**
     * for test.
     * 按键值查找实例并更改某一个自行车的实例数据为参数实例
     * 参数实例的功能如下。
     * @param bicycle 新自行车实例。
     * @return
     */
    boolean alterBicyclebyKey(Bicycle bicycle);


}
