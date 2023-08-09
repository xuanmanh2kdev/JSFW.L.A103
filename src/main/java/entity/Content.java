package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Content extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false,length = 1000)
    private String brief;

    @Column(nullable = false,length = 1000)
    private String content;


    @Column
    private String sort;


    @ManyToOne
    @JoinColumn(name = "author_id")
    private Member member;
}
