package com.akademia.detyrajpa.entity.compositeprimarykeys;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DepartmentManagerEntityId implements Serializable {

    private Integer empNo;

    private String deptNo;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof DepartmentManagerEntityId that)) return false;
        return Objects.equals(empNo, that.empNo) && Objects.equals(deptNo, that.deptNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, deptNo);
    }

    @Override
    public String toString() {
        return "DepartmentManagerEntityId{" +
                "empNo=" + empNo +
                ", deptNo='" + deptNo + '\'' +
                '}';
    }
}
