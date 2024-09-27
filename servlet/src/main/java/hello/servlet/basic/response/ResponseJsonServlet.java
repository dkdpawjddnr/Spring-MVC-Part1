package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Content-Type: application/json
        response.setContentType("application/json");
        request.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("ji");
        helloData.setAge(20);

        //{"username" : "ji", "age" : 20}
        String result = objectMapper.writeValueAsString(helloData);// 이 객체를 써서 문자로 바꿔라
        response.getWriter().write(result);

    }
}
