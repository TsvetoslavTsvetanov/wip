package com.worldinpictures.repositories;

import com.worldinpictures.EntityCreationHelper;
import com.worldinpictures.domain.entities.Album;
import com.worldinpictures.domain.entities.User;
import com.worldinpictures.domain.repositories.AlbumRepository;
import com.worldinpictures.domain.repositories.ImageRepository;
import com.worldinpictures.domain.repositories.UserRepository;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Tsvetoslav Tsvetanov - Delta Source Bulgaria on 13.11.23
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class AlbumRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageRepository imageRepository;


    @Before
    public void before(){
        albumRepository.deleteAll();
        userRepository.deleteAll();
        imageRepository.deleteAll();
    }

    @Test
    public void createAlbum(){
        User user = createUserSave();
        Album album = createAlbumSave(user);
        assertThat(albumRepository.findById(album.getId()).get(), equalTo(album));
    }

    @Test
    public void createAlbumAndAddImages(){
        User user = createUserSave();
        Album album = createAlbumSave(user);
        album.addImage(EntityCreationHelper.getImage(user));
        assertThat(EntityCreationHelper.iteratorToList(imageRepository.findAll()), hasSize(1));

    }

    private Album createAlbumSave(User user) {
        Album album = EntityCreationHelper.getAlbum(user);
        albumRepository.save(album);
        return album;
    }

    private User createUserSave() {
        User user = EntityCreationHelper.getUser();
        userRepository.save(user);
        return user;
    }
}
