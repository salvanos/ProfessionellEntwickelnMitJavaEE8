package de.java2enterprise.onlineshop;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import de.java2enterprise.onlineshop.model.Customer;
import de.java2enterprise.onlineshop.model.Item;

@WebServlet("/sell")
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024
        * 1024, maxFileSize = 1024 * 1024
                * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class SellServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public final static int MAX_IMAGE_LENGTH = 400;

    @Resource
    private DataSource ds;

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Part part = request.getPart("foto");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            InputStream in = part.getInputStream();
            int i = 0;
            while ((i = in.read()) != -1) {
                baos.write(i);
            }
        } catch (IOException ex) {
            throw new ServletException(ex.getMessage());
        }

        HttpSession session = request.getSession();
        Object customer = session.getAttribute("customer");
        if (customer != null) {
            String title = request.getParameter("title");
            String description = request
                    .getParameter("description");
            String price = request.getParameter("price");

            Item item = new Item();
            item.setTitle(title);
            item.setDescription(description);
            item.setPrice(Double.valueOf(price));
            item.setSeller(((Customer) customer).getId());
            item.setFoto(scale(baos.toByteArray()));
            baos.flush();

            try {
                persist(item);
            } catch (Exception e) {
                throw new ServletException(e.getMessage());
            }
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void persist(Item item) throws Exception {
        String[] autogeneratedKeys = new String[] { "id" };
        try (final Connection con = ds.getConnection();
                final PreparedStatement stmt = con
                        .prepareStatement(
                                "INSERT INTO onlineshop.item ("
                                        + "title, "
                                        + "description, "
                                        + "price, "
                                        + "foto, "
                                        + "seller_id "
                                        + ") VALUES ("
                                        + "?, " + "?, "
                                        + "?, " + "?, "
                                        + "?" + ") ",
                                autogeneratedKeys)) {
            stmt.setString(1, item.getTitle());
            stmt.setString(2, item.getDescription());
            stmt.setDouble(3, item.getPrice());
            stmt.setBytes(4, item.getFoto());
            stmt.setLong(5, item.getSeller());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            Long id = null;
            while (rs.next()) {
                id = rs.getLong(1);
                item.setId(id);
            }
        }
    }

    public byte[] scale(byte[] foto) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                foto);
        BufferedImage originalBufferedImage = ImageIO
                .read(byteArrayInputStream);

        double originalWidth = (double) originalBufferedImage
                .getWidth();
        double originalHeight = (double) originalBufferedImage
                .getHeight();
        double relevantLength = originalWidth > originalHeight
                ? originalWidth
                : originalHeight;
        double transformationScale = MAX_IMAGE_LENGTH
                / relevantLength;

        int width = (int) Math
                .round(transformationScale * originalWidth);
        int height = (int) Math.round(
                transformationScale * originalHeight);

        BufferedImage resizedBufferedImage = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resizedBufferedImage
                .createGraphics();
        g2d.setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        AffineTransform affineTransform = AffineTransform
                .getScaleInstance(transformationScale,
                        transformationScale);
        g2d.drawRenderedImage(originalBufferedImage,
                affineTransform);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resizedBufferedImage, "PNG", baos);
        return baos.toByteArray();
    }
}