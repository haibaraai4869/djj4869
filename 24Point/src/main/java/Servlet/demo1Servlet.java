package Servlet;

import One.demo1;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.nums;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/demo1Servlet")
public class demo1Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问到了servlet");
        nums nums = new nums();//创建nums封装接收到的数据
        nums.setA(request.getParameter("num1"));
        nums.setB(request.getParameter("num2"));
        nums.setC(request.getParameter("num3"));
        nums.setD(request.getParameter("num4"));

        String calculate = demo1.calculate(nums);


        //发回html显示结果
        System.out.println("后缀式为："+calculate);


        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),calculate);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }
}
