package com.training.micro.aop;

import java.util.Collection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Enforcer {

    private static final Logger logger = LoggerFactory.getLogger(Enforcer.class);

    @Before("execution(* com.training.micro.aop.Callee.*(..)) && args(str)")
    //    @After
    //    @AfterReturning
    //    @AfterThrowing
    //    @Around
    public void beforeCut(final String str) {
        System.out.println("Before Callee : " + str);
    }

    //    @After
    @AfterReturning(value = "execution(* com.training.micro.aop.Callee.*(..)) && args(str)", returning = "ret")
    //    @AfterThrowing
    //    @Around
    public void afterCut(final String str,
                         final String ret) {
        System.out.println("After Callee : " + str + " Return : " + ret);
    }

    @Around(value = "execution(* com.training.micro.aop.Callee.*(..)) ")
    public Object aroundCut(final ProceedingJoinPoint joinPointParam) {
        try {
            Object[] argsLoc = joinPointParam.getArgs();
            String kindLoc = joinPointParam.getKind();
            Signature signatureLoc = joinPointParam.getSignature();

            Enforcer.logger.info("Before Method Call Kind : "
                                 + kindLoc
                                 + " Sig : "
                                 + signatureLoc
                                 + " args : "
                                 + argsLoc);
            Object proceedLoc = joinPointParam.proceed();
            Enforcer.logger.info("After Method Call return : " + proceedLoc);

            String str = (String) proceedLoc;
            return str + " Enforced";
        } catch (Throwable eLoc) {
        }
        return null;
    }

    @Around(value = "@annotation(sm)")
    public Object aroundSecure(final ProceedingJoinPoint joinPointParam,
                               final SecureMe sm) throws Throwable {
        try {
            Authentication authenticationLoc = SecurityContextHolder.getContext()
                                                                    .getAuthentication();
            String valueLoc = sm.value();
            Collection<? extends GrantedAuthority> authoritiesLoc = authenticationLoc.getAuthorities();
            boolean cont = false;
            for (GrantedAuthority grantedAuthorityLoc : authoritiesLoc) {
                if (valueLoc.equalsIgnoreCase(grantedAuthorityLoc.getAuthority())) {
                    cont = true;
                }
            }
            if (cont) {
                return joinPointParam.proceed();
            } else {
                throw new SecurityException("Problem");
            }
        } catch (Throwable eLoc) {
            throw eLoc;
        }
    }


}
