package com.worldinpictures.domain.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author Tsvetoslav Tsvetanov - Delta Source Bulgaria on 13.11.23
 */
@Entity
@Table(name = "comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Comment extends BaseEntity implements Serializable {

    @ManyToOne
    @Getter
    @NonNull
    private User owner;

    @Getter
    @NonNull
    private Timestamp createdAt;

    @Lob
    @NonNull
    @Getter
    private String text;

    public Comment(User owner, String text) {
        this.owner = owner;
        this.text = text;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }
}
