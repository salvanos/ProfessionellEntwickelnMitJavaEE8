package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/foto")
public class FotoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource
    private DataSource ds;

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        try (final Connection con = ds.getConnection();
                final PreparedStatement stmt = con
                        .prepareStatement(
                                "SELECT " +
                                        "foto " +
                                        "FROM onlineshop.item "
                                        +
                                        "WHERE id = ?")) {

            stmt.setLong(1, Long.parseLong(id));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Blob foto = rs.getBlob("foto");
                response.reset();
                int length = (int) foto.length();
                response.setHeader("Content-Length",
                        String.valueOf(length));
                InputStream in = foto.getBinaryStream();
                final int bufferSize = 256;
                byte[] buffer = new byte[bufferSize];

                ServletOutputStream out = response
                        .getOutputStream();
                while ((length = in.read(buffer)) != -1) {
                    out.write(buffer, 0, length);
                }
                in.close();
                out.flush();
                foto = null;
            }
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
    }
}
