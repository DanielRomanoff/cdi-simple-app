package ru.romanov.interceptors;

import ru.romanov.annotations.Timer;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Timer
@Interceptor
public class TimerInterceptor {
    @AroundInvoke
    public Object profile(InvocationContext ic) throws Exception{
        long initTime = System.currentTimeMillis();
        try {
            return ic.proceed();
        }finally{
            long Time = System.currentTimeMillis()- initTime;
            System.out.println(ic.getMethod()+ "completed for " + Time + " ms.");
        }
    }
}
