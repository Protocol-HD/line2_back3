package line2.line2_back3.image.controller;

import java.util.List;

import line2.line2_back3.image.model.Image;

public interface ImageController {
    Image add(Image image);

    Image edit(Image image);

    Image findById(Long id);

    List<Image> findAll();

    void deleteById(Long id);
}
