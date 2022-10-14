package com.emeraldhieu.app.photo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultPhotoService implements PhotoService {

    private final PhotoClient photoClient;

    @Override
    public List<Photo> getPhotos() {
        return photoClient.getPhotos();
    }
}
