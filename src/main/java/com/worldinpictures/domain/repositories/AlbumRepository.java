package com.worldinpictures.domain.repositories;

import com.worldinpictures.domain.entities.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tsvetoslav Tsvetanov - Delta Source Bulgaria on 13.11.23
 */
@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
}
