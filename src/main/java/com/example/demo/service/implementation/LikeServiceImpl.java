package com.example.demo.service.implementation;

import com.example.demo.entity.Like;
import com.example.demo.entity.Pet;
import com.example.demo.repository.LikeRepository;
import com.example.demo.service.LikeService;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;

    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public void likeDislikePet(boolean likeValue, Long petFromId, Long petToId) {
        Like like = new Like(likeValue, new Pet(petFromId), new Pet(petToId));
        likeRepository.save(like);

    }

    @Override
    public Boolean isMatch(Long userFromId, Long userToId) {
        return likeRepository.isMatch(userFromId,userToId);
    }
}
