package com.example.demo.service;

public interface LikeService {
    void likeDislikePet(boolean like, Long petFromId, Long petToId);
    Boolean isMatch(Long userFromId, Long userToId);
}
