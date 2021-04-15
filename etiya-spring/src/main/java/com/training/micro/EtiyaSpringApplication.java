package com.training.micro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.training.micro.dep.injection.MyObject;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@ServletComponentScan
@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
@EnableEncryptableProperties
public class EtiyaSpringApplication implements ApplicationRunner {

    @Autowired
    @Qualifier("asd")
    private MyObject myObject;

    @Bean
    public AuditEventRepository auditEventRepository() {
        return new InMemoryAuditEventRepository(100);
    }


    @EventListener
    public void handleEvent(final AuditApplicationEvent aae) {
        AuditEvent auditEventLoc = aae.getAuditEvent();
        System.out.println(auditEventLoc);
    }

    public static void main(final String[] args) {
        SpringApplication.run(EtiyaSpringApplication.class,
                              args);
    }


    @Override
    public void run(final ApplicationArguments argsParam) throws Exception {
        this.myObject.setName("osman");
    }

}
