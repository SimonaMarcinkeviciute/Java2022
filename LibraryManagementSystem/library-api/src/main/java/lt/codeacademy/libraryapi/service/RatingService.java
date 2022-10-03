package lt.codeacademy.libraryapi.service;

import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.Rating;
import lt.codeacademy.libraryapi.dto.User;
import lt.codeacademy.libraryapi.entity.BookEntity;
import lt.codeacademy.libraryapi.entity.RatingEntity;
import lt.codeacademy.libraryapi.entity.UserEntity;
import lt.codeacademy.libraryapi.repository.RatingRepository;
import lt.codeacademy.libraryapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final BookService bookService;
    private final UserService userService;
    private final UserRepository userRepository;

    public RatingService(RatingRepository ratingRepository, BookService bookService, UserService userService, UserRepository userRepository) {
        this.ratingRepository = ratingRepository;
        this.bookService = bookService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public List<Long> addRating(int rate, UUID id, Principal principal) {
        Book book = bookService.getBook(id);
        User user = (User) userService.loadUserByUsername(principal.getName());

        RatingEntity ratingEntity = ratingRepository.findByBookEntityAndAndUserEntity(BookEntity.convert(book), UserEntity.convert(user));

        if(ratingEntity == null) {
           Rating rating = new Rating(null, rate, book, user);
            ratingRepository.save(RatingEntity.convert(rating));
            return countRatingByBook(book);
        }

        ratingEntity.setRate(rate);
        ratingRepository.save(ratingEntity);

        return countRatingByBook(book);
    }

    public List<Long> countRatingByBook(Book book) {
        List<Long> ratingInfo =new ArrayList<>();
        double rate = 0;
        List<RatingEntity> ratingEntities = ratingRepository.findByBookEntity(BookEntity.convert(book));

        if(ratingEntities.size() == 0) {
            ratingInfo.add(0, 0L);
            ratingInfo.add(1, 0L);
            return ratingInfo;
        }

        for (RatingEntity rating : ratingEntities) {
            rate += rating.getRate();
        }

        long b = Math.round(rate/ratingEntities.size());
        ratingInfo.add(0, (long) ratingEntities.size());
        ratingInfo.add(1, b);


        return ratingInfo;
    }

    public long getUserRating(UUID id, UUID userId) {
        Book book = bookService.getBook(id);
        User user = userRepository.findById(userId).map(User::convert).orElseThrow();

        RatingEntity rating = ratingRepository.findByBookEntityAndAndUserEntity(BookEntity.convert(book), UserEntity.convert(user));

        if(rating == null) {
            return 0;
        }
        return rating.getRate();

    }
}
