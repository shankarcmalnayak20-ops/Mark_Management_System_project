package com.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.model.StudentMark;

public class ReportServlet extends HttpServlet {

    private String url = "jdbc:mysql://localhost:3306/MarkDB";
    private String user = "root";
    private String password = "Shankar@180";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<StudentMark> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            String type = request.getParameter("type");

            if (type == null || type.isEmpty()) {
                response.getWriter().println("❌ Select report type");
                return;
            }

            PreparedStatement ps = null;

            if (type.equals("above")) {

                String marksStr = request.getParameter("marks");
                if (marksStr == null || marksStr.isEmpty()) {
                    response.getWriter().println("❌ Enter marks");
                    return;
                }

                int marks = Integer.parseInt(marksStr);

                ps = con.prepareStatement("SELECT * FROM StudentMarks WHERE Marks > ?");
                ps.setInt(1, marks);

            } else if (type.equals("subject")) {

                String subject = request.getParameter("subject");
                if (subject == null || subject.isEmpty()) {
                    response.getWriter().println("❌ Enter subject");
                    return;
                }

                ps = con.prepareStatement("SELECT * FROM StudentMarks WHERE Subject = ?");
                ps.setString(1, subject);

            } else if (type.equals("top")) {

                String limitStr = request.getParameter("limit");
                if (limitStr == null || limitStr.isEmpty()) {
                    response.getWriter().println("❌ Enter limit");
                    return;
                }

                int limit = Integer.parseInt(limitStr);

                ps = con.prepareStatement("SELECT * FROM StudentMarks ORDER BY Marks DESC LIMIT ?");
                ps.setInt(1, limit);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                StudentMark s = new StudentMark();
                s.setStudentID(rs.getInt("StudentID"));
                s.setStudentName(rs.getString("StudentName"));
                s.setSubject(rs.getString("Subject"));
                s.setMarks(rs.getInt("Marks"));
                s.setExamDate(rs.getDate("ExamDate"));
                list.add(s);
            }

            request.setAttribute("reportList", list);
            RequestDispatcher rd = request.getRequestDispatcher("report_result.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Error in report servlet");
        }
    }
}