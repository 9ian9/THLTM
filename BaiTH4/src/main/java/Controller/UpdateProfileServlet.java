package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String faculityId = request.getParameter("faculityId");

        // Cập nhật thông tin người dùng trong cơ sở dữ liệu (code giả định)
        // UserDAO.updateUser(id, name, email, faculityId);

        // Chuyển hướng lại trang profile sau khi cập nhật
        response.sendRedirect("profile.jsp");
    }
}
