//package io.devzona.interview_practices;
//
//import java.io.*;
//import java.util.*;
//
//class Book {
//    private int id;
//    private String title;
//    private String author;
//    private boolean available;
//
//    public Book(int id, String title, String author, boolean available) {
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.available = available;
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public boolean isAvailable() {
//        return available;
//    }
//
//    public void setAvailable(boolean available) {
//        this.available = available;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Book book)) return false;
//        return id == book.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//
//    @Override
//    public String toString() {
//        return "Book{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", author='" + author + '\'' +
//                ", available=" + available +
//                '}';
//    }
//}
//
//interface LibraryManagement {
//    void addBook(Book book);
//    String borrowBook(String user, Book book) throws OutOfStockException, MaxBorrowedBooksException;
//    List<Book> getBooks();
//    String viewLibraryInventory();
//}
//
//
//class LibraryManagementSystem implements LibraryManagement {
//
//    Set<Book> books = new HashSet<>();
//    HashMap<String, List<Book>> bookHashMap = new HashMap<>();
//
//    @Override
//    public void addBook(Book book) {
//        if (book != null) books.add(book);
//    }
//
//    @Override
//    public String borrowBook(String user, Book book) throws OutOfStockException, MaxBorrowedBooksException {
//        if (book != null && books.stream().anyMatch(book1 -> book1.equals(book) && book1.isAvailable())) {
//            if (bookHashMap.get(user) == null || (long) bookHashMap.get(user).size() <= 3) {
//                if (bookHashMap.get(user) == null) {
//                    bookHashMap.put(user, List.of(book));
//                } else {
//                    bookHashMap.get(user).add(book);
//                }
//            } else {
//                throw new MaxBorrowedBooksException();
//            }
//        } else {
//            throw new OutOfStockException();
//        }
//        return "";
//    }
//
//    @Override
//    public List<Book> getBooks() {
//        return new ArrayList<>(books);
//    }
//
//    @Override
//    public String viewLibraryInventory() {
//        return bookHashMap.toString();
//    }
//
//    // write code here...
//}
//
//class OutOfStockException extends Exception {
//    // write code here...
//}
//
//
//class MaxBorrowedBooksException extends Exception {
//    // write code here...
//}
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter out = new PrintWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int size = Integer.parseInt(br.readLine().trim());
//        String[] arr;
//        LibraryManagementSystem  lms = new LibraryManagementSystem(size);
//        int num = Integer.parseInt(br.readLine().trim());
//        for(int i = 1; i <= num; i++) {
//            arr = br.readLine().split(",");
//            Book item = new Book(arr[0], arr[1], Boolean.parseBoolean(arr[2]));
//            lms.addBook(item);
//        }
//
//        int numOps = Integer.parseInt(br.readLine().trim());
//        for(int i = 1; i <= numOps; i++) {
//            arr = br.readLine().split(",");
//            switch (arr[0]) {
//                case "borrowBook":
//                    out.println(lms.borrowBook(arr[1], lms.getBooks().get(Integer.parseInt(arr[2])-1)));
//                    out.println("");
//                    break;
//                case "viewLibrary":
//                    out.println(lms.viewLibraryInventory());
//                    break;
//            }
//        }
//        out.flush();
//        out.close();
//    }
//}
//
//
