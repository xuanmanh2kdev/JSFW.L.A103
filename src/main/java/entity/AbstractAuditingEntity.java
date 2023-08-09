package entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractAuditingEntity {
    @Column
    private LocalDate createdDate;

    @Column
    private LocalDate updateTime;

    @Column
    private boolean deleted;
}
