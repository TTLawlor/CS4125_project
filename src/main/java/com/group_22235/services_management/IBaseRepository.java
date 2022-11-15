package com.group_22235.services_management;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface IBaseRepository<T extends Carriage, E> extends JpaRepository<T, E> {
}
