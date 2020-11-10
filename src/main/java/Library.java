import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<HashMap> books;
    private HashMap recordTracker;
    private int capacity;

    public Library(int capacity) {
        this.books = new ArrayList<HashMap>();
        this.recordTracker = new HashMap<String, Integer>();
        this.capacity = capacity;
    }

    public int getBooks() {
        return this.books.size();
    }

    public void addBook(HashMap book) {
        if (this.getBooks() < this.capacity) {
            this.books.add(book);
        }
    }

    public HashMap removeBook(HashMap book) {
//        HashMap removedBook = this.books.get("")
        HashMap selectedBook = this.searchBook(book);
        int indexPosition = this.books.indexOf(book);
        this.books.remove(indexPosition);
        return selectedBook;
    }

    public HashMap searchBook(HashMap book) {
        HashMap currentBook;
        HashMap selectedBook = null;
        for (int i = 0; i < this.books.size(); i++) {
            currentBook = this.books.get(i);
            if (currentBook.get("Title") == book.get("Title")) {
                selectedBook = currentBook;
            }
        }
        return selectedBook;
    }


    public int getRecordTracker() {
        return this.recordTracker.size();
    }

    public void addGenre(String genre, Integer number) {
//        String value = this.recordTracker.get("Romance").toString();
        if (this.recordTracker.containsKey(genre)){
            int total = this.genreCount(genre);
            total += number;
            this.recordTracker.replace(genre, total);
        }
        else {
            this.recordTracker.put(genre, number);
        }

        System.out.println(this.recordTracker.get("Romance").toString());
    }

    public int genreCount(String genre){
        String total =  this.recordTracker.get(genre).toString();
        Integer number = Integer.parseInt(total);
        return number;
    }

}
