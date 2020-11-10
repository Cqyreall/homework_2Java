import org.junit.Before;
import org.junit.Test;

import java.awt.print.Book;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class LibraryTest {


    private Library library;
    private HashMap book1;
    private HashMap book2;
    private HashMap book3;
    private HashMap genreCollection;
    private Borrower cyril;

    @Before
    public void before(){
        library = new Library(3);
        cyril = new Borrower();

        book1 = new HashMap<String, String>();
        book1.put("Title", "Game of Thrones");
        book1.put("Author", "GRRM");
        book1.put("Genre", "Fantasy");

        book2 = new HashMap<String, String>();
        book2.put("Title", "Harry Potter");
        book2.put("Author", "J.K Rowling");
        book2.put("Genre", "Adventure");

        book3 = new HashMap<String, String>();
        book3.put("Title", "Devil in the White City");
        book3.put("Author", "Erik Larson");
        book3.put("Genre", "Crime");

        genreCollection = new HashMap<String, Integer>();
        genreCollection.put("Romance", 1);
        genreCollection.put("Fantasy", 4);
        genreCollection.put("Adventure", 5);
    }

    @Test
    public void libraryAddsBooks(){
        library.addBook(book1);
        assertEquals(1, library.getBooks());
    }

    @Test
    public void libraryAddBooks(){
        library.addBook(book1);
        library.addBook(book1);
        assertEquals(2, library.getBooks());
    }

    @Test
    public void libraryisFull(){
        library.addBook(book1);
        library.addBook(book1);
        library.addBook(book1);
        library.addBook(book1);
        assertEquals(3, library.getBooks());
    }

    @Test
    public void libraryReturnsSelectedBook(){
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(book2, library.searchBook(book2));
    }

    @Test
    public void libraryremovesSelectedBook(){
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(book1, library.removeBook(book1));
    }

    @Test
    public void bookBorrowed(){
        library.addBook(book1);
        library.addBook(book2);
        cyril.addToCollection(library.removeBook(book2));
        assertEquals(1, library.getBooks());
        assertEquals(1, cyril.getCollection());
    }

    @Test
    public void libraryHasGenreCollection(){
        library.addGenre("Romance", 1);
        assertEquals(1, library.getRecordTracker());
    }

    @Test
    public void checkSum(){
        library.addGenre("Romance", 1);
        library.addGenre("Romance", 1);
        library.addGenre("Crime", 3);
        assertEquals(2, library.genreCount("Romance"));
        assertEquals(3, library.genreCount("Crime"));
    }




}
