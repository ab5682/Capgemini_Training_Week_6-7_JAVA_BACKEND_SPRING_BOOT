package com.example.demo.service;
import com.example.demo.dto.AddressBookDTO;
import com.example.demo.model.AddressBookEntry;

import java.util.List;

public interface AddressBookService {
    AddressBookEntry createEntry(AddressBookDTO dto);
    List<AddressBookEntry> getAllEntries();
    AddressBookEntry getEntryById(Long id);
    AddressBookEntry updateEntry(Long id, AddressBookDTO dto);
    void deleteEntry(Long id);
}