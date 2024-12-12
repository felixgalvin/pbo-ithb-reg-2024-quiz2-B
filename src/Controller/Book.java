package Controller;

import Model.classes.Books;
import Model.classes.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Book {

    public static List<Books> getAllBooks() {
        List<Books> booksList = new ArrayList<>();
        String query = "SELECT * FROM books";

        try (Connection con = ConnectionManager.getConnection();
                PreparedStatement st = con.prepareStatement(query)){

                ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_book");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genre = rs.getString("genre");
                int price = rs.getInt("price");

                Books book = new Books(id, title, author, genre, price);
                booksList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return booksList;
    }
}