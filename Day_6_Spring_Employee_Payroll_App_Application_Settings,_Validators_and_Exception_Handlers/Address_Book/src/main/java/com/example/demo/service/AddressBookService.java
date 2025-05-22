package com.example.demo.service;


import com.example.demo.dto.AddressBookDTO;
import com.example.demo.exception.AddressBookException;
import com.example.demo.model.AddressBookModel;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressBookService {
    private Map<Integer, AddressBookModel> addressBookMap = new HashMap<>();
    private int counter = 1;

    public AddressBookModel createEntry(AddressBookDTO dto) {
        AddressBookModel model = new AddressBookModel();
        model.setId(counter++);
        model.setName(dto.getName());
        model.setAddress(dto.getAddress());
        addressBookMap.put(model.getId(), model);
        return model;
    }

    public List<AddressBookModel> getAll() {
        return new ArrayList<>(addressBookMap.values());
    }

    public AddressBookModel getById(int id) {
        AddressBookModel model = addressBookMap.get(id);
        if (model == null)
            throw new AddressBookException("Address Book entry not found for id: " + id);
        return model;
    }

    public AddressBookModel updateEntry(int id, AddressBookDTO dto) {
        AddressBookModel model = getById(id);
        model.setName(dto.getName());
        model.setAddress(dto.getAddress());
        return model;
    }

    public void deleteEntry(int id) {
        if (addressBookMap.remove(id) == null)
            throw new AddressBookException("No entry found for deletion with id: " + id);
    }
}