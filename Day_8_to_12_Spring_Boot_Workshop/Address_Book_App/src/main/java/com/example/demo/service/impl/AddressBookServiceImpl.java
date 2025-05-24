package com.example.demo.service.impl;

import com.example.demo.dto.AddressBookDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AddressBookEntry;
import com.example.demo.repository.AddressBookRepository;
import com.example.demo.service.AddressBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService {
    @Autowired
    private AddressBookRepository repository;

    public AddressBookEntry createEntry(AddressBookDTO dto) {
        AddressBookEntry entry = new AddressBookEntry();
        BeanUtils.copyProperties(dto, entry);
        return repository.save(entry);
    }

    public List<AddressBookEntry> getAllEntries() {
        return repository.findAll();
    }

    public AddressBookEntry getEntryById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entry not found"));
    }

    public AddressBookEntry updateEntry(Long id, AddressBookDTO dto) {
        AddressBookEntry entry = getEntryById(id);
        BeanUtils.copyProperties(dto, entry);
        return repository.save(entry);
    }

    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }
}