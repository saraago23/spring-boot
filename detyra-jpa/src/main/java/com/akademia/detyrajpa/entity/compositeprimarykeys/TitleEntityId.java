package com.akademia.detyrajpa.entity.compositeprimarykeys;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class TitleEntityId implements Serializable {

    private Integer empNo;

    private String title;
    private LocalDate fromDate;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof TitleEntityId that)) return false;
        return Objects.equals(empNo, that.empNo) && Objects.equals(title, that.title) && Objects.equals(fromDate, that.fromDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, title, fromDate);
    }

    @Override
    public String toString() {
        return "TitleEntityId{" +
                "empNo=" + empNo +
                ", title='" + title + '\'' +
                ", fromDate=" + fromDate +
                '}';
    }
}
