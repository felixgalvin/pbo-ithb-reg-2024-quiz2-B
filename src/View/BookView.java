package View;

import Controller.Book;
import Model.classes.Books;
import Model.classes.Users;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BookView {
    private JFrame frame;

    public BookView() {
        frame = new JFrame("Book");
        frame.setLayout(new BorderLayout());
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);

        JPanel topPanel = new JPanel();
        JButton transactionsButton = new JButton("Transactions");
        topPanel.add(transactionsButton);
        frame.add(topPanel, BorderLayout.NORTH);

        transactionsButton.addActionListener(e -> {
            new TransactionView();
            frame.dispose();
        });

        JPanel bookPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        List<Books> books = Book.getAllBooks();

        for (Books book : books) {
            JPanel bookCard = new JPanel(new GridLayout(5, 1));

            JLabel titleLabel = new JLabel("Title : ");
            bookCard.add(titleLabel);

            JTextField titleField = new JTextField(book.getTitle());
            titleField.setEditable(false);
            bookCard.add(titleField);

            JLabel authorLabel = new JLabel("Author : ");
            bookCard.add(authorLabel);

            JTextField authorField = new JTextField(book.getAuthor());
            authorField.setEditable(false);
            bookCard.add(authorField);

            JLabel genreLabel = new JLabel("Genre : ");
            bookCard.add(genreLabel);

            JTextField genreField = new JTextField(book.getGenre());
            genreField.setEditable(false);
            bookCard.add(genreField);

            JLabel priceLabel = new JLabel("Price : ");
            bookCard.add(priceLabel);

            JTextField priceField = new JTextField(String.valueOf(book.getPrice()));
            priceField.setEditable(false);
            bookCard.add(priceField);

            JButton buyButton = new JButton("Buy Book");

            buyButton.addActionListener(e -> {
                
            });

            bookCard.add(buyButton);
            bookPanel.add(bookCard);
        }

        frame.add(new JScrollPane(bookPanel), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}