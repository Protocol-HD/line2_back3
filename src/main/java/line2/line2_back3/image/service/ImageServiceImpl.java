package line2.line2_back3.image.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import line2.line2_back3.image.model.Image;
import line2.line2_back3.image.repository.ImageRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    public Image save(Image image) {
        try {
            log.info("ImageService save Image({}) start", image);
            return imageRepository.save(image);
        } catch (Exception e) {
            log.error("ImageService save Image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageService save Image end");
        }
    }

    @Override
    public Image findById(Long id) {
        try {
            log.info("ImageService find by id Image(id: {}) start", id);
            return imageRepository.findById(id).get();
        } catch (Exception e) {
            log.error("ImageService find by id Image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageService find by id Image end");
        }
    }

    @Override
    public List<Image> findAll() {
        try {
            log.info("ImageService find all Images start");
            return imageRepository.findAll();
        } catch (Exception e) {
            log.error("ImageService find all Images failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageService find all Images end");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            log.info("ImageService delete by id Image(id: {}) start", id);
            imageRepository.deleteById(id);
        } catch (Exception e) {
            log.error("ImageService delete by id Image failure, error: {}", e.getMessage());
        } finally {
            log.info("ImageService delete by id Image end");
        }
    }
}