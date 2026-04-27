package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ReportCriteriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String type = request.getParameter("type");

            // ✅ NULL CHECK (VERY IMPORTANT)
            if (type == null) {
                response.getWriter().println("❌ Type not selected");
                return;
            }

            if (type.equals("above")) {
                response.sendRedirect("report_form.jsp?type=above");

            } else if (type.equals("subject")) {
                response.sendRedirect("report_form.jsp?type=subject");

            } else if (type.equals("top")) {
                response.sendRedirect("report_form.jsp?type=top");

            } else {
                response.getWriter().println("❌ Invalid type selected");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Error occurred in report servlet");
        }
    }
}