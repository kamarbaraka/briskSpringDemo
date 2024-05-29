package com.kahindi.briskspringdemo.employee_profile.services;

import com.kahindi.briskspringdemo.employee_profile.entities.MIGPerson;
import com.kahindi.briskspringdemo.employee_profile.records.MIGPersonRecord;
import com.kahindi.briskspringdemo.employee_profile.repositories.MIGPersonRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MIGPersonManagementServiceImpl implements MIGPersonManagementService {

    private final MIGPersonRepository repository;

    @Transactional
    @Override
    public void addMigPerson(@NotNull MIGPersonRecord migPersonRecord) {

        MIGPerson migPerson = MIGPerson.builder()
                .migPersonName(migPersonRecord.migPersonName())
                .migPersonCompany(migPersonRecord.migPersonCompany())
                .build();

        repository.save(migPerson);
    }

    @Override
    public MIGPersonRecord getMigPersonById(@NotNull Long id) {

        return repository.findById(id)
                .map(person -> new MIGPersonRecord(person.getMigPersonName(), person.getMigPersonCompany()))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Slice<MIGPersonRecord> getAllMigPersons( int page, int size) {

        Slice<MIGPerson> migPersons = repository.findAll(PageRequest.of(page, size));
        List<MIGPersonRecord> migPersonRecords = migPersons.stream()
                .map(person -> new MIGPersonRecord(person.getMigPersonName(), person.getMigPersonCompany()))
                .toList();
        return new SliceImpl<>(migPersonRecords);
    }

    @Transactional
    @Override
    public void deleteMigPersonById(@NotNull Long id) {

        repository.deleteById(id);
    }
}
