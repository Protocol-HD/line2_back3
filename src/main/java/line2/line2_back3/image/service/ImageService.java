package line2.line2_back3.image.service;

import java.util.List;

import line2.line2_back3.image.model.Image;

public interface ImageService {
    Image save(Image image);

    Image findById(Long id);

    List<Image> findAll();

    void deleteById(Long id);
}
