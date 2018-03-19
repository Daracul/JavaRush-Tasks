package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
*/
public class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
        System.out.println("Publis is "+String.format("%8s",Integer.toBinaryString(Modifier.PUBLIC)).replaceAll(" ","0"));
        System.out.println("Static is "+String.format("%8s",Integer.toBinaryString(Modifier.STATIC)).replaceAll(" ","0"));
        Method[] method = Solution.class.getDeclaredMethods();
        for (Method method1:method){
            System.out.println("method is "+" "+method1.getName()+" "+method1.getModifiers()+" "+String.format("%8s",Integer.toBinaryString(method1.getModifiers())).replaceAll(" ","0"));
        }
        System.out.println(Integer.toBinaryString(Modifier.PROTECTED));
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
//        boolean toReturn=false;
//        if (specificModifier==Modifier.PUBLIC){
//            toReturn=Modifier.isPublic(allModifiers);
//        }
//        if (specificModifier==Modifier.STATIC){
//            toReturn=Modifier.isStatic(allModifiers);
//        }
        return (allModifiers&specificModifier)==specificModifier;
    }

    protected static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
