package hongyan.backend.service;

import hongyan.backend.dao.BicycleManager;
import hongyan.backend.pojo.BicycleBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Spring Boot应用程序的入口。
 */
@SpringBootApplication
@ServletComponentScan
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
        test();
    }

    /**
     * 测试dao层的数据库是否正确连接。
     */
    public static void test() {
        //获取spring 的上下文对象。
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config.xml");
        BicycleManager manager = (BicycleManager) applicationContext.getBean("manager");
        System.out.println(manager.jdbcTemplate);

        try {
            manager.resetList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            manager.insert(new BicycleBuilder()
                            .setId("2019210" + i)
                            .setBicycleName("WalkerBicycle" + i).build());//Builder方法构造。
        }
        List<Map<String, Object>> maps = manager.selectAll();
        System.out.println(maps);
    }
}

