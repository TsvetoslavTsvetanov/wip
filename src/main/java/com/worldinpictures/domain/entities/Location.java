package com.worldinpictures.domain.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Tsvetoslav Tsvetanov - Delta Source Bulgaria on 13.11.23
 */
@Embeddable
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Location implements Serializable {

    @Getter
    private Double lat;

    @Getter
    private Double lng;

}
