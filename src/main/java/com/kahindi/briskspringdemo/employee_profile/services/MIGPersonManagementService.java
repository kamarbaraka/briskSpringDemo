package com.kahindi.briskspringdemo.employee_profile.services;

import com.kahindi.briskspringdemo.employee_profile.records.MIGPersonRecord;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Slice;

public interface MIGPersonManagementService {


    void addMigPerson(@NotNull MIGPersonRecord migPersonRecord);

    MIGPersonRecord getMigPersonById(@NotNull Long id);

    Slice<MIGPersonRecord> getAllMigPersons(int page, int size);

    void deleteMigPersonById(@NotNull Long id);

}
