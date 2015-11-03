package com.mberro.urlshortener.domain.repository;

import com.mberro.urlshortener.domain.Redirection;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Marcus Berro on 24/10/15.
 */
public interface RedirectionRepository extends JpaRepository<Redirection, Long> {
}
