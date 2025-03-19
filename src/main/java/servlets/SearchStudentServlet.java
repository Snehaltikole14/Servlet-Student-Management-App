package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/searchStudent")
public class SearchStudentServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();


        List<String> students = studentService.searchStudent(key);

        if (students.isEmpty()) {
            out.println("<p>No students found.</p>");
        } else {
            for (String student : students) {
                out.println("<p>" + student + "</p>");
            }
        }

        out.println("<br><a href='search.html'></a>");
        out.println("</body></html>");
    }

}
