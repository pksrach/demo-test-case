package com.samrach.demo.testcase.persistence.service;

import com.samrach.demo.testcase.persistence.request.BaseRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseRequest<E>, E, ID> {
    E create(T request);

    E update(ID id, T request);

    void delete(ID id);

    List<E> findAll();

    Page<E> findAll(Pageable pageable);

    Optional<E> findById(ID id);

    void deleteAllById(List<ID> ids);
}