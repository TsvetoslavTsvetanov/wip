package com.worldinpictures.domain.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author Tsvetoslav Tsvetanov - Delta Source Bulgaria on 13.11.23
 */
@Entity
@Table(name = "album")
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Album extends BaseEntity implements Serializable {

    @Getter
    @NonNull
    private String title;

    @ManyToOne(optional = false)
    @Getter
    @NonNull
    private User owner;

    @Getter
    @Embedded
    private Location location;

    @Getter
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Image> images = new HashSet<>();

    @Getter
    private Timestamp createdAt;

    public Album(String title, User owner, Location location){
        this.title = title;
        this.owner = owner;
        this.location = location;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public void addImage(@NonNull Image image){
        this.images.add(image);
    }
}
