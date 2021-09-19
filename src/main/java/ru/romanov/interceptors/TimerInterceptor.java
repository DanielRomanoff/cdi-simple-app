package ru.romanov.interceptors;

import ru.romanov.annotations.Timer;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Timer
@Interceptor
public class TimerInterceptor {
    @AroundInvoke
    public Object profile(InvocationContext invocationContext) throws Exception{
        long initTime = System.nanoTime();
        try {
            return invocationContext.proceed();
        }finally{
            long Time = System.nanoTime()- initTime;
            System.out.println(invocationContext.getMethod()+ "completed for " + Time + " ns.");
        }
    }
}
