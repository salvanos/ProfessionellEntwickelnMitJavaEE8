package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import de.java2enterprise.onlineshop.model.Item;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Resource
    private DataSource ds;
	
	public void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(
		HttpServletRequest request, 
		HttpServletResponse response) 
		throws ServletException, IOException {
		
		String s = request.getParameter("search");	
		try {
			List<Item> items = find(s);
			if(items!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("items", items);
			}
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("search.jsp");
		dispatcher.forward(request, response);
	}
	
	public List<Item> find(String s) 
			throws Exception {
	    
        List<Item> items = new ArrayList<Item>();
        try(final Connection con = ds.getConnection();
            final PreparedStatement stmt = 
				con.prepareStatement(
				"SELECT " +
					"id, " +
					"title, " +
					"description, " +
					"price, " +
					"seller_id, " +
					"buyer_id, " +
					"sold " +
				"FROM onlineshop.item " +
				"WHERE title like ?"
				)) {
    		stmt.setString(
    			1, 
    				(s==null) ? "%" : "%" + s + "%");
    		ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			
    			Item item = new Item();
    			
    			Long id = Long.valueOf(rs.getLong("id"));
    			item.setId(id);
    			
    			String title = rs.getString("title");
    			item.setTitle(title);
    			
    			String description = 
    				rs.getString("description");
    			item.setDescription(description);
    			
    			double price = rs.getDouble("price");
    			if(price != 0) {
    				item.setPrice(
    					Double.valueOf(price));
    			}
    			
    			long seller = rs.getLong("seller_id");
    			if(seller != 0) {
    				item.setSeller(
    					Long.valueOf(seller));
    			}
    			
    			long buyer = rs.getLong("buyer_id");
    			if(buyer != 0) {
    				item.setBuyer(Long.valueOf(buyer));
    			}
    			
    			Timestamp ts = rs.getTimestamp("sold");
    			if(ts != null) {
    				item.setSold(ts.toLocalDateTime());
    			}
    			
    			items.add(item);
    		}
        }		
		return items;
	}
}
