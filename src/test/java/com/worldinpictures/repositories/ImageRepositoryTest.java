package com.worldinpictures.repositories;

import static com.worldinpictures.EntityCreationHelper.getImage;
import static com.worldinpictures.EntityCreationHelper.getUser;
import com.worldinpictures.domain.entities.Comment;
import com.worldinpictures.domain.entities.Image;
import com.worldinpictures.domain.entities.User;
import com.worldinpictures.domain.repositories.ImageRepository;
import com.worldinpictures.domain.repositories.UserRepository;
import java.util.Optional;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Tsvetoslav Tsvetanov - Delta Source Bulgaria on 13.11.23
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ImageRepositoryTest {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void persistAnImage(){
        User efrem = getUser();
        Image image = getImage(efrem);
        imageRepository.save(image);
    }

    @Test
    public void updateAnImage(){
        User user = getUser();
        Image image = getImage(user);
        Image persistedImage = imageRepository.save(image);
        Comment comment = new Comment(user, "Hoi image");
        persistedImage.addComment(comment);

        Optional<Image> fetchedImage = imageRepository.findById(persistedImage.getId());
        assertTrue(fetchedImage.isPresent());
        assertThat(fetchedImage.get().getComments(), Matchers.hasSize(1));
    }

    @Test
    public void deleteAnImage(){
        User efrem = getUser();
        userRepository.save(efrem);
        Image image = getImage(efrem);
        imageRepository.save(image);
        Comment comment = new Comment(efrem, "Hoi image");
        image.addComment(comment);
        assertThat(imageRepository.count(), equalTo(1L));

        imageRepository.deleteById(image.getId());
        assertThat(imageRepository.count(), equalTo(0L));
    }
}
