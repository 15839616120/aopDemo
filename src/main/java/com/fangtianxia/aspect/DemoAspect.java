package com.fangtianxia.aspect;

import com.fangtianxia.annotation.AuthorityAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author wyz
 */
@Aspect
@Component
public class DemoAspect {

    @Pointcut("@annotation(com.fangtianxia.annotation.AuthorityAnnotation)")
    public void annotationPoinCut() {
    }

    /**
     * 编写使用注解的被拦截类
     * 模拟：切注解实现权限判断的功能
     */

    @Before("annotationPoinCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //拿到入参 然后可以记录入参
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.out.println(args.toString());
        AuthorityAnnotation annotation = method.getAnnotation(AuthorityAnnotation.class);
        //在这里拿到了注解，可以查询数据库进行权限判断，做一些其他的事情
        System.out.println("注解式拦截 " + annotation.name());
    }

    /**
     * 编写使用方法规则的被拦截类
     * 模拟：切方法实现记录入参出参的功能   用 @Before 和  @After 实现入参 和 出参 的功能
     */
    @Before("execution(* com.fangtianxia.controller.DemoMethodController.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] args = joinPoint.getArgs();
        System.out.println(args.toString());
        System.out.println("方法规则式拦截," + method.getName());
        System.out.println(method.getName() + "：记录入参");
    }

    /**
     * 后置通知的改进版本：这个版本可以拿到返回值
     */
    @AfterReturning(value = "execution(* com.fangtianxia.controller.DemoMethodController.*(..))", returning = "returnValue")
    public void afterMethod(JoinPoint joinPoint, Object returnValue) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截," + method.getName());
        System.out.println(method.getName() + "：记录出参");
        //returnValue 拿到了返回值  然后可以记录出参
        System.out.println(method.getName() + "返回值" + returnValue);
    }

    /*总结：
     * 记录入参和出参 只需要有个后置通知就ok了，在后置中既可以拿到入参，又可以拿到返回值出参
     * */

    //后置通知的原有版本：这个版本拿不到返回值
   /* @After(value="execution(* com.fangtianxia.controller.DemoMethodController.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截," + method.getName());
        System.out.println(method.getName() + "：记录出参");
    }*/

    /*
    AOP注解说明：
    @Aspect:定义切面：切面由切点和增强（引介）组成(可以包含多个切点和多个增强)，
            它既包括了横切逻辑的定义，也包括了连接点的定义，SpringAOP就是负责实施切面的框架，
            它将切面所定义的横切逻辑织入到切面所指定的链接点中。
    @Pointcut:定义切点：切点是一组连接点的集合。
              AOP通过“切点”定位特定的连接点。
              通过数据库查询的概念来理解切点和连接点的关系再适合不过了：连接点相当于数据库中的记录，而切点相当于查询条件。
    @Before:在目标方法被调用之前做增强处理,@Before只需要指定切入点表达式即可。
    @AfterReturning:在目标方法正常完成后做增强,@AfterReturning除了指定切入点表达式后，还可以指定一个返回值形参名returning,代表目标方法的返回值。
    @Afterthrowing:主要用来处理程序中未处理的异常,@AfterThrowing除了指定切入点表达式后，
                    还可以指定一个throwing的返回值形参名,可以通过该形参名来访问目标方法中所抛出的异常对象。
    @After:在目标方法完成之后做增强，无论目标方法时候成功完成。@After可以指定一个切入点表达式。
    @Around:环绕通知,在目标方法完成前后做增强处理,环绕通知是最重要的通知类型,像事务,日志等都是环绕通知,注意编程中核心是一个ProceedingJoinPoint。
    */
}
