package line2.line2_back3.image.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import line2.line2_back3.image.model.Image;
import line2.line2_back3.image.service.ImageService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/home")
@RequiredArgsConstructor
@CrossOrigin
public class ImageControllerImpl implements ImageController {
    private final ImageService imageService;

    @Override
    @PostMapping("/v1/image")
    public Image add(@RequestBody Image image) {
        try {
            log.info("ImageController add Image({}) start", image);
            return imageService.save(image);
        } catch (Exception e) {
            log.error("ImageController add Image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController add Image end");
        }
    }

    @Override
    @PutMapping("/v1/image")
    public Image edit(@RequestBody Image image) {
        try {
            log.info("ImageController edit Image({}) start", image);
            return imageService.save(image);
        } catch (Exception e) {
            log.error("ImageController edit Image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController edit Image end");
        }
    }

    @Override
    @GetMapping("/v1/image/{id}")
    public Image findById(@PathVariable Long id) {
        try {
            log.info("ImageController find by id Image(id: {}) start", id);
            return imageService.findById(id);
        } catch (Exception e) {
            log.error("ImageController find by id Image failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController find by id Image end");
        }
    }

    @Override
    @GetMapping("/v1/image/list")
    public List<Image> findAll() {
        try {
            log.info("ImageController find all Images start");
            return imageService.findAll();
        } catch (Exception e) {
            log.error("ImageController find all Images failure, error: {}", e.getMessage());
            return null;
        } finally {
            log.info("ImageController find all Images end");
        }
    }

    @Override
    @DeleteMapping("/v1/image/{id}")
    public void deleteById(@PathVariable Long id) {
        try {
            log.info("ImageController delete by id Image(id: {}) start", id);
            imageService.deleteById(id);
        } catch (Exception e) {
            log.error("ImageController delete by id Image failure, error: {}", e.getMessage());
        } finally {
            log.info("ImageController delete by id Image end");
        }
    }
}
