package com.avlasenko.sb.fmmanager.service;

import com.avlasenko.sb.fmmanager.model.FmInfo;
import com.avlasenko.sb.fmmanager.repository.fminfo.FmInfoJpaRepository;
import com.avlasenko.sb.fmmanager.util.exception.EntryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
@Service
public class FmInfoServiceImpl implements FmInfoService {

    @Autowired
    private FmInfoJpaRepository repository;

    @Override
    @Transactional
    public void save(FmInfo fmInfo, int ownerId) throws EntryNotFoundException {
        repository.save(fmInfo, ownerId);
    }

    @Override
    public FmInfo getByOwner(int ownerId) throws EntryNotFoundException {
        return repository.getByOwner(ownerId);
    }

    @Override
    @Transactional
    public void delete(int ownerId) throws EntryNotFoundException {
        repository.delete(ownerId);
    }
}