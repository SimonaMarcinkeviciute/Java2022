package lt.codeacademy.libraryapi.service;

import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.Rating;
import lt.codeacademy.libraryapi.entity.BookEntity;
import lt.codeacademy.libraryapi.entity.RatingEntity;
import lt.codeacademy.libraryapi.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final BookService bookService;

    public RatingService(RatingRepository ratingRepository, BookService bookService) {
        this.ratingRepository = ratingRepository;
        this.bookService = bookService;
    }

    public long addRating(int rate, UUID id) {
        Book book = bookService.getBook(id);
        Rating rating = new Rating(null, rate, book);

        ratingRepository.save(RatingEntity.convert(rating));
        return countRatingByBook(book);
    }

    public long countRatingByBook(Book book) {
        int rate = 0;
        List<RatingEntity> ratingEntities = ratingRepository.findByBookEntity(BookEntity.convert(book));

        for (RatingEntity rating : ratingEntities) {
            rate += rating.getRate();
        }

        return Math.round(rate/ratingEntities.size());
    }
}
