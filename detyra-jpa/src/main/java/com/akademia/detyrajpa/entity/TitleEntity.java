package com.akademia.detyrajpa.entity;

import com.akademia.detyrajpa.entity.compositeprimarykeys.TitleEntityId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "titles")
public class TitleEntity {
    @EmbeddedId
    private TitleEntityId titleEntityId;
    @ManyToOne
    @MapsId("empNo")
    @JoinColumn(name="emp_no",referencedColumnName = "emp_no")
    private EmployeeEntity empNo;
    private LocalDate toDate;

    @Override
    public String toString() {
        return "TitleEntity{" +
                "titleEntityId=" + titleEntityId +
                ", empNo=" + empNo +
                ", toDate=" + toDate +
                '}';
    }
}
