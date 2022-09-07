package myapp.lifeinsurancecustomerwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myapp.lifeinsurancecustomerwebapp.model.Insuree;

@Repository
public interface InsureeRepository extends JpaRepository<Insuree, Long> {
}
