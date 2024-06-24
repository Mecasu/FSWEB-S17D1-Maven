package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals;

    @Value("project.developer.fullname")
    private String fullName;

    @Value("course.name")
    private String courseName;

    @PostConstruct
    public void loadAll() {
        animals = new HashMap<>();
    }


    @GetMapping
    public List<Animal> listAll() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("{id}")
    public Animal get(@PathVariable int id) {
        return animals.get(id);
    }

    @PostMapping
    public void add(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
    }

    @PutMapping("{id}")
    public Animal update(@PathVariable int id, @RequestBody Animal animal) {
        animals.replace(id, animal);
        return animals.get(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        animals.remove(id);
    }
}