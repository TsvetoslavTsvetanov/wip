package com.worldinpictures;

import com.worldinpictures.domain.entities.Album;
import com.worldinpictures.domain.entities.BaseEntity;
import com.worldinpictures.domain.entities.Image;
import com.worldinpictures.domain.entities.Location;
import com.worldinpictures.domain.entities.User;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tsvetoslav Tsvetanov - Delta Source Bulgaria on 13.11.23
 */
public class EntityCreationHelper {

    public static Image getImage(User efrem) {
        return Image.builder()
                   .fileUrl("/tmp/smileyFace.jpg")
                   .owner(efrem)
                   .title("A nice picture")
                   .location(new Location(0.0, 0.0))
                   .build();
    }

    public static User getUser() {
        return User.builder()
                   .email("tsvetoslavtsvetanov@detltasource.eu")
                   .firstName("Tsvetoslav")
                   .lastName("Tsvetanov")
                   .password("password")
                   .username("brabobjj")
                   .build();
    }

    public static Album getAlbum(User user){
        return new Album("deltasource", user, new Location(0.0,0.0));
    }

    public static <T extends BaseEntity> List<T> iteratorToList(Iterable<T> values){
        List<T> list = new ArrayList<>();
        values.forEach(list::add);
        return list;
    }
}
