package com.apress.springrecipes.calculator;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// @Aspect
public class CalculatorPointcuts {

    // @Pointcut("execution(* *.*(..))")
    // @Pointcut("annotation(com.apress.springrecipes.calculator.LoggingRequired)") // 이건 왜 안되는지 확인 필요.
    // @Pointcut("within(com.apress.springrecipes.calculator..*)") // 패키지의 전체 메서드 실행 조인포인트를 매치
    // @Pointcut("within(com.apress.springrecipes.calculator.ArithmeticCalculatorImpl)")
    // @Pointcut("within(ArithmeticCalculatorImpl) || within(UnitCalculatorImpl)") // 패키지가 같은 위치에 있으면 패키지 제외
    // @Pointcut("within(ArithmeticCalculator+) || within(UnitCalculator+)") // 인터페이스를 구현한 모든 클래스의 메서드 실행 조인포인트 매치
    // @Pointcut("within(com.apress.springrecipes.calculator.LoggingRequired)") // 커스텀 에노테이션
    @Pointcut("arithmeticOperation() || unitOperation()") // 커스텀 에노테이션
    public void loggingOperation(){}

    @Pointcut("within(ArithmeticCalculator+)")
    public void arithmeticOperation(){}

    @Pointcut("within(UnitCalculator+)")
    public void unitOperation(){}

    @Pointcut("execution(* *.*(..)) && target(target) && args(a,b)")
    public void parameterPointcut(Object target, double a, double b){}

}
