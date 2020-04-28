package com.minheum.app.controller;

import com.minheum.app.Entity.*;
import com.minheum.app.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    private final PersonRepository personRepository;
    private final SocialMediaRepository socialMediaRepository;
    private final InterstsRepository interstsRepository;
    private final SkillRepository skillRepository;
    private final WorkRepository workRepository;
    private final LanguageRepository languageRepository;

    public IndexController(PersonRepository personRepository, SocialMediaRepository socialMediaRepository, InterstsRepository interstsRepository, SkillRepository skillRepository, WorkRepository workRepository, LanguageRepository languageRepository) {
        this.personRepository = personRepository;
        this.socialMediaRepository = socialMediaRepository;
        this.interstsRepository = interstsRepository;
        this.skillRepository = skillRepository;
        this.workRepository = workRepository;
        this.languageRepository = languageRepository;
    }

    @GetMapping("/")
    public String index(Model model){
        Person person = personRepository.findAll().stream().findFirst().orElse(null);
        model.addAttribute("person", person);
        SocialMedia socialMedia = socialMediaRepository.findAll().stream().findFirst().orElse(null);
        model.addAttribute("socialMedia", socialMedia);
        List<Interests> intersts = interstsRepository.findAll();
        model.addAttribute("interests", intersts);
        List<Skill> skills = skillRepository.findAll();
        model.addAttribute("skills",skills);
        List<Work> works = workRepository.findAll();
        model.addAttribute("works",works);
        List<Language> languages = languageRepository.findAll();
        model.addAttribute("languages", languages);
        return "resume";
    }
}