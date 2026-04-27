package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.dao.MarkDAO;

public class DeleteMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String idStr = request.getParameter("id");

            if (idStr == null || idStr.isEmpty()) {
                response.getWriter().println("❌ ID is required");
                return;
            }

            int id = Integer.parseInt(idStr);

            MarkDAO dao = new MarkDAO();
            int status = dao.delete(id);

            if (status > 0) {
                response.sendRedirect("success.jsp");
            } else {
                response.getWriter().println("❌ Delete failed: ID not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("❌ Error in Delete Servlet");
        }
    }
}