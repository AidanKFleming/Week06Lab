/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 819466
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        if ("logout".equals(action)) {
            session.invalidate();
            request.setAttribute("loginAlert", "Logged Out Succesfully");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }

        String username = (String) session.getAttribute("username");
        if (username == null || username.equals("") || username.equals(" ")) {
            request.setAttribute("loginAlert", "Please log in to view the shopping list.");
            request.setAttribute("username", "");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            request.setAttribute("username", username);
            session.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        ArrayList<String> items = new ArrayList<>();;
        String item;

        if (action.equals("register")) {
            String username = request.getParameter("username");
            session.setAttribute("username", username);
            session.setAttribute("items", items);
            response.sendRedirect("ShoppingList");
        } else if (action.equals("add")) {
            item = request.getParameter("item");
            items = (ArrayList<String>) session.getAttribute("items");
            items.add(item);
            session.setAttribute("items", items);
            response.sendRedirect("ShoppingList");
        } else if (action.equals("delete")) {
            item = request.getParameter("item");
            items = (ArrayList<String>) session.getAttribute("items");
            items.remove(item);
            session.setAttribute("items", items);
            response.sendRedirect("ShoppingList");
        }
    }

}
