package betc_generator.service;

import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;

import betc_generator.entity.User;
import betc_generator.repo.UserRepo;
import betc_generator.utill.Utill;

@org.springframework.context.annotation.Configuration
public class Generator implements ApplicationContextAware {
	private UserRepo userRepo;
	private ApplicationContext context;
	@Value("${worktime:30000}")
	long worktime;

	public Generator(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Bean
	public void pushUserToBd() throws InterruptedException {
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < worktime) {
			userRepo.save(User.getRandomUser());
			Thread.sleep(Utill.getRandomIntInRange(5000, 10000));
		}
		((AbstractApplicationContext) context).registerShutdownHook();
	}

	@Override
	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

	@PreDestroy
	public void destroyGenerator() {
		System.out.println("Service writes " + userRepo.count() + " records to DB");
	}

}
