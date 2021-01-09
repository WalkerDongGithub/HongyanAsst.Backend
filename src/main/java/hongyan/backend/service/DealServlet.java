package hongyan.backend.service;


import hongyan.backend.dao.BicycleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 时间：2021/01/08
 * 作者：Walker
 * 简介：
 *          Servlet是前后端服务的端口，用于接收和发送数据。
 *          DealServlet则是所有的后端服务的总接口。
 *          后端所应实现的主要功能有：
 *                  存储一辆车的有关数据，
 *                  查询是否已有某辆车，
 *                  查询所有的用户数据，
 *                  查询一个特定车的数据，
 *                  查询某一个车的数据。
 *
 * Status：测试阶段。未部署
 *
 */
@Service("dealServlet")
@WebServlet("/hello")
public class DealServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Request gotten!");
    }
}
