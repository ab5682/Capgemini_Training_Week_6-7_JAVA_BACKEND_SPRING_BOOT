package com.example.demo.service;

import com.example.demo.dto.AddressBookDTO;
import com.example.demo.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAll();
    AddressBookData getById(int id);
    AddressBookData create(AddressBookDTO dto);
    AddressBookData update(int id, AddressBookDTO dto);
    void delete(int id);
}