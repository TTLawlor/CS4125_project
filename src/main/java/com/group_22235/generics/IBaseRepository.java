package com.group_22235.generics;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface IBaseRepository<T extends ABaseEntity, E> extends JpaRepository<T, E> {
}
