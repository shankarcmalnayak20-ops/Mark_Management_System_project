package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.dao.MarkDAO;
import com.model.StudentMark;

public class DisplayMarksServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            MarkDAO dao = new MarkDAO();

            List<StudentMark> list = dao.getAllMarks();

            request.setAttribute("data", list);

            request.getRequestDispatcher("markdisplay.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Error loading data");
        }
    }
}