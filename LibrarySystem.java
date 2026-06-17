// Practice 13: Library System
// Uses an interface so different book types can be searched in their own way.

interface Searchable {
    void search(String keyword);
}

class EBook implements Searchable {
    private String title;
    private String content;

    public EBook(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public void search(String keyword) {
        // For an eBook, searching means checking inside its text content.
        if (content.toLowerCase().contains(keyword.toLowerCase())) {
            System.out.println("Keyword found inside eBook: " + title);
        } else {
            System.out.println("Keyword not found inside eBook: " + title);
        }
    }
}

class PhysicalBook implements Searchable {
    private String title;
    private String shelfLocation;

    public PhysicalBook(String title, String shelfLocation) {
        this.title = title;
        this.shelfLocation = shelfLocation;
    }

    @Override
    public void search(String keyword) {
        // For a physical book, we only search the title and show where it is kept.
        if (title.toLowerCase().contains(keyword.toLowerCase())) {
            System.out.println("Physical book found on shelf " + shelfLocation + ": " + title);
        } else {
            System.out.println("No matching physical book title for keyword: " + keyword);
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Searchable ebook = new EBook("Java Basics", "This eBook explains interfaces and inheritance.");
        Searchable physicalBook = new PhysicalBook("Advanced Java Programming", "B-12");

        ebook.search("interface");
        physicalBook.search("java");
    }
}
