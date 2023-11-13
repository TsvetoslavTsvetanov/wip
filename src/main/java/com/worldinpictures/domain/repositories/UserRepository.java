package com.worldinpictures.domain.repositories;

import com.worldinpictures.domain.entities.Album;
import com.worldinpictures.domain.entities.BaseEntity;
import com.worldinpictures.domain.entities.Image;
import com.worldinpictures.domain.entities.Location;
import com.worldinpictures.domain.entities.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tsvetoslav Tsvetanov - Delta Source Bulgaria on 13.11.23
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {


}
