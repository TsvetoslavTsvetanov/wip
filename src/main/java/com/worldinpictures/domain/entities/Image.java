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
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author Tsvetoslav Tsvetanov - Delta Source Bulgaria on 13.11.23
 */
@Entity
@Table(name = "image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Image extends BaseEntity implements Serializable {

    @Getter
    private String title;

    @Embedded
    private Location location;

    @Getter
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne
    @Getter
    private User owner;

    @Getter
    private String fileUrl;

    @Getter
    private Timestamp createdAt;

    @Builder
    public Image(String title, Location location, Set<Comment> comments, User owner, String fileUrl) {
        this.title = title;
        this.location = location;
        if(comments != null) {
            this.comments = comments;
        }
        this.owner = owner;
        this.fileUrl = fileUrl;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public void addComment(@NonNull Comment comment){
        this.comments.add(comment);
    }
}
