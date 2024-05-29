package com.kahindi.briskspringdemo.employee_profile.records;

import java.io.Serializable;

public record MIGPersonRecord(
        String migPersonName,
        String migPersonCompany
) implements Serializable {
}
