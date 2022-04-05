package line2.line2_back3.image.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import line2.line2_back3.image.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
