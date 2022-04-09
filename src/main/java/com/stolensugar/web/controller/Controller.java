package com.stolensugar.web.controller;
import com.stolensugar.web.AppApplication;
import com.stolensugar.web.activity.CreateSpokenFormActivity;
import com.stolensugar.web.activity.CreateSpokenFormUserActivity;
import com.stolensugar.web.activity.CreateUserActivity;
import com.stolensugar.web.activity.GetAllUsersActivity;
import com.stolensugar.web.activity.GetUserActivity;
import com.stolensugar.web.activity.UpdateItemAlternativesActivity;
import com.stolensugar.web.dynamodb.models.SpokenFormModel;
import com.stolensugar.web.dynamodb.models.SpokenFormUserModel;
import com.stolensugar.web.dynamodb.models.UserModel;
import com.stolensugar.web.model.SpokenForm;
import com.stolensugar.web.model.requests.AlternativesMapper;
import com.stolensugar.web.model.requests.CreateSpokenFormRequest;
import com.stolensugar.web.model.requests.CreateSpokenFormUserRequest;
import com.stolensugar.web.model.requests.CreateUserRequest;
import com.stolensugar.web.model.requests.GetUserRequest;
import com.stolensugar.web.dagger.ApplicationComponent;

import com.stolensugar.web.model.requests.UpdateItemAlternativesRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;

@RestController
public class Controller {

     private static final ApplicationComponent component = AppApplication.component;

    @GetMapping(value = "/users/{id}", produces = {"application/json"})
    public ResponseEntity<?> getUser(@PathVariable String id) {
        GetUserActivity userActivity = component.provideGetUserActivity();
        GetUserRequest getUserRequest = GetUserRequest.builder().userId(id).build();
        return new ResponseEntity<>(userActivity.execute(getUserRequest), HttpStatus.OK);
    }

    @GetMapping(value = "/users", produces = {"application/json"})
    public ResponseEntity<?> getAllUsers() {
        GetAllUsersActivity getAllUsersActivity = component.provideGetAllUsersActivity();
        return new ResponseEntity<>(getAllUsersActivity.execute(), HttpStatus.OK);
    }

    @PostMapping(value = "/users", consumes = {"application/json"},
        produces = {"application/json"})
    public ResponseEntity<?> createUser(@Valid @RequestBody List<UserModel> users) {
    CreateUserActivity userActivity = component.provideCreateUserActivity();

    CreateUserRequest userRequest =
            CreateUserRequest.builder().users(users).build();

    return new ResponseEntity<>(userActivity.execute(userRequest), HttpStatus.OK);
    }

    @PostMapping(value = "/spokenformuser", consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> createSpokenFormUser(@Valid @RequestBody List<SpokenFormUserModel> spokenFormUsers) {
        CreateSpokenFormUserActivity spokenFormUserActivity = component.provideCreateSpokenFormUserActivity();

        CreateSpokenFormUserRequest spokenFormUserRequest =
                CreateSpokenFormUserRequest.builder().spokenFormUsers(spokenFormUsers).build();

        return new ResponseEntity<>(spokenFormUserActivity.execute(spokenFormUserRequest), HttpStatus.OK);
    }

    @PostMapping(value = "/spokenform/alternatives", consumes = {
            "application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> updateItemAlternatives(@Valid @RequestBody List<AlternativesMapper> updateItemList) {


        UpdateItemAlternativesActivity updateItemAlternativesActivity =
                component.provideUpdateItemAlternativesActivity();

        UpdateItemAlternativesRequest updateItemAlternativesRequest =
                UpdateItemAlternativesRequest.builder().alternativesMapperList(updateItemList).build();


        return new ResponseEntity<>(updateItemAlternativesActivity.execute(updateItemAlternativesRequest), HttpStatus.OK);
    }

    @PostMapping(value = "/spokenform", consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> createSpokenForm(@Valid @RequestBody List<SpokenFormModel> spokenForms) {
        CreateSpokenFormActivity spokenFormActivity = component.provideCreateSpokenFormActivity();

        CreateSpokenFormRequest spokenFormRequest =
                CreateSpokenFormRequest.builder().spokenForms(spokenForms).build();

        return new ResponseEntity<>(spokenFormActivity.execute(spokenFormRequest), HttpStatus.OK);
    }
}
