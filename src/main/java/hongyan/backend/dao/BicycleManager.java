package hongyan.backend.dao;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import hongyan.backend.pojo.Bicycle;
import hongyan.backend.pojo.BicycleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * 时间：2021/01/08
 * 作者：Walker
 * 简介：
 *          自行车管理员，即数据库自行车表的dao类。
 *          前期项目较小，不适合使用笨重的框架进行实现。
 *          考虑使用JDBC结合spring boot的配置对数据库进行简单的CRUO。
 *          但是问题是java代码和sql语句耦合性过强，只适合做简单的工作。
 *          测试结束之后向service层提供服务接口。
 *
 *
 *
 */
@Controller
public class BicycleManager {


    public JdbcTemplate jdbcTemplate;


    /**
     * 时间：2021/01/09
     * 作者：Walker
     * 简介：
     *              建表操作，将原表刷新，删除之前的所有信息。
     * 状态：已完成
     * @throws IOException
     */
    public void resetList() throws IOException {
        jdbcTemplate.update("drop table if exists bicycle");
        jdbcTemplate.update("create table bicycle(\n" +
                "    bicycle_name varchar(30) not null,\n" +
                "    id varchar(20) primary key,\n" +
                "\n" +
                "    seller_name varchar(30) not null,\n" +
                "    price int(11),\n" +
                "    image mediumblob,\n" +
                "    brand varchar(30),\n" +
                "    type varchar(30),\n" +
                "    manufacture_time year,\n" +
                "\n" +
                "    status varchar(1) not null,\n" +
                "    is_available int(1) default 1,\n" +
                "    create_time datetime default current_timestamp,\n" +
                "    update_time datetime\n" +
                "    default current_timestamp on update current_timestamp\n" +
                ")");
    }

    /**
     * 时间：2021/01/09
     * 作者：Walker
     * 简介：
     *              查询所有的Bicycle表的数据。
     *              for test.
     * 状态：已完成
     * @return
     */
    public List<Map<String, Object>> selectAll() {
        String sql = "select * from bicycle";
        return jdbcTemplate.queryForList(sql);
    }


    /**
     * 时间：2021/01/09
     * 作者：Walker
     * 简介：
     *              插入一条数据。
     *              仅作为基础测试
     * 状态：测试中。
     * @param bicycle
     */
    public void insert(Bicycle bicycle) {
        String sql = "insert into bicycle(bicycle_name, id, seller_name, status) values(\'" + bicycle.getBicycleName()
                + "\', \'" + bicycle.getId()
                + "\', \'" + bicycle.getSellerName()
                + "\', \'" + Bicycle.Status.convert(bicycle.getStatus()) + "\')";
        jdbcTemplate.update(sql);
        System.out.println(sql);
    }

    /**
     * spring内部配置方法。
     * @param dataSource
     */
    public void setDataSource(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}

