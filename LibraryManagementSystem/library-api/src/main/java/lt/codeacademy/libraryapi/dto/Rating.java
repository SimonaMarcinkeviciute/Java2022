package lt.codeacademy.libraryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.libraryapi.entity.RatingEntity;


import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private UUID id;
    private int rate;
    private Book book;
    private User user;

    public static Rating convert(RatingEntity ratingEntity)  {

        return new Rating(ratingEntity.getId(),
                ratingEntity.getRate(),
                Book.convert(ratingEntity.getBookEntity()),
                User.convert(ratingEntity.getUserEntity()));
    }
}
