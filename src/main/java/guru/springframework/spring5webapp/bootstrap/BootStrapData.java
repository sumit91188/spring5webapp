package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author sumitdeo
 * @projectName spring5webapp
 * @package guru.springframework.spring5webapp.bootstrap
 * @date 9/16/20
 * @comment:
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher penguin = new Publisher("Penguin Ltd", "10 MG Road", "Mumbai", "440032");
        publisherRepository.save(penguin);

        Author sumit = new Author("Sumit", "Deo");
        Book effectiveJava = new Book("Effective Java", "123456");
        sumit.getBooks().add(effectiveJava);
        effectiveJava.getAuthors().add(sumit);
        effectiveJava.setPublisher(penguin);
        penguin.getBooks().add(effectiveJava);

        authorRepository.save(sumit);
        bookRepository.save(effectiveJava);
        publisherRepository.save(penguin);

        Author sneha = new Author("Sneha", "Pimpley");
        Book dataStruct = new Book("Data Structure & Algorithm", "987654");
        sneha.getBooks().add(dataStruct);
        dataStruct.getAuthors().add(sneha);
        dataStruct.setPublisher(penguin);
        penguin.getBooks().add(dataStruct);

        authorRepository.save(sneha);
        bookRepository.save(dataStruct);
        publisherRepository.save(penguin);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers of Books: " + penguin.getBooks().size());
    }
}
