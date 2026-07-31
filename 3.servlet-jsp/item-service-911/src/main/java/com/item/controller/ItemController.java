package com.item.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.sql.DataSource;

import com.item.model.Item;
import com.item.model.ItemDetails;
import com.item.service.ItemService;
import com.item.service.impl.ItemServiceImpl;
import com.item.util.ValidationUtil;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ItemController")
public class ItemController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/item")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (Objects.isNull(action)) {
            action = "showItems";
        }
        try {
            switch (action) {
                case "showItems":
                    showItems(request, response);
                    break;
                case "showItem":
                    showItem(request, response);
                    break;
                case "addItem":
                    addItem(request, response);
                    break;
                case "updateItem":
                    updateItem(request, response);
                    break;
                case "deleteItem":
                    deleteItem(request, response);
                    break;
                case "showAddDetails":
                    showAddDetails(request, response);
                    break;
                case "showUpdateDetails":
                    showUpdateDetails(request, response);
                    break;
                case "addDetails":
                    addDetails(request, response);
                    break;
                case "updateDetails":
                    updateDetails(request, response);
                    break;
                default:
                    showItems(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectToError(request, response, "An unexpected error occurred: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    // ------------------------------------------------------------------
    // Item actions
    // ------------------------------------------------------------------

    private void showItems(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ItemService service = service();
        List<Item> items = service.getItems();
        request.setAttribute("itemsData", items != null ? items : List.of());
        request.getRequestDispatcher("/showItems.jsp").forward(request, response);
    }

    private void showItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = parseLong(request.getParameter("id"));
        if (id == null) {
            redirectToError(request, response, "Invalid item id.");
            return;
        }
        Item item = service().getItemById(id);
        if (item == null) {
            redirectToError(request, response, "Item not found.");
            return;
        }
        request.setAttribute("itemData", item);
        request.getRequestDispatcher("/update-item.jsp").forward(request, response);
    }

    private void addItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = trim(request.getParameter("name"));
        Double price = parseDouble(request.getParameter("price"));
        Integer totalNumber = parseInt(request.getParameter("totalNumber"));

        if (!ValidationUtil.isValidItemName(name) || price == null || !ValidationUtil.isPositivePrice(price)
                || totalNumber == null || !ValidationUtil.isNonNegative(totalNumber)) {
            redirectToError(request, response, "Invalid item data. Name required, price > 0, total >= 0.");
            return;
        }

        Item item = new Item(name, price, totalNumber);
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            item.setUserId((Long) session.getAttribute("userId"));
        }

        boolean ok = service().addItem(item);
        if (ok) {
            response.sendRedirect(request.getContextPath() + "/ItemController?action=showItems");
        } else {
            redirectToError(request, response, "Failed to add item. Name may already exist.");
        }
    }

    private void updateItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = parseLong(request.getParameter("id"));
        String name = trim(request.getParameter("name"));
        Double price = parseDouble(request.getParameter("price"));
        Integer totalNumber = parseInt(request.getParameter("totalNumber"));

        if (id == null || !ValidationUtil.isValidItemName(name) || price == null
                || !ValidationUtil.isPositivePrice(price) || totalNumber == null
                || !ValidationUtil.isNonNegative(totalNumber)) {
            redirectToError(request, response, "Invalid item data for update.");
            return;
        }

        Item item = new Item(id, name, price, totalNumber);
        boolean ok = service().updateItem(item);
        if (ok) {
            response.sendRedirect(request.getContextPath() + "/ItemController?action=showItems");
        } else {
            redirectToError(request, response, "Failed to update item.");
        }
    }

    private void deleteItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = parseLong(request.getParameter("id"));
        if (id == null) {
            redirectToError(request, response, "Invalid item id.");
            return;
        }
        boolean ok = service().removeItemById(id);
        if (ok) {
            response.sendRedirect(request.getContextPath() + "/ItemController?action=showItems");
        } else {
            redirectToError(request, response, "Failed to delete item.");
        }
    }

    // ------------------------------------------------------------------
    // Item Details actions
    // ------------------------------------------------------------------

    private void showAddDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long itemId = parseLong(request.getParameter("itemId"));
        if (itemId == null) {
            redirectToError(request, response, "Invalid item id.");
            return;
        }
        Item item = service().getItemById(itemId);
        if (item == null) {
            redirectToError(request, response, "Item not found.");
            return;
        }
        if (item.hasDetails()) {
            redirectToError(request, response, "This item already has details. Use Update instead.");
            return;
        }
        request.setAttribute("itemData", item);
        request.getRequestDispatcher("/add-item-details.jsp").forward(request, response);
    }

    private void showUpdateDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long itemId = parseLong(request.getParameter("itemId"));
        if (itemId == null) {
            redirectToError(request, response, "Invalid item id.");
            return;
        }
        Item item = service().getItemById(itemId);
        if (item == null || !item.hasDetails()) {
            redirectToError(request, response, "Item or details not found.");
            return;
        }
        request.setAttribute("itemData", item);
        request.setAttribute("detailsData", item.getDetails());
        request.getRequestDispatcher("/update-item-details.jsp").forward(request, response);
    }

    private void addDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long itemId = parseLong(request.getParameter("itemId"));
        String description = trim(request.getParameter("description"));
        String category = trim(request.getParameter("category"));
        String manufacturer = trim(request.getParameter("manufacturer"));
        Integer warranty = parseInt(request.getParameter("warrantyMonths"));

        if (itemId == null) {
            redirectToError(request, response, "Invalid item id.");
            return;
        }
        if (warranty == null) {
            warranty = 0;
        }
        if (!ValidationUtil.isNonNegative(warranty)) {
            redirectToError(request, response, "Warranty months must be >= 0.");
            return;
        }

        ItemDetails details = new ItemDetails(itemId, description, category, manufacturer, warranty);
        boolean ok = service().addItemDetails(details);
        if (ok) {
            response.sendRedirect(request.getContextPath() + "/ItemController?action=showItems");
        } else {
            redirectToError(request, response, "Failed to add item details (maybe already exists).");
        }
    }

    private void updateDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long itemId = parseLong(request.getParameter("itemId"));
        String description = trim(request.getParameter("description"));
        String category = trim(request.getParameter("category"));
        String manufacturer = trim(request.getParameter("manufacturer"));
        Integer warranty = parseInt(request.getParameter("warrantyMonths"));

        if (itemId == null) {
            redirectToError(request, response, "Invalid item id.");
            return;
        }
        if (warranty == null) {
            warranty = 0;
        }

        ItemDetails details = new ItemDetails(itemId, description, category, manufacturer, warranty);
        boolean ok = service().updateItemDetails(details);
        if (ok) {
            response.sendRedirect(request.getContextPath() + "/ItemController?action=showItems");
        } else {
            redirectToError(request, response, "Failed to update item details.");
        }
    }

    // ------------------------------------------------------------------
    // Helpers – remove duplication
    // ------------------------------------------------------------------

    private ItemService service() {
        return new ItemServiceImpl(dataSource);
    }

    private void redirectToError(HttpServletRequest request, HttpServletResponse response, String message)
            throws IOException {
        response.sendRedirect(request.getContextPath() + "/error.jsp?msg="
                + java.net.URLEncoder.encode(message, "UTF-8"));
    }

    private static String trim(String s) {
        return s == null ? null : s.trim();
    }

    private static Long parseLong(String s) {
        try {
            return s == null || s.isBlank() ? null : Long.parseLong(s.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static Double parseDouble(String s) {
        try {
            return s == null || s.isBlank() ? null : Double.parseDouble(s.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static Integer parseInt(String s) {
        try {
            return s == null || s.isBlank() ? null : Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
