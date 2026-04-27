package com.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.dao.MarkDAO;
import com.model.StudentMark;

public class AddMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        try {

            // GET VALUES
            String idStr = request.getParameter("id");
            String name = request.getParameter("name");
            String subject = request.getParameter("subject");
            String marksStr = request.getParameter("marks");
            String dateStr = request.getParameter("date");

            // SERVER VALIDATION
            if (idStr == null || idStr.isEmpty() ||
                name == null || name.isEmpty() ||
                subject == null || subject.isEmpty() ||
                marksStr == null || marksStr.isEmpty() ||
                dateStr == null || dateStr.isEmpty()) {

                response.getWriter().println("❌ All fields are required");
                return;
            }

            int id = Integer.parseInt(idStr);
            int marks = Integer.parseInt(marksStr);

            if (marks < 0 || marks > 100) {
                response.getWriter().println("❌ Marks must be between 0 and 100");
                return;
            }

            Date date = Date.valueOf(dateStr);

            // MODEL
            StudentMark s = new StudentMark();
            s.setStudentID(id);
            s.setStudentName(name);
            s.setSubject(subject);
            s.setMarks(marks);
            s.setExamDate(date);

            // DAO
            MarkDAO dao = new MarkDAO();
            dao.add(s);

            response.sendRedirect("success.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Error: " + e.getMessage());
        }
    }
}