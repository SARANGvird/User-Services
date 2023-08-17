package com.Solution.in.serviceimpl;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Solution.in.exception.ResourceNotFoundException;
import com.Solution.in.model.Rating;
import com.Solution.in.model.User;
import com.Solution.in.repository.Userrepository;
import com.Solution.in.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Userrepository repo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return repo.save(user);
    }

    @Override
    public List<User> getAlluser() {
        return repo.findAll();
    }

    @Override
    public User getUser(String UserId) {
        User user = repo.findById(UserId).orElseThrow(() -> 
            new ResourceNotFoundException("User with given id not found on server: " + UserId));

        String ratingApiUrl = "http://localhost:8083/ratings/users/" + UserId;
        ResponseEntity<Rating> ratingResponse = restTemplate.getForEntity(ratingApiUrl, Rating.class);

        if (ratingResponse.getStatusCode().is2xxSuccessful()) {
            Rating rating = ratingResponse.getBody();
            if (rating != null) {
                // Check if the rating response is properly mapped to the Rating class
                System.out.println("Fetched Rating: " + rating.getRatingId()); // Debugging statement
                
                // Add the fetched rating to the user's ratings list
                user.getRatings().add(rating);
            } else {
                System.out.println("Rating is null"); // Debugging statement
            }
        } else {
            System.out.println("Rating API call failed with status: " + ratingResponse.getStatusCodeValue()); // Debugging statement
        }

        return user;
    }
}
