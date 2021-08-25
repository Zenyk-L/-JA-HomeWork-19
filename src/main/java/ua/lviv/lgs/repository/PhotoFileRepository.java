package ua.lviv.lgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.PhotoFile;

@Repository
public interface PhotoFileRepository extends JpaRepository<PhotoFile, String> {

}
