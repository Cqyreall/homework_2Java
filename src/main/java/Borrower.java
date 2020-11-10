import java.util.ArrayList;
import java.util.HashMap;

public class Borrower {

    private ArrayList<HashMap> collection;

    public Borrower() {
        this.collection = new ArrayList<HashMap>();
    }

    public int getCollection() {
        return this.collection.size();
    }

    public void addToCollection(HashMap book){
        this.collection.add(book);
    }
}
