package com.samrach.demo.testcase.persistence.service;

import com.samrach.demo.testcase.persistence.repository.BaseRepository;
import com.samrach.demo.testcase.persistence.request.BaseRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public abstract class BaseAbstractService<T extends BaseRequest<E>, E, ID> implements BaseService<T, E, ID> {
    protected final BaseRepository<E, ID> repository;

    public BaseAbstractService(BaseRepository<E, ID> repository) {
        this.repository = repository;
    }

    @Override
    public E create(T request) {
        return repository.save(request.toEntity());
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<E> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<E> findById(ID id) {
        return repository.findById(id);
    }


    @Override
    public void deleteAllById(List<ID> ids) {
        repository.deleteAllById(ids);
    }
}
