package com.akademia.detyrajpa.entity.compositeprimarykeys;

import com.akademia.detyrajpa.entity.EmployeeEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SalaryEntityId implements Serializable {

    private Integer empNo;
    private LocalDate fromDate;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof SalaryEntityId that)) return false;
        return Objects.equals(empNo, that.empNo) && Objects.equals(fromDate, that.fromDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, fromDate);
    }

    @Override
    public String toString() {
        return "SalaryEntityId{" +
                "empNo=" + empNo +
                ", fromDate=" + fromDate +
                '}';
    }
}
