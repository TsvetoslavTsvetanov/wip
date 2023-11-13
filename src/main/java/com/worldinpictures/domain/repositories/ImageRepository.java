package com.worldinpictures.domain.repositories;

import com.worldinpictures.domain.entities.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tsvetoslav Tsvetanov - Delta Source Bulgaria on 13.11.23
 */
@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {
}
