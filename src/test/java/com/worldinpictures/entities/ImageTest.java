package com.worldinpictures.entities;

import static com.worldinpictures.EntityCreationHelper.getImage;
import static com.worldinpictures.EntityCreationHelper.getUser;
import com.worldinpictures.domain.entities.Comment;
import com.worldinpictures.domain.entities.Image;
import com.worldinpictures.domain.entities.User;
import static org.hamcrest.CoreMatchers.hasItem;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

/**
 * @author Tsvetoslav Tsvetanov - Delta Source Bulgaria on 13.11.23
 */
public class ImageTest {

    @Test
    public void addCommentToImage() {

        User user = getUser();
        Comment comment = new Comment(user, "An interesting comment.");
        Image nude = getImage(user);

        nude.addComment(comment);
        MatcherAssert.assertThat(nude.getComments(), hasItem(comment));
    }
}
