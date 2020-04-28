package com.minheum.app;

import com.minheum.app.Entity.*;
import com.minheum.app.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	private final PersonRepository personRepository;
	private final SocialMediaRepository socialMediaRepository;
	private final InterstsRepository interstsRepository;
	private final SkillRepository skillRepository;
	private final WorkRepository workRepository;
	private final LanguageRepository languageRepository;

	public AppApplication(PersonRepository personRepository, SocialMediaRepository socialMediaRepository, InterstsRepository interstsRepository, SkillRepository skillRepository, WorkRepository workRepository, LanguageRepository languageRepository) {
		this.personRepository = personRepository;
		this.socialMediaRepository = socialMediaRepository;
		this.interstsRepository = interstsRepository;
		this.skillRepository = skillRepository;
		this.workRepository = workRepository;
		this.languageRepository = languageRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		personRepository.save(new Person("박민흠", "백엔드", "hello@test.com", "010-1234-5678"));
		socialMediaRepository.save(new SocialMedia("anonymous", "anonymous"));
		interstsRepository.save(new Interests("드라마 감상"));
		interstsRepository.save(new Interests("게임"));
		interstsRepository.save(new Interests("음악 듣기"));
		skillRepository.save(new Skill("Django", 60));
		skillRepository.save(new Skill("Spring", 40));
		workRepository.save(new Work("운영진", "멋쟁이 사자처럼 경성대", "1년", "멋쟁이 사자처럼에서 Django, Django REST framework, React, Git 강의를 하였습니다."));
		languageRepository.save(new Language("Korean", "Native"));
		languageRepository.save(new Language("English", "Intermediate"));
		languageRepository.save(new Language("Japanese", "Intermediate"));
	}
}
