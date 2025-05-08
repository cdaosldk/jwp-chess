package chess.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {
    @Id
    private Long id;

    public Long getId() {
        return id;
    }
}
