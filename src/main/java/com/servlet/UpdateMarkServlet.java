package com.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.dao.MarkDAO;
import com.model.StudentMark;

public class UpdateMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        try {

            // 🔥 Get parameters safely
            String idStr = request.getParameter("id");
            String name = request.getParameter("name");
            String subject = request.getParameter("subject");
            String marksStr = request.getParameter("marks");
            String dateStr = request.getParameter("date");

            // 🔴 NULL + EMPTY CHECK (IMPORTANT)
            if (idStr == null || name == null || subject == null ||
                marksStr == null || dateStr == null ||
                idStr.isEmpty() || name.isEmpty() || subject.isEmpty() ||
                marksStr.isEmpty() || dateStr.isEmpty()) {

                response.getWriter().println("❌ Please fill all required fields");
                return;
            }

            // 🔥 Convert safely
            int id = Integer.parseInt(idStr);
            int marks = Integer.parseInt(marksStr);
            Date date = Date.valueOf(dateStr);

            // 🔥 Set model
            StudentMark s = new StudentMark();
            s.setStudentID(id);
            s.setStudentName(name);
            s.setSubject(subject);
            s.setMarks(marks);
            s.setExamDate(date);

            // 🔥 DAO call
            MarkDAO dao = new MarkDAO();
            int status = dao.update(s);

            // 🔥 Result handling
            if (status > 0) {
                response.sendRedirect("success.jsp");
            } else {
                response.getWriter().println("❌ Update failed: ID not found in database");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Server error occurred (check console)");
        }
    }
}